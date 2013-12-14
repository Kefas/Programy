package lab8cw2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	public static void main(String [] args) throws IOException{
		Socket echoSocket = null;
		BufferedReader in = null;
		PrintWriter out= null;	
		String userInput[];
		File file;
		Scanner sIn;
		boolean access = false;
		String zwrot = null;
		long line=12150;
		
		file = new File("polish-dic.txt");
		sIn = new Scanner(file, "UTF-8");
		for(int i=0;i<line;i++)
			sIn.nextLine();
		while(sIn.hasNextLine() && access == false){
			try{
				echoSocket = new Socket("149.156.98.145",3000);
				out = new PrintWriter(echoSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));	
//				System.out.println("works");
				userInput = sIn.nextLine().split("/");
				System.out.println(userInput[0]);
				out.println(new String("LOGIN szymon;" + userInput[0]));
				zwrot = in.readLine();
				System.out.println(zwrot + " " + line);
				line++;
				 if (zwrot.equals("true")){
					 System.out.println("tak");
					 access = true;
				 }	
			}
			catch (IOException e){
				System.err.println("Cannot get I/O for server");
			}
			
			if(echoSocket != null)
				echoSocket.close();
			if(in != null)
				in.close();
			if(out != null)
				out.close();
			
		
		}
		sIn.close();
		
	}
}
