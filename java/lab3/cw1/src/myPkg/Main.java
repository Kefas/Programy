package myPkg;
import java.util.LinkedList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Double> lista = new LinkedList<Double>();
		lista.add(5.4);
		metoda2(lista);
	}
	
	static void metoda1(final double var){
		//var = 5.5; 
		//Nie mo�na zmieni� var w funkcji
	}
	static void metoda2(final LinkedList<Double> list){
		list.remove();
		list.add(5.5);
		
		list.set(0,1.9);
	}
}

// Poniewa� przy li�cie mo�emy modyfikowa� elementy, nie mo�emy jednak przypisa� nowej referencji do tej zmiennej
//