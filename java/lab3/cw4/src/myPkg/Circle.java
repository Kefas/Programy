package myPkg;
import myPkg.Shape;

public class Circle extends Shape{
	public Circle(String _name){
		name = _name;
	}
	public void draw(){
		System.out.println("  *  ");
		System.out.println(" *** ");
		System.out.println("*****");
		System.out.println(" *** ");
		System.out.println("  *  ");
	}
}
