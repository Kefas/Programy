package myPkg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Stok {

	static int freq = 10;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Krzeselko(4,50));
		exec.execute(new Krzeselko(4,100));
		exec.execute(new Orczyk());
		
		
	}

}
