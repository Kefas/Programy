package myPkg;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Cryptographer temp = new Cryptographer();
		File gunwo = new File("C:/Users/piotr/Documents/GitHub/Programy/java/lab4/cw4/src/myPkg/source.txt");
		File zaszy = new File("C:/Users/piotr/Documents/GitHub/Programy/java/lab4/cw4/zaszyfrowany.txt");
		Cryptographer.cryptfile(gunwo, new Polibiusz());
		Cryptographer.decryptfile(zaszy , new Polibiusz());
		
		
	}

}
