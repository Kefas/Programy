package myPkg;

public class Paddle {
	
	private int x;
	private int y;
	private int width;
	private int height;
	private int acceleration;
	
	private int borderUp;
	private int borderDown;
	private int borderLeft;
	private int borderRight;
	private int radius;


	public Paddle(int x, int y, int width, int height) {
		this.setHeight(height);
		this.setWidth(width);
		this.setX(x);
		this.setY(y);
		this.acceleration = 4;
		this.borderDown = 720 + 10;
		this.borderRight = 1000 + 10;
		this.borderLeft = 10;
		radius = 140;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if(width > 60 && width < 300)
			this.width = width;
		radius = (int)((double)width*4/5);
	}

	public int getY() {
		return y;
	}

	public void setY(int posY) {
		this.y = posY;
	}

	public int getX() {
		return x;
	}

	public void setX(int posX) {
		if(posX < borderLeft)
			this.x = borderLeft;
		else if(posX + width > borderRight)
			this.x = borderRight - width;
		else
			this.x = posX;
	}

	public void toRight() {
		if( borderRight - (x + width) > acceleration + 2 )
			x += acceleration;
		else
			x = borderRight - width - 2;
	}

	public void toLeft() {
		if( x - borderLeft > acceleration + 2 )
			x -= acceleration;
		else
			x = borderLeft + 2;
	}
	
	public int getAcceleration(){
		return acceleration;
	}
	
	public void setAcceleration(int accleration){
		this.acceleration = accleration;
	}

	public int getR() {
		return radius;
	}

	public void setR(int i) {
		this.radius = i;
		
	}
	
	
	
	
	


}
