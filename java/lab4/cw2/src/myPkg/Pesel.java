package myPkg;


public class Pesel {


public static boolean fun(String number){
	int suma = 0;
	int wagi[] = {1,3,7,9,1,3,7,9,1,3};	
	if(number.length() != 11) {
		System.out.println("Pesel niepoprawny!!");
		return false;
	}
	else{
		
		for(char i=0;i<10;i++)
			suma += wagi[i] * Integer.parseInt(number.substring(i,i+1));
		suma += Integer.parseInt(number.substring(10,11));
		
		if (suma%10 == 0)
			return true;
		else {
			System.out.println("Pesel niepoprawny!!");
			return false;
		}
			
	}
}
	
}
