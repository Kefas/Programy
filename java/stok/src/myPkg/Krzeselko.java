package myPkg;

import java.util.List;

public class Krzeselko implements Wyciag, Runnable {
	int iloscMiejsc;
	int limitKolejki;
	List list;
	
	public Krzeselko(){
		iloscMiejsc = 4;
		limitKolejki = 100;
	}
	public Krzeselko(int x, int y){
		iloscMiejsc=4;
		limitKolejki = y;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
	}
}
