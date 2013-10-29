package myPkg;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cryptographer {
	
	static public void cryptfile(File plik, Algorythm algo) throws FileNotFoundException {	
		Scanner in = new Scanner(plik);
		PrintWriter out = new PrintWriter("zaszyfrowany.txt");
		
		while(in.hasNext()){
			out.print(algo.crypt(in.next() ) + " ");
		}
		out.close();
		
		
	}
	static public void decryptfile(File plik, Algorythm algo) throws FileNotFoundException{
		Scanner in = new Scanner(plik);
		PrintWriter out = new PrintWriter("odszyfrowany.txt");
		
		while(in.hasNext()){
			out.print(algo.decrypt(in.next() ) + " ");
		}
		out.close();

	}

}
