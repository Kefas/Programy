package myPkg;

public class Main {

	static public void main(String[] argv){
		PracowityStudent temp = new PracowityStudent();
		Pracownik temp2 = temp.rzutujNaPracownika();
		
		temp2.dodajZajecia();
		temp2.print();
	}
}

abstract class Student{
	  protected int iloscZajec;
	  public abstract void dodajZajecia();
	}

	abstract class Pracownik{
	  protected int iloscZajec;
	  public abstract void dodajZajecia();
	  public abstract void print();          //doda³em klasê print dla wyœwietlania wyników
	}
	
	class PracowityStudent extends Student{
	 
	  public Pracownik rzutujNaPracownika(){
		return new InnerPracownik();
	  }
	 
	  public void dodajZajecia(){
	    iloscZajec++;
	  }
	  
	  public void print(){
		  System.out.println(iloscZajec);
	  }
	  class InnerPracownik extends Pracownik{
	    public void dodajZajecia(){
		  iloscZajec +=2;                       // dodaje +2 ¿eby zobaczyæ ró¿nicê, dodajê do Pracownika
		  PracowityStudent.this.dodajZajecia(); // wywo³ujê funkcjê dla Studenta ale równie dobrze moge odnieœæ siê bezpoœrednio do zmiennej 
		  
		}
	    public void print(){
			  System.out.println(iloscZajec);
			  System.out.println(PracowityStudent.this.iloscZajec);
	    }		
	  }
	}