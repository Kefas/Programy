package myPackage;
import static java.lang.Math.*;

public class Punkt2D {
	private double x,y;
	public Punkt2D(double _x, double _y){
		x = _x;
		y = _y;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void setX(double _x){
		x = _x;
	}
	public void setY(double _y){
		y = _y;
	}
	public double distance(Punkt2D obj){
		return sqrt(pow(this.x - obj.x, 2) + pow(this.y - obj.y,2));
	}
}
