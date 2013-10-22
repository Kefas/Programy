package myPkg;
import myPkg.Shape;


public class Square extends Shape {
	public Square(String _name){
		name = _name;
	}
	
	public void draw(){
		for(char i=0; i<3;i++)
			System.out.println("****");
	}
}
