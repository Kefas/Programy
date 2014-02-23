package myPkg;

import java.util.concurrent.TimeUnit;

public class Ball implements Runnable {
	private int x;
	private int y;
	private int radius;
	private int Vx;
	private int Vy;
	private boolean alive;
	private boolean pause;
	private int oldVx;
	private int oldVy;
	private boolean stick;
	private int paddleX;
	
	public Ball(){
		x = 300;
		y = 643;
		radius = 7;
		Vx = 4;
		Vy = -7;
		stick = false;
		alive = true;
		pause = false;
		
	}
	public Ball(int x, int y, int radius, int vx, int vy) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
		Vx = vx;
		Vy = vy;
		stick = false;
		alive = true;
		pause = false;
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
		if(vy > 2 && vy <16)
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
	public boolean isStick() {
		return stick;
	}
	public void setStick(boolean stick) {
		this.stick = stick;
	}
	public void setPaddleX(int paddleX) {
		this.paddleX = paddleX;
		
	}
	public int getPaddleX(){
		return paddleX;
	}
	public boolean isPaused() {
		return pause;	
	}
	
	
	
}
