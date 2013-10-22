package mainPkg;
import myPkg.*;

public class Main {
	public static void main(String[] args){
		Shape kwadrat = new Square("Kwadrat");
		Shape kolo = new Circle("Kolo");
		Shape trojkat = new Triangle("Trojkat");
	
		kwadrat.draw();
		System.out.println();
		kolo.draw();
		System.out.println();
		trojkat.draw();
	}
}
