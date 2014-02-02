package myPkg;

import java.util.concurrent.TimeUnit;

import com.sun.org.apache.xerces.internal.impl.RevalidationHandler;

import sun.awt.RepaintArea;

public class Ball implements Runnable {
	private int x;
	private int y;
	private int radius;
	private int Vx;
	private int Vy;
	private boolean alive = true;
	private boolean pause = false;
	private int oldVx;
	private int oldVy;
	
	public Ball(){
		x = 300;
		y = 300;
		radius = 7;
		Vx = 4;
		Vy = -5;
		
	}
	public Ball(int x, int y, int radius, int vx, int vy) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
		Vx = vx;
		Vy = vy;
	}
	
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		if( x >= 10 && x<=1010 - radius)
			this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		if(y >= 10)
			this.y = y;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getVx() {
		return Vx;
	}
	public void setVx(int vx) {
		Vx = vx;
	}
	public void setOppositeVx(){
		Vx = -Vx;
	}
	public int getVy() {
		return Vy;
	}
	public void setVy(int vy) {
		Vy = vy;
	}
	public void setOppositeVy(){
		if(alive)
			Vy = -Vy;
	}
	public void dead(){
		alive = false;
	}
	public boolean isAlive(){
		return alive;
	}
	public void pause(){
		if(!pause){
			oldVx = Vx;
			oldVy = Vy;
			Vx = 0;
			Vy = 0;
			pause = true;
		}
		else{
			Vx = oldVx;
			Vy = oldVy;
			pause = false;
		}
	}
	

	@Override
	public void run() {
		while(true){
			
				if( x >= 10-Vx && x<=1010 - radius - Vx)
					x += Vx;
				if( y >=10 - Vy)
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
