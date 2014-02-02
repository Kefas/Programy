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


	public Paddle(int x, int y, int width, int height) {
		this.setHeight(height);
		this.setWidth(width);
		this.setX(x);
		this.setY(y);
		this.acceleration = 4;
		this.borderDown = 720 + 10;
		this.borderRight = 1000 + 10;
		this.borderLeft = 10;
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
		this.width = width;
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
	
	
	
	
	


}
