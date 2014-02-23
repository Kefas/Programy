package serverPkg;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Security;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	public static final int PORT = 6665;
	private static boolean bool = true;
	private static ExecutorService exec;
	
	Security sec;
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			System.out.println("Could not listen on port: " + PORT);
			e.printStackTrace();
			System.exit(-1);
		}
		System.out.println("Server is working");
		Socket client = null;
		exec = Executors.newFixedThreadPool(5);
		while(bool){
			try {
				client = serverSocket.accept();
				if(client != null)
					exec.execute(new Client(client));
				client = null;
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Could not connect with server");
				System.exit(-1);
			}
			
		}
		
		serverSocket.close();

	}

}
