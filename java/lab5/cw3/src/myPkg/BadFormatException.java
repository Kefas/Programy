package myPkg;

public class BadFormatException extends Exception {
	int linia;
	public BadFormatException(int x){
		linia = x;
	}
}
