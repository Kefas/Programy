package myPkg;
import java.util.LinkedList;
import java.util.Collections;


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
			if (lista.get(i).pesel == pes){
				lista.remove(i);
				break;
			}
		}
	}
	static void szukaj(String pes){

		for(int i=0;i<lista.size();i++){
			if (lista.get(i).pesel == pes)
				System.out.print(lista.get(i).pesel + " " + lista.get(i).wynagrodzenieBrutto);
		}
		
		
	}
	static void zmienBrutto(String pes, double wyn){
		for(int i=0;i<lista.size();i++){
			if (lista.get(i).pesel == pes)
				lista.get(i).wynagrodzenieBrutto = wyn;
		}
	}
	static double pobierzBrutto(String pes){
		for(int i=0;i<lista.size();i++){
			if (lista.get(i).pesel == pes)
				return lista.get(i).wynagrodzenieBrutto;
		}
		return -1;
	}
	
	static double pobierzNetto(String pes){
		for(int i=0;i<lista.size();i++){
			if (lista.get(i).pesel == pes)
				return lista.get(i).wynagrodzenieNetto();
		}
		return -1;
	}
	
	static void sortuj(){
		Collections.sort(lista, new Sort() );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dodajStudenta("123", 100.0);
		szukaj("123");
		dodajStudenta("321",99.0);
		dodajStudenta("234", 102);
		sortuj();
		System.out.print("    " +lista.get(1).pesel);
	
	}

}
