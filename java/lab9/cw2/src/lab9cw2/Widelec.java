package lab9cw2;

public class Widelec {
	private boolean use=false;
	 synchronized public w(){
		while(use)
			wait();
		use = true;
	}
}
