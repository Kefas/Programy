package myPkg;
import java.awt.Graphics;

import myPkg.Shape;


public class Square extends Shape {
	private int x1, y1, x2, y2;
	public Square(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void draw(Graphics g){
		g.drawRect(x1, y1, x2, y2);
	}
}
