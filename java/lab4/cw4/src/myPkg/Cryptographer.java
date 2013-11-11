package myPkg;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cryptographer {
	
	static public void cryptfile(File plik, File zapis, Algorythm algo) throws FileNotFoundException {	
		Scanner in = new Scanner(plik);
		PrintWriter out = new PrintWriter(zapis);
		
		while(in.hasNext()){
			out.print(algo.crypt(in.next() ) + " ");
		}
		out.close();
		in.close();
	}
	
	static public void decryptfile(File plik,File zapis, Algorythm algo) throws FileNotFoundException{
		Scanner in = new Scanner(plik);
		PrintWriter out = new PrintWriter(zapis);
		
		while(in.hasNext()){
			out.print(algo.decrypt(in.next() ) + " ");
		}
		out.close();
		in.close();
	}

}
