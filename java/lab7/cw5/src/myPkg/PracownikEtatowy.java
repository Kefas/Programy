package myPkg;

public class PracownikEtatowy extends Pracownik {
	public PracownikEtatowy(String x, double y){
		pesel = x;
		wynagrodzenieBrutto = y;
	}
	double wynagrodzenieNetto() {
		return 0.5*wynagrodzenieBrutto;
	}
}
