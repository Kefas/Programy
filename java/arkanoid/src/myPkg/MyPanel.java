package myPkg;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private Game game;
	private BufferedImage boxImage;
	private BufferedImage bgImage;
	private BufferedImage ballImage;
	private BufferedImage paddleImage;
	private BufferedImage num0, num1, num2, num3, num4, num5, num6, num7, num8,
			num9;
	private BufferedImage counter, liveImg;
	private String strScore;
	private boolean event;
	

	public MyPanel() {
		game = new Game();
		event = true;
		try {
			bgImage = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/bg.jpg"));
			boxImage = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/box/block.jpg"));
			ballImage = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/ball.png"));
			paddleImage = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/paddle.jpg"));
			num0 = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/numbers/0.png"));
			num1 = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/numbers/1.png"));
			num2 = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/numbers/2.png"));
			num3 = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/numbers/3.png"));
			num4 = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/numbers/4.png"));
			num5 = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/numbers/5.png"));
			num6 = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/numbers/6.png"));
			num7 = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/numbers/7.png"));
			num8 = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/numbers/8.png"));
			num9 = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/numbers/9.png"));
			counter = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/zegar.jpg"));
			liveImg = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/live.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {

		List<Drop> drop = game.getDrop();
		List<Ball> balls = game.getBall();
		List<Box> box = game.getBox();
		Paddle paddle = game.getPaddle();

		// g.clearRect(11, 11, 999, 719);
		g.drawImage(bgImage, 10, 10, 1000, 720, null);

		// g.drawRect();
		// g.fillRect(1060, 100, 250, 65);
		
		

		if (event) {
			g.drawImage(bgImage, 1020, 10, 330, 720, null);
			g.drawImage(counter, 1060, 100, 250, 65, null);
			int scoreX = 1085;
			strScore = Integer.toString(game.getScore());
			while (strScore.length() < 8)
				strScore = "0" + strScore;
			for (int i = 0; i < 8; i++) {

				switch (strScore.charAt(i)) {
				case '0':
					g.drawImage(num0, scoreX + i * 25, 115, 20, 35, null);
					break;
				case '1':
					g.drawImage(num1, scoreX + i * 25, 115, 20, 35, null);
					break;
				case '2':
					g.drawImage(num2, scoreX + i * 25, 115, 20, 35, null);
					break;
				case '3':
					g.drawImage(num3, scoreX + i * 25, 115, 20, 35, null);
					break;
				case '4':
					g.drawImage(num4, scoreX + i * 25, 115, 20, 35, null);
					break;
				case '5':
					g.drawImage(num5, scoreX + i * 25, 115, 20, 35, null);
					break;
				case '6':
					g.drawImage(num6, scoreX + i * 25, 115, 20, 35, null);
					break;
				case '7':
					g.drawImage(num7, scoreX + i * 25, 115, 20, 35, null);
					break;
				case '8':
					g.drawImage(num8, scoreX + i * 25, 115, 20, 35, null);
					break;
				case '9':
					g.drawImage(num9, scoreX + i * 25, 115, 20, 35, null);
					break;

				}
				g.drawImage(liveImg,1060, 200, 250, 65,null);
				switch(game.getLive()){
					case 0:
						g.drawImage(num0, 1260, 215, 20, 35, null);
						break;
					case 1:
						g.drawImage(num1, 1260, 215, 20, 35, null);
						break;
					case 2:
						g.drawImage(num2, 1260, 215, 20, 35, null);
						break;
					case 3:
						g.drawImage(num3, 1260, 215, 20, 35, null);
						break;
				}

			}
			event = false;
		}

		g.drawRect(10, 10, 1000, 720);
		g.drawRect(1020, 10, 330, 720);

		// paddle

		g.drawImage(paddleImage, paddle.getX(), paddle.getY(),
				paddle.getWidth(), paddle.getHeight(), null);

		// balls
		for (int i = 0; i < balls.size(); i++)
			g.drawImage(ballImage, balls.get(i).getX(), balls.get(i).getY(),
					null);
		for (int i = 0; i < box.size(); i++)
			if (box.get(i).isExist())
				g.drawImage(boxImage, box.get(i).getX(), box.get(i).getY(), 49,
						14, null);
		// g.drawRect(box.get(i).getX(), box.get(i).getY(),
		// box.get(i).getWidth(), box.get(i).getHeight());

		for (int i = 0; i < drop.size(); i++)
			g.drawRect(drop.get(i).getX(), drop.get(i).getY(), drop.get(i)
					.getWidth(), drop.get(i).getHeight());

	}

	Game getGame() {
		return game;
	}

	public boolean isEvent() {
		return event;
	}

	public void setEvent(boolean event) {
		this.event = event;
	}




}
