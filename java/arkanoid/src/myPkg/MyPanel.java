package myPkg;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private Game game;
	private BufferedImage boxImage;
	private BufferedImage bgImage;
	private BufferedImage ballImage;
	private BufferedImage paddleImage;
	
	public MyPanel(){
		game = new Game();
		try {
			bgImage = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/bg.bmp"));
			boxImage = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/box/box_gold.bmp"));
			ballImage = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/ball.png"));
			paddleImage = ImageIO.read(new File("C:/Users/piotr/Documents/GitHub/Programy/java/arkanoid/textures/paddle.bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void paint(Graphics g){
		
		List<Drop> drop = game.getDrop();
		List<Ball> balls = game.getBall();
		List<Box> box = game.getBox();
		Paddle paddle = game.getPaddle();
		
//		g.clearRect(11, 11, 999, 719);
		g.drawImage(bgImage,10,10,null);
		
		g.drawRect(10, 10, 1000, 720);
		g.drawRect(1020,10,330,720);
		
		//paddle
//		g.drawRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
//		g.drawRect(, arg1, arg2, arg3);
		g.drawImage(paddleImage, paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight() , null);
	
		//balls
		for(int i=0;i<balls.size();i++)
//			g.drawOval(balls.get(i).getX(), balls.get(i).getY(), balls.get(i).getRadius(), balls.get(i).getRadius());
			g.drawImage(ballImage, balls.get(i).getX(),balls.get(i).getY(), null);
		for(int i=0;i<box.size();i++)
			if(box.get(i).isExist())
				g.drawImage(boxImage,box.get(i).getX(),box.get(i).getY(),49,14, null);
//		g.drawRect(box.get(i).getX(), box.get(i).getY(), box.get(i).getWidth(), box.get(i).getHeight());
		
		for(int i=0;i<drop.size();i++)
			g.drawRect(drop.get(i).getX(),drop.get(i).getY(), drop.get(i).getWidth(), drop.get(i).getHeight());
		
	}
	
	Game getGame(){
		return game;
	}
	
}
