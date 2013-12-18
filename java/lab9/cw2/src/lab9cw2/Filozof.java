package lab9cw2;

public class Filozof implements Runnable {
	
	
	private Widelec wid1;
	private Widelec wid2;
	private int id;
	public Filozof(Widelec wid1, Widelec wid2, int id){
		this.wid1 = wid1;
		this.wid2 = wid2;
		this.id =id;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
