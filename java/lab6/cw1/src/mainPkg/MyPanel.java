package mainPkg;

import java.awt.Graphics;
import java.awt.Panel;
import java.util.LinkedList;

import myPkg.*;

public class MyPanel extends Panel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LinkedList<Shape> list;
	
	public MyPanel(){
		list = new LinkedList<Shape>();
		list.add(new Square(10,10,10,10));
		list.add(new Circle(100, 100, 50));
		list.add(new Triangle(100, 100, 20));
	}
	
	public void paint(Graphics arg0){
		Graphics g = getGraphics();
		for (int i=0; i<list.size();i++)
			list.get(i).draw(g);
		
		
	}
	
	
}
