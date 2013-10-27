package myPkg;
import java.util.Comparator;

public class Sort implements Comparator{
	
	
	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		if (arg0.equals(arg1))
			return 0;
		else{
			if( ((Pracownik)arg0).wynagrodzenieBrutto > ((Pracownik)arg1).wynagrodzenieBrutto)
				return 1;
			else
				return -1;
		}
		
	}

	


}
