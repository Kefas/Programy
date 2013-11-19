package myPkg;

public class BadFormatException extends Exception {

	private static final long serialVersionUID = 1L;
	public BadFormatException(String nazwa){
		super(nazwa);
	}
	
	public BadFormatException(){
		super("Not a digit");
	}
	
}
