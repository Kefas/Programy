package mainPkg;
import java.io.IOException;

import myPkg.BadFormatException;
import myPkg.Program;

public class Main {

	public static void main(String[] args) throws BadFormatException, IOException {
		// TODO Auto-generated method stub
		try{
			Program.delay("C:/Users/piotr/Documents/GitHub/Programy/java/lab5/cw3/src/input.txt", "C:/Users/piotr/Documents/GitHub/Programy/java/lab5/cw3/src/output.txt", 1000, 45);
		}
		catch (BadFormatException e){
			e.printStackTrace();
		}
	}

}
