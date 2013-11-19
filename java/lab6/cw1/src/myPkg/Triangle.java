package myPkg;
import java.awt.Graphics;

import myPkg.Shape;

public class Triangle extends Shape {
	private int x,y,r;
	public Triangle(int x, int y, int r){
		this.x = x;
		this.y = y;
		this.r = r;
	}
	public void draw(Graphics g){
		int xt[] = {x, y, r};
		int yt[] = {y, r ,x};
		g.drawPolygon(xt, yt, 3);
	}
}
