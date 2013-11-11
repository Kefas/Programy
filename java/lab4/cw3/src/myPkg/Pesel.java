package myPkg;
import java.util.*;

public class Pesel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("pesel:");
		String number = input.nextLine();
		if (fun(number))
			System.out.println("Pesel jest poprawny");
		else
			System.out.println("Pesel jest niepoprawny");
	}
public static boolean fun(String number){
	int suma = 0;
	int wagi[] = {1,3,7,9,1,3,7,9,1,3};	
	if(number.length() != 11) 
		return false;
	else{
		
		for(char i=0;i<10;i++)
			suma += wagi[i] * Integer.parseInt(number.substring(i,i+1));
		suma += Integer.parseInt(number.substring(10,11));
		
		if (suma%10 == 0)
			return true;
		else 
			return false;
	}
}
	
}
