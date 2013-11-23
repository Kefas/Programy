package myPkg;

public class Student extends Pracownik {
	public Student(String pesel, double x){
		this.pesel = pesel;
		wynagrodzenieBrutto = x;
	}
	double wynagrodzenieNetto(){
		return 0.75*wynagrodzenieBrutto;
	}
}
