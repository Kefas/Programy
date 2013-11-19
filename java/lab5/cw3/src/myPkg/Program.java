package myPkg;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program {
	
	static public void delay(String in, String out, int delay, int fps) throws BadFormatException, IOException{
		File myfile = new File(in);
		Scanner input = new Scanner(myfile);
		PrintWriter output = new PrintWriter(out);
		String line;
		double mspf = 1000 / (double)45;
		int przesuniecie = (int)(delay/mspf);
		
		try{		
			while(input.hasNextLine()){
				line = input.nextLine();
				int open1 = line.indexOf("{");
				int close1 = line.indexOf("}");
				int close2 = line.indexOf("}", close1+1);	
				
				String str1 = line.substring(open1+1, close1);
				String str2 = line.substring(close1+2, close2);
	
				int num1;
				int num2;
				try{
					num1 = Integer.parseInt(str1);
					num2 = Integer.parseInt(str2);
				}
				catch (Exception e){
					throw new BadFormatException();
				}
				
				if( num1 >= num2) throw new BadFormatException("T2>T1");				
				output.println("{" + (num1+przesuniecie) + "}" + "{" + (num2+przesuniecie) + "}" + line.substring(close2+1));					
			}			
		}
		catch (BadFormatException e){
			throw e;
		}
		finally{
			input.close();
			output.close();
		}
	}
}
