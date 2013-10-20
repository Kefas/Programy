package myPkg;

public class Main {

	static public void main(String[] argv){
		PracowityStudent oksymoron = new PracowityStudent();
		//Pracownik pracownik = PracowityStudent.rzutujNaPracownika();
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
	    iloscZajec++;
		sumaGodzin++;
		
	  }
	  class InnerPracownik extends Pracownik{
	    public void dodajZajecia(){
		  iloscZajec++;
		  sumaGodzin++;
		  
		}
	  }
	}