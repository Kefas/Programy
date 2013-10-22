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
	  public abstract void print();          //doda�em klas� print dla wy�wietlania wynik�w
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
		  iloscZajec +=2;                       // dodaje +2 �eby zobaczy� r�nic�, dodaj� do Pracownika
		  PracowityStudent.this.dodajZajecia(); // wywo�uj� funkcj� dla Studenta ale r�wnie dobrze moge odnie�� si� bezpo�rednio do zmiennej 
		  
		}
	    public void print(){
			  System.out.println(iloscZajec);
			  System.out.println(PracowityStudent.this.iloscZajec);
	    }		
	  }
	}