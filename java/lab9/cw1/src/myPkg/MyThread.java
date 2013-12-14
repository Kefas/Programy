package myPkg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyThread implements Runnable {
	private Socket clientSocket;
	public MyThread(Socket cs) {
		clientSocket = cs;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
	        
	        
	        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	        out.println("connection established");
	        BufferedReader in = new BufferedReader(
	                                new InputStreamReader(
	                                clientSocket.getInputStream()));
	        String inputLine;
	 
	        while ((inputLine = in.readLine()) != null) {
	             out.println(inputLine);
	        }
	        out.close();
	        in.close();
	        clientSocket.close();
	        
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
