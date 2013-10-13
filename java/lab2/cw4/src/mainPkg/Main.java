package mainPkg;
import myPkg.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punkt3D jeden = new Punkt3D(1,1,1);
		Punkt3D dwa = new Punkt3D(2,2,2);
		System.out.print(jeden.distance(dwa));
	}

}
