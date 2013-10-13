package mainPackage;
import myPackage.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punkt2D nowy = new Punkt2D(2.0,2);
		Punkt2D inny = new Punkt2D(3, 3);
		System.out.print(nowy.distance(inny));
	}

}
