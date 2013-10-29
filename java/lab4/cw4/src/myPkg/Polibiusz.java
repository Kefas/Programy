package myPkg;

public class Polibiusz implements Algorythm {
	char [][] tab = { {'a', 'b', 'c', 'd','e'}, {'f', 'g', 'h', 'i', 'k'}, {'l', 'm', 'n', 'o', 'p'}, {'q', 'r', 's', 't', 'u'}, {'v', 'w' ,'x' ,'y', 'z'}};

	@Override
	public String crypt(String x) {
		// TODO Auto-generated method stub
		String result = new String();
		x = x.toLowerCase();
		for(int i=0; i<x.length(); i++){
			for(int j=0; j<5; j++){
				for(int k=0; k<5; k++){
					if(x.charAt(i) == tab[j][k]){
						result += (char)j+1;
						result += (char)k+1;
					}						
				}
			}
		}
		result += " ";
		return result;
	}

	@Override
	public String decrypt(String x) {
		// TODO Auto-generated method stub
		String result = new String();
		x = x.toLowerCase();
		char [] tablica = x.toCharArray();
		for(int i=0; i<tablica.length; i=i+2){		
			result += tab[(int)tablica[i]-49][(int)tablica[i+1]-49];	
		}
		
		
		return result;
	}

}
