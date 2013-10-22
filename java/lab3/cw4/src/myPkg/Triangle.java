package myPkg;
import myPkg.Shape;

public class Triangle extends Shape {
	public Triangle(String _name){
		name = _name;
	}
	public void draw(){
		System.out.println("  *  ");
		System.out.println(" *** ");
		System.out.println("*****");
	}
}
