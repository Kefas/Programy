package myPkg;
import static java.lang.Math.*;

public class Punkt3D extends Punkt2D {
	private double z;
	public Punkt3D(double _x, double _y, double _z){
		super(_x, _y);
		z = _z;
	}
	public void setZ(double _z){
		z = _z;
	}
	public double getZ(){
		return z;
	}
	public double distance(Punkt3D obj){
		return sqrt(pow(super.distance((Punkt2D)obj),2) + pow(this.z - obj.z,2));
	}
}
