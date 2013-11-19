package myPkg;
import java.awt.Graphics;

import myPkg.Shape;

public class Circle extends Shape{
	private int r;
	private int x;
	private int y;
	
	public Circle(int x, int y, int r){
		this.r = r;
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		g.drawOval(x, y, r, r);
	}
}
