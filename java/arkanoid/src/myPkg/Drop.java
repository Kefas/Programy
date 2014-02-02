package myPkg;

import java.util.concurrent.TimeUnit;

public class Drop implements Runnable {
	private int x;
	private int y;
	private int width=20;
	private int height=20;
	private int Vy;
	public Drop(int x2, int y2) {
		x = x2+20;
		y = y2;
		Vy = 5;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getVy() {
		return Vy;
	}
	public void setVy(int vy) {
		Vy = vy;
	}
	@Override
	public void run() {
		while(true){
			y += Vy;
			try {
				TimeUnit.MILLISECONDS.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
