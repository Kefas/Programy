package myPkg;

public class Main {

	static public void main(String[] argv){
		PracowityStudent temp = new PracowityStudent();
		Pracownik temp2 = temp.rzutujNaPracownika();
		temp2.dodajZajecia();
	}
}

abstract class Student{
	  protected int iloscZajec;
	  public abstract void dodajZajecia();
	 
	}
	abstract class Pracownik{
	  protected int iloscZajec;
	  public abstract void dodajZajecia();
	 
	}
	class PracowityStudent extends Student{
	 private int sumaGodzin;
	  public Pracownik rzutujNaPracownika(){
		return new InnerPracownik();
	  }
	 
	  public void dodajZajecia(){
	    iloscZajec++; //dodaje sume godzin  Student
	    sumaGodzin++; //dodaje sume godzin  pracowitego studenta
		
		
	  }
	  class InnerPracownik extends Pracownik{
	    public void dodajZajecia(){
		  iloscZajec++; //dodaje godzin� dla iloscZajec z klasy Pracownik
		  sumaGodzin++;	//dodaje sume godzin pracowitego studenta
		  
		}
	  }
	}