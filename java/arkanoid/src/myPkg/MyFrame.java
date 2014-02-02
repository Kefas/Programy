package myPkg;

import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MyFrame extends JFrame implements KeyListener, ActionListener {
	static private MyFrame frame;
	private MyPanel panel;
	private int width;
	private int height;
	private Timer timer;
	private boolean press;
	private int key;
	private Random generator;
	private boolean game = true;
	private int r;
	private double z;
	private double a;
	private int dx;
	
	
	public MyFrame(){
		initComponent();
		width= 1000;
		height = 720;
		timer = new Timer(10,this);
		timer.setInitialDelay(0);
		timer.setCoalesce(true);
		generator = new Random();
		r = 140;
		
	}
	
	private void initComponent() {
		panel = new MyPanel();
		add(panel);
		
		addKeyListener(this);
	}

	public static void main(String[] args) {
		frame = new MyFrame();
	
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.setTitle("Arkanoid");
				frame.setResizable(false);
				frame.setLocation(0,0);
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
		if(arg0.getKeyChar() == 'p'){
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
		if(game){
			int mouseX = (int)MouseInfo.getPointerInfo().getLocation().getX();
			panel.getGame().getPaddle().setX((mouseX - (int)panel.getGame().getPaddle().getWidth()/2));
			
			
	//		if(press){
	//			for(int i=0;i<2;i++){
	//			if( key == KeyEvent.VK_RIGHT)
	//				paddle.toRight();
	//			if( key == KeyEvent.VK_LEFT)
	//				paddle.toLeft();
	//			panel.repaint();
	//			}
	//		}
			Paddle paddle = panel.getGame().getPaddle();
			List<Drop> drop = panel.getGame().getDrop();
			List<Ball> balls = panel.getGame().getBall();
			
			
			for(int i=0;i<balls.size();i++){
				if(balls.get(i).getX() - Math.abs(balls.get(i).getVx()) <= 10 || balls.get(i).getX() + balls.get(i).getRadius() + Math.abs(balls.get(i).getVx()) >= 1010)
					{
	//				balls.get(i).setVx(0);
//					System.out.println(balls.get(i).getX());
					balls.get(i).setOppositeVx();
					}
				if(balls.get(i).getY() - Math.abs(balls.get(i).getVy()) <= 10 )
					balls.get(i).setOppositeVy();
				
				if(balls.get(i).getY() + balls.get(i).getRadius() + balls.get(i).getVy() >= paddle.getY() && balls.get(i).getY() <= paddle.getY() + paddle.getHeight())
					if(balls.get(i).getX() + (int)(balls.get(i).getRadius()/2) >= paddle.getX()  && balls.get(i).getX() + (int)(balls.get(i).getRadius()/2) <= paddle.getX() + paddle.getWidth()){
						//odbicie piłki jak od okręgu o promieniu r 
						dx = paddle.getX() + (int)((double)paddle.getWidth()/2)  - balls.get(i).getX() + (int)(balls.get(i).getRadius()/2);
						z = Math.sqrt(Math.pow(r, 2) - Math.pow(dx, 2));
						a = (double)Math.abs(balls.get(i).getVy())/z;
						System.out.println(dx*a);
						balls.get(i).setOppositeVy();
						balls.get(i).setVx((int)(-dx*a));
						
				}
				
				
				// piłka poniżej pada
				if(balls.get(i).getY() + (int)(balls.get(i).getRadius()/2) > paddle.getY()){
					balls.get(i).dead();
//					System.out.println("deaddd" + balls.get(i).getY());
				}
				//uderzenie o boxy	
				for(int j=0;j<panel.getGame().getBox().size();j++){
					// lewo i prawo się psuje.
					if(panel.getGame().getBox().get(j).isExist()){
	//					prawo
						if(balls.get(i).getVx() < 0 && balls.get(i).getY()+ (int)(balls.get(i).getRadius()/2) >= panel.getGame().getBox().get(j).getY() - 3 && balls.get(i).getY()+ (int)(balls.get(i).getRadius()/2) <= panel.getGame().getBox().get(j).getY()+3 + panel.getGame().getBox().get(j).getHeight()  && balls.get(i).getX() - Math.abs(balls.get(i).getVx()) <= panel.getGame().getBox().get(j).getX() + panel.getGame().getBox().get(j).getWidth() && balls.get(i).getX() - Math.abs(balls.get(i).getVx()) >= panel.getGame().getBox().get(j).getX() + panel.getGame().getBox().get(j).getWidth() - Math.abs(balls.get(i).getVx())){
					 	
								balls.get(i).setOppositeVx();
								panel.getGame().destroy(j);
	//							balls.get(i).setVx(0);
	//							balls.get(i).setVy(0);
							
						}
						//lewo
						
						else if( balls.get(i).getVx() > 0 && balls.get(i).getY()+ (int)(balls.get(i).getRadius()/2) >= panel.getGame().getBox().get(j).getY()-3 && balls.get(i).getY()+ (int)(balls.get(i).getRadius()/2) <= panel.getGame().getBox().get(j).getY() + panel.getGame().getBox().get(j).getHeight() +3 && balls.get(i).getX() + balls.get(i).getRadius()  <= panel.getGame().getBox().get(j).getX()  + balls.get(i).getVx() && balls.get(i).getX() + balls.get(i).getRadius() + Math.abs(balls.get(i).getVx()) >= panel.getGame().getBox().get(j).getX() && balls.get(i).getX() + balls.get(i).getRadius() <= panel.getGame().getBox().get(j).getX() + Math.abs(balls.get(i).getVx()) ){
								
							balls.get(i).setOppositeVx();
							panel.getGame().destroy(j);
	//						balls.get(i).setVx(0);
	//						balls.get(i).setVy(0);
								
						}
						//					dól
						else if( balls.get(i).getVy() <0 && balls.get(i).getY() <= panel.getGame().getBox().get(j).getY() + panel.getGame().getBox().get(j).getHeight() - balls.get(i).getVy() && balls.get(i).getY() >= panel.getGame().getBox().get(j).getY() + panel.getGame().getBox().get(j).getHeight() - 1){
								if(balls.get(i).getX() + (int)(balls.get(i).getRadius()/2) >= panel.getGame().getBox().get(j).getX() -3 && balls.get(i).getX() + (int)(balls.get(i).getRadius()/2) <= panel.getGame().getBox().get(j).getX() + panel.getGame().getBox().get(j).getWidth()+3){  
								balls.get(i).setOppositeVy();
								panel.getGame().destroy(j);
	//							balls.get(i).setVx(0);
	//							balls.get(i).setVy(0);
							}
						}
	////					//gora
						else if(balls.get(i).getVy()> 0 &&balls.get(i).getY() + balls.get(i).getRadius() >= panel.getGame().getBox().get(j).getY() - Math.abs(balls.get(i).getVy()) && balls.get(i).getY() + balls.get(i).getRadius()< panel.getGame().getBox().get(j).getY() + Math.abs(balls.get(i).getVy())){
							if(balls.get(i).getX() + (int)(balls.get(i).getRadius()/2) >= panel.getGame().getBox().get(j).getX() -3 && balls.get(i).getX() + (int)(balls.get(i).getRadius()/2) <= panel.getGame().getBox().get(j).getX() + panel.getGame().getBox().get(j).getWidth()+3){  
								balls.get(i).setOppositeVy();
								panel.getGame().destroy(j);
	//							balls.get(i).setVx(0);
	//							balls.get(i).setVy(0);
							}
						}
						
						
					}
						
					
				}
				//removing ball
				if(!balls.get(i).isAlive() && balls.get(i).getY() + balls.get(i).getRadius() + balls.get(i).getVy() >= 730)
					balls.remove(i);
	
			}
			//zbieranie dropów
			for(int i=0;i<drop.size();i++){
				//usuwanie dropów
				if(drop.get(i).getY() + drop.get(i).getVy() >= 720)
					drop.remove(i);
				else if(drop.get(i).getY() + drop.get(i).getHeight() >= paddle.getY() && drop.get(i).getY() <= paddle.getY() + paddle.getHeight())
					if(drop.get(i).getX() + drop.get(i).getWidth() >= paddle.getX() && drop.get(i).getX() <= paddle.getX() + paddle.getWidth()){
						panel.getGame().collectDrop(drop.get(i));			
						drop.remove(i);
					}
				
			}
			
			panel.repaint();
		}
	}
}
