package myPkg;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;


public class Kadry {
	static LinkedList<Pracownik> lista = new LinkedList<Pracownik>();
	
	static void dodajStudenta(String pes, double wyn){
		lista.add(new Student(pes, wyn));
	}
	static void dodajEtatowego(String pes, double wyn){
		lista.add(new PracownikEtatowy(pes, wyn));
	}
	static void usun(String pes){
		for(int i=0;i<lista.size();i++){
			if (lista.get(i).pesel.equals(pes)){
				lista.remove(i);
				break;
			}
		}
	}
	static boolean szukaj(String pes){

		for(int i=0;i<lista.size();i++){
			if (lista.get(i).pesel.equals(pes)){
				System.out.print(lista.get(i).pesel + " " + lista.get(i).wynagrodzenieBrutto);
				return true;
			}			
		}
		return false;	
	}
	static void zmienBrutto(String pes, double wyn){
		for(int i=0;i<lista.size();i++){
			if (lista.get(i).pesel.equals(pes))
				lista.get(i).wynagrodzenieBrutto = wyn;
		}
	}
	static void zmienNetto(String pes, double wyn){
		for(int i=0;i<lista.size();i++){
			if (lista.get(i).pesel.equals(pes))
				lista.get(i).wynagrodzenieBrutto = wyn + wyn*0.25;
		}
	}
	static double pobierzBrutto(String pes){
		for(int i=0;i<lista.size();i++){
			if (lista.get(i).pesel.equals(pes))
				return lista.get(i).wynagrodzenieBrutto;
		}
		return -1;
	}
	
	static double pobierzNetto(String pes){
		for(int i=0;i<lista.size();i++){
			if (lista.get(i).pesel.equals(pes))
				return lista.get(i).wynagrodzenieNetto();
		}
		return -1;
	}
	
	static void sortuj(){
		Collections.sort(lista, new Sort() );
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pesel;
		double wyn;
		Scanner in = new Scanner(System.in);
		int x;
		do {
			System.out.println("1. Dodaj studenta");
			System.out.println("2. Dodaj pracownika");
			System.out.println("3. Szukaj pracownika");
			System.out.println("4. Zmieñ wynagrodzenie brutto");
			System.out.println("5. Pobierz wynagrodzenie brutto");
			System.out.println("6. Zmieñ wynagrodzenie netto");
			System.out.println("5. Pobierz wynagrodzenie netto");
			System.out.println("8. Wyœwietl pracowników");
			System.out.println("9. Posortuj");
			System.out.println("0. WyjdŸ");
			
			x = in.nextInt();
			switch(x){
			case 1:
				
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				} while(!Pesel.fun(pesel));
				System.out.print("Podaj wynagrodzenie");	
				wyn = in.nextDouble();
				dodajStudenta(pesel, wyn);
				break;
				
			case 2:
				
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				}while(!Pesel.fun(pesel));
				System.out.print("Podaj wynagrodzenie");	
				wyn = in.nextDouble();
				dodajEtatowego(pesel, wyn);
				break;
			
			
			case 3:
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				}while(!Pesel.fun(pesel));
				if(!szukaj(pesel))
					System.out.println("Nie ma takiego pracownika!!");
				break;
				
			case 4:
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				}while(!Pesel.fun(pesel));
				if(!szukaj(pesel))
					System.out.println("Nie ma takiego pracownika!!");
				else{
					System.out.print("Podaj wynagrodzenie");	
					wyn = in.nextDouble();
					zmienBrutto(pesel, wyn);
				}
				break;
				
			case 5:
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				}while(!Pesel.fun(pesel));
				if(!szukaj(pesel))
					System.out.println("Nie ma takiego pracownika!!");
				else
					System.out.println(pobierzBrutto(pesel));
				break;
				
			case 6:
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				}while(!Pesel.fun(pesel));
				if(!szukaj(pesel))
					System.out.println("Nie ma takiego pracownika!!");
				else{
					System.out.print("Podaj wynagrodzenie");	
					wyn = in.nextDouble();
					 	zmienNetto(pesel, wyn);
				}
				break;
				
			case 7:	
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				}while(!Pesel.fun(pesel));
				if(!szukaj(pesel))
					System.out.println("Nie ma takiego pracownika!!");
				else
					System.out.println(pobierzNetto(pesel));
				break;
			case 8:
				for(Pracownik temp:lista){
					System.out.println(temp.pesel + " " + temp.wynagrodzenieBrutto);
				}
				break;
			case 9:
				sortuj();
				break;		
			}	
		} while (x != 0);
		
	in.close();
	}
}
