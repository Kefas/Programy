package myMain;
import java.io.IOException;
import dictionary.*;
import board.*;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InteliCwDB test = new InteliCwDB("cwdb.txt");
		test.saveDB("out.txt");
		
		ConcreteStrategy strategia = new ConcreteStrategy();
		Crossword temp = new Crossword(new Board(15,15), test);
		temp.generate(strategia);
		temp.show();
	}

}
