package myPkg;

public class ROT11 implements Algorythm {
	static char [] tab = {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u','v', 'w', 'x', 'y', 'z'};
	@Override
	public String crypt(String x) {
		String wynik = new String();
		x = x.toLowerCase();
		boolean match = false;
		for(int i=0; i<x.length(); i++){
			for( int j=0;j<tab.length;j++){
				if (tab[j] == x.charAt(i)){
					wynik += tab[(j+11)%tab.length];
					match = true;
				}
			}
			if(match == false)
				wynik += x.charAt(i);
			match = false;
		}
	
		return wynik;
	}

	@Override
	public String decrypt(String x) {
		
		// TODO Auto-generated method stub
		String wynik = new String();
		x = x.toLowerCase();
		boolean match = false;
		
		for(int i=0; i<x.length(); i++){
			for( int j=0;j<tab.length;j++){
				if (tab[j] == x.charAt(i)){
					wynik += tab[(j+14)%tab.length];
					match = true;
				}
			}
			if(match == false)
				wynik += x.charAt(i);
			match = false;
		}
		return wynik;
	}

}
