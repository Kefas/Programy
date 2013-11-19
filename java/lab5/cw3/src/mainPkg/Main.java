package mainPkg;
import java.io.IOException;

import myPkg.BadFormatException;
import myPkg.Program;

public class Main {

	public static void main(String[] args) throws BadFormatException, IOException {
		// TODO Auto-generated method stub
		try{
			Program.delay("input.txt", "output.txt", 1000, 45);
		}
		catch (BadFormatException e){
			e.printStackTrace();
		}
	}

}
