package myPkg;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MyFrame extends JFrame implements KeyListener, ActionListener, MouseListener {
	
	private static final long serialVersionUID = 1L;
	static private MyFrame frame;
	private MyPanel panel;
	private int width;
	private int height;
	private Timer timer;
	private java.util.Timer timer2;
	private boolean press;
	private int key;
	private Random generator;
	private boolean game = true;
	
	private double z;
	private double a;
	private int dx;
	
	class MyTimerTask extends TimerTask{

		@Override
		public void run() {
			panel.repaint();
			
		}
		
	}
	MyTimerTask timer2_task;

	public MyFrame() {
		initComponent();
		width = 1000;
		height = 720;
		timer = new Timer(20, this);
		timer.setInitialDelay(0);
		timer.setCoalesce(true);
		generator = new Random();
		
		timer2_task = new MyTimerTask();
		timer2 = new java.util.Timer();
		timer2.schedule(timer2_task, 0, 7 );
		
	}

	private void initComponent() {
		panel = new MyPanel();
		add(panel);

		addKeyListener(this);
		addMouseListener(this);
	}

	public static void main(String[] args) {
		frame = new MyFrame();
		frame.setBackground(Color.gray);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.setTitle("Arkanoid");
				frame.setResizable(false);
				frame.setLocation(0, 0);
				frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.timer.start();
				
			}
		});

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		press = true;
		key = arg0.getKeyCode();
		if (arg0.getKeyChar() == 'p') {
			game = !game;
			panel.getGame().pause();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		press = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (game) {
			int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
			panel.getGame().getPaddle().setX((mouseX - (int) panel.getGame().getPaddle().getWidth() / 2));

			// if(press){
			// for(int i=0;i<2;i++){
			// if( key == KeyEvent.VK_RIGHT)
			// paddle.toRight();
			// if( key == KeyEvent.VK_LEFT)
			// paddle.toLeft();
			// panel.repaint();
			// }
			// }
			
			Paddle paddle = panel.getGame().getPaddle();
			List<Drop> drop = panel.getGame().getDrop();
			List<Ball> balls = panel.getGame().getBall();
			List<Box> box = panel.getGame().getBox();

			for (int i = 0; i < balls.size(); i++) {
				// jezeli jest przylepiona
				if (balls.get(i).isStick()) {
					balls.get(i).setX( paddle.getX() - balls.get(i).getPaddleX()  + balls.get(i).getX() );
					balls.get(i).setPaddleX(paddle.getX());
					
				} else {
					//SCIANY
					if (balls.get(i).getX() - Math.abs(balls.get(i).getVx()) <= 10|| balls.get(i).getX() + balls.get(i).getRadius()	+ Math.abs(balls.get(i).getVx()) >= 1010) {
						// balls.get(i).setVx(0);
						// System.out.println(balls.get(i).getX());
						balls.get(i).setOppositeVx();
					}//SUFIT
					if (balls.get(i).getVy()<0 && balls.get(i).getY() + balls.get(i).getVy() <= 10){
						balls.get(i).setOppositeVy();
						System.out.println("SUFIT " + balls.get(i).getY() + " " + balls.get(i).getVy());
					}
						

					if (balls.get(i).getY() + balls.get(i).getRadius()+ balls.get(i).getVy() >= paddle.getY()&& balls.get(i).getY() <= paddle.getY()+ paddle.getHeight())
						if (balls.get(i).getX()+ (int) (balls.get(i).getRadius() / 2) >= paddle.getX()&& balls.get(i).getX()+ (int) (balls.get(i).getRadius() / 2) <= paddle.getX() + paddle.getWidth()) {
							// odbicie piłki jak od okręgu o promieniu r
							int r = paddle.getR();
							dx = paddle.getX()+ (int) ((double) paddle.getWidth() / 2)- balls.get(i).getX()+ (int) (balls.get(i).getRadius() / 2);
							z = Math.sqrt(Math.pow(r, 2) - Math.pow(dx, 2));
							a = (double) Math.abs(balls.get(i).getVy()) / z;
							System.out.println(dx * a);
							balls.get(i).setOppositeVy();
							balls.get(i).setVx((int) (-dx * a));
							if(panel.getGame().isBonusStick())
								panel.getGame().stickOn(i, paddle.getX());
						}

					// piłka poniżej pada
					if (balls.get(i).getY()	+ (int) (balls.get(i).getRadius() / 2) > paddle.getY()) {balls.get(i).dead();
						// System.out.println("deaddd" + balls.get(i).getY());
					}
					// uderzenie o boxy
					for (int j = 0; j < box.size(); j++) {

						if (box.get(j).isExist()) {
							// prawo
							if (balls.get(i).getVx() < 0 
									&& balls.get(i).getY()+ (int) (balls.get(i).getRadius() / 2) >= box.get(j).getY() - 3 
									&& balls.get(i).getY()+ (int) (balls.get(i).getRadius() / 2) <= box.get(j).getY()+ 3+ box.get(j).getHeight()
									&& balls.get(i).getX()- Math.abs(balls.get(i).getVx()) <= box.get(j).getX()	+ box.get(j).getWidth()
									&& balls.get(i).getX()- Math.abs(balls.get(i).getVx()) >= box.get(j).getX()+ box.get(j).getWidth()- Math.abs(balls.get(i).getVx())
									) {

								balls.get(i).setOppositeVx();
								panel.getGame().destroy(j);
								// balls.get(i).setVx(0);
								// balls.get(i).setVy(0);
								panel.getGame().addScore(10);
								panel.setEvent(true);

							}
							// lewo

							else if (balls.get(i).getVx() > 0
									&& balls.get(i).getY() + (int) (balls.get(i).getRadius() / 2) >= box.get(j).getY() - 3
									&& balls.get(i).getY() + (int) (balls.get(i).getRadius() / 2) <= box.get(j).getY()+ box.get(j).getHeight() + 3
									&& balls.get(i).getX() + balls.get(i).getRadius() <= box.get(j).getX()+ balls.get(i).getVx()
									&& balls.get(i).getX() + balls.get(i).getRadius() + Math.abs(balls.get(i).getVx()) >= box.get(j).getX()
									&& balls.get(i).getX()+ balls.get(i).getRadius() <= box.get(j).getX()+ Math.abs(balls.get(i).getVx())
									) {

								balls.get(i).setOppositeVx();
								panel.getGame().destroy(j);
								// balls.get(i).setVx(0);
								// balls.get(i).setVy(0);
								panel.getGame().addScore(10);
								panel.setEvent(true);

							}
							// dól
							else if (balls.get(i).getVy() < 0
									&& balls.get(i).getY() <= box.get(j).getY()+ box.get(j).getHeight()- balls.get(i).getVy()
									&& balls.get(i).getY() >= box.get(j).getY()+ box.get(j).getHeight() - 1) {
								if (balls.get(i).getX()+ (int) (balls.get(i).getRadius() / 2) >= box.get(j).getX() - 3
										&& balls.get(i).getX()+ (int) (balls.get(i).getRadius() / 2) <= box.get(j).getX()+ box.get(j).getWidth() + 3
										) {
									balls.get(i).setOppositeVy();
									panel.getGame().destroy(j);
									// balls.get(i).setVx(0);
									// balls.get(i).setVy(0);
									panel.getGame().addScore(10);
									panel.setEvent(true);
								}
							}
							// gora
							else if (balls.get(i).getVy() > 0
									&& balls.get(i).getY()+ balls.get(i).getRadius() >= box.get(j).getY()- Math.abs(balls.get(i).getVy())
									&& balls.get(i).getY()+ balls.get(i).getRadius() < box.get(j).getY()+ Math.abs(balls.get(i).getVy())) {
								if (balls.get(i).getX()+ (int) (balls.get(i).getRadius() / 2) >= box.get(j).getX() - 3
										&& balls.get(i).getX()+ (int) (balls.get(i).getRadius() / 2) <= box.get(j).getX()+ box.get(j).getWidth() + 3
										) {
									balls.get(i).setOppositeVy();
									panel.getGame().destroy(j);
									// balls.get(i).setVx(0);
									// balls.get(i).setVy(0);
									panel.getGame().addScore(10);
									panel.setEvent(true);
								}
							}
						}

					}

				}
				// removing ball
				if (!balls.get(i).isAlive()&& balls.get(i).getY() + balls.get(i).getRadius()+ balls.get(i).getVy() >= 730) {
					balls.remove(i);
					
					if(panel.getGame().getLive() > 0 && balls.isEmpty()){
						panel.getGame().addBall();
						panel.getGame().subLive();
						panel.setEvent(true);
					}
						
				}

			}
			// zbieranie dropów
			for (int i = 0; i < drop.size(); i++) {
				// usuwanie dropów
				if (drop.get(i).getY() + drop.get(i).getVy() >= 720)
					drop.remove(i);
				else if (drop.get(i).getY() + drop.get(i).getHeight() >= paddle.getY()&& drop.get(i).getY() <= paddle.getY()+ paddle.getHeight())
					if (drop.get(i).getX() + drop.get(i).getWidth() >= paddle.getX()&& drop.get(i).getX() <= paddle.getX()+ paddle.getWidth()) {
						panel.getGame().collectDrop(drop.get(i));
						drop.remove(i);
					
					}

			}

//			panel.repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(game)
			panel.getGame().stickOff();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
