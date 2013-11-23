package mainPkg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.LinkedList;
import java.util.Random;

import myPkg.*;

public class MyPanel extends Panel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LinkedList<Shape> list;
	Random rand = new Random();
	public MyPanel(){
		
		list = new LinkedList<Shape>();
		list.add(new Square(rand.nextInt(500),rand.nextInt(500),rand.nextInt(100)+1,rand.nextInt(100)+1));
		list.add(new Circle(rand.nextInt(100), rand.nextInt(100), rand.nextInt(100)+1));
		list.add(new Triangle(rand.nextInt(200), rand.nextInt(200), rand.nextInt(200)));
	}
	
	public void paint(Graphics arg0){
		Graphics g = getGraphics();
		for (int i=0; i<list.size();i++){
			g.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
			list.get(i).draw(g);
		}
		
		
	}
	
	
}
