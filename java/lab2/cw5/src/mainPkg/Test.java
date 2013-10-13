package mainPkg;
import java.util.Scanner;
import myPkg.*;
import java.util.LinkedList;

public class Test {
	static LinkedList<Punkt3D> punkty = new LinkedList<Punkt3D>();
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x=0;
		print();
		do{
			
			//1print();
			switch (x){
				case 1 : 
					wczytaj();
					print();
					break;
				case 2 :
					wyswietl();
					System.out.print("Naci�nij 0 aby powr�ci�");
					int flaga = 0;
					do{
						flaga = in.nextInt();
					} while ( flaga != 0);
					print();
					break;
				case 3 :
					licz();
					print();
					break;
			
			}
		
		x = in.nextInt();
		} while (x != 4);
	}


public static void print(){
	System.out.println("1. Wczytaj punkt 3D");
	System.out.println("2. Wy�wietl wszystkie punkty");
	System.out.println("3. Oblicz odleg�o��");
	System.out.println("4. Zako�cz");
}
public static void wczytaj(){

	double x,y,z;
	System.out.print("Podaj x y z: ");
	x = in.nextDouble();
	y = in.nextDouble();
	z = in.nextDouble();
	punkty.add(new Punkt3D(x,y,z));
}

public static void wyswietl(){
	for(int i=0; i<punkty.size();i++){
		System.out.println("Punkt "+ i + ". x:" + punkty.get(i).getX() + " y:" + punkty.get(i).getY() + " z:" + punkty.get(i).getZ());
	}
	
}

public static void licz(){
	
	if(punkty.size() > 1){	
		wyswietl();
		System.out.println("Odleg�o�� mi�dzy kt�rymi punktami chcesz obliczy�?");
		int x = in.nextInt();
		int y = in.nextInt();
		if(x < 0 || x>punkty.size()-1 || y < 0 || y> punkty.size()-1){
			System.out.println("Nie ma takich punkt�w!");
		}
		else
			System.out.println("Odleg�o�� mi�dzy punktami " + x + " i " + y + " wynosi " + punkty.get(x).distance(punkty.get(y)));	
	} else {
		System.out.println("Za ma�o punkt�w!!");
	}
	System.out.print("Naci�nij 0 aby powr�ci�");
	int flaga = 0;
	do{
		flaga = in.nextInt();
	} while ( flaga != 0);
}

}