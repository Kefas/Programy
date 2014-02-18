package serverPkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {

	private Socket client;
	
	public Client(Socket client) {
		this.client = client;
		
	}

	@Override
	public void run() {
		PrintWriter out = null;
		try {
			out = new PrintWriter(client.getOutputStream(), true);
			out.println("Connection established");
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		if(out != null)
			out.close();
		
	}

}
