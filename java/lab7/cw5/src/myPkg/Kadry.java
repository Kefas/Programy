package myPkg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Kadry {
	protected Connection conn = null;
	protected Statement stmt = null;
	protected ResultSet rs = null;
	
	
	public Kadry(){
		connect();
	}
	
	public void connect(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/piokon","piokon","LRxRkgFF");
			stmt = conn.createStatement();

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}catch(Exception e){e.printStackTrace();}	
	}
	void dodajStudenta(String pes, double wyn){
		
		try{	
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO kadra VALUES (" + pes + ", " + wyn + ");");
		} catch (Exception e){
			//e.printStackTrace();
			System.err.println("Nie mo¿na duplikowaæ danych!");
		}
		finally{
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) { } // ignore
		 
		        stmt = null;
		      }
		}
	}
		void createTable() throws SQLException{
			stmt = conn.createStatement();
			 try {
				 stmt.execute("CREATE TABLE IF NOT EXISTS kadry (pesel CHAR(11) NOT NULL, brutto double NOT NULL, PRIMARY KEY(pesel);)");
	
			 } catch (SQLException e) {
		            System.err.println("Blad przy tworzeniu tabeli");
		            e.printStackTrace();
		        }
		   
			}
	
	void dodajEtatowego(String pes, double wyn){
		dodajStudenta(pes, wyn);
	}
	void usun(String pes){
		try{
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM kadra WHERE pesel= '" + pes + "';");
			
		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
		      if (stmt != null) {
		        try {
		          stmt.close();
		        } catch (SQLException sqlEx) { } // ignore
		 
		        stmt = null;
		      }
		}
	}
	boolean szukaj(String pes){
		boolean znak = false;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM kadra WHERE pesel='" + pes + "';");
			while(rs.next()){
				String line = rs.getString(1) + " " +  rs.getString(2);
				System.out.println(line);
				znak = true;
			}
			
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
		finally{
			if (rs != null) {
		        try {
		          rs.close();
		        } catch (SQLException sqlEx) { } // ignore
		        rs = null;
		      }
		 
		      if (stmt != null) {
		        try {
		          stmt.close();
		        } catch (SQLException sqlEx) { } // ignore
		 
		        stmt = null;
		      }
		}
		return znak;
	}
	void zmienBrutto(String pes, double wyn){
		try{
			stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE kadra SET brutto='" + wyn + "' WHERE pesel='"+ pes + "';");
		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
		      if (stmt != null) {
		        try {
		          stmt.close();
		        } catch (SQLException sqlEx) { } // ignore
		 
		        stmt = null;
		      }
		}
		
		
	}
	void zmienNetto(String pes, double wyn){
		zmienBrutto(pes, (wyn*4)/(double)3);
	}
	double pobierzBrutto(String pes){
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM kadra WHERE pesel='" + pes + "';");
			rs.next();
			if ( rs != null)
				return rs.getDouble(2);
			else
				return 0;
			
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
		finally{
			if (rs != null) {
		        try {
		          rs.close();
		        } catch (SQLException sqlEx) { } // ignore
		        rs = null;
		      }
		 
		      if (stmt != null) {
		        try {
		          stmt.close();
		        } catch (SQLException sqlEx) { } // ignore
		 
		        stmt = null;
		      }
		}
		
	}
	
	double pobierzNetto(String pes){
		return pobierzBrutto(pes)*0.75;
	}
	void listAll() {
		 try {
			 
			 stmt = conn.createStatement();
			 
			 // Wyciagamy wszystkie pola z kolumny name
			 // znajduj¹ce siê w tabeli users
			 rs = stmt.executeQuery("SELECT * FROM kadra;");
		 
			 while(rs.next()){
				 //String name = rs.getString(1);
				 String line = rs.getString(1) + " " + rs.getString(2);
				 System.out.println(line);
			 }
		 }catch (SQLException ex){
			 // handle any errors
			 
		 }finally {
			 // zwalniamy zasoby, które nie bêd¹ potrzebne
			 if (rs != null) {
				 try {
					 rs.close();
				 } catch (SQLException sqlEx) { } // ignore
				 rs = null;
			 }
		 
			 if (stmt != null) {
				 try {
					 stmt.close();
				 } catch (SQLException sqlEx) { } // ignore
		 
				 stmt = null;
			 }
		 }		
	}

	
	void sortuj(){
		//Collections.sort(lista, new Sort() );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pesel;
		Kadry test = new Kadry();
		//test.connect();
		
		double wyn;
		Scanner in = new Scanner(System.in);
		int x;
		
		do {
			System.out.println("1. Dodaj studenta");
			System.out.println("2. Dodaj pracownika");
			System.out.println("3. Szukaj pracownika");
			System.out.println("4. Zmieñ wynagrodzenie brutto");
			System.out.println("5. Pobierz wynagrodzenie brutto");
			System.out.println("6. Zmieñ wynagrodzenie netto");
			System.out.println("7. Pobierz wynagrodzenie netto");
			System.out.println("8. Wyœwietl pracowników");
			System.out.println("9. Posortuj");
			System.out.println("10. Usuñ pracownika");
			System.out.println("0. WyjdŸ");
			
			x = in.nextInt();
			switch(x){
			case 1:
				
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				} while(!Pesel.fun(pesel));
				System.out.print("Podaj wynagrodzenie");	
				wyn = in.nextDouble();
				test.dodajStudenta(pesel, wyn);
				
				break;
				
			case 2:
				
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				}while(!Pesel.fun(pesel));
				System.out.print("Podaj wynagrodzenie");	
				wyn = in.nextDouble();
				test.dodajEtatowego(pesel, wyn);
				break;
			
			
			case 3:
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				}while(!Pesel.fun(pesel));
				if(!test.szukaj(pesel))
					System.out.println("Nie ma takiego pracownika!!");
				break;
				
			case 4:
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				}while(!Pesel.fun(pesel));
				if(!test.szukaj(pesel))
					System.out.println("Nie ma takiego pracownika!!");
				else{
					System.out.print("Podaj wynagrodzenie");	
					wyn = in.nextDouble();
					test.zmienBrutto(pesel, wyn);
				}
				break;
				
			case 5:
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				}while(!Pesel.fun(pesel));
				if(!test.szukaj(pesel))
					System.out.println("Nie ma takiego pracownika!!");
				else
					System.out.println(test.pobierzBrutto(pesel));
				break;
				
			case 6:
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				}while(!Pesel.fun(pesel));
				if(!test.szukaj(pesel))
					System.out.println("Nie ma takiego pracownika!!");
				else{
					System.out.print("Podaj wynagrodzenie");	
					wyn = in.nextDouble();
					 	test.zmienNetto(pesel, wyn);
				}
				break;
				
			case 7:	
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				}while(!Pesel.fun(pesel));
				if(!test.szukaj(pesel))
					System.out.println("Nie ma takiego pracownika!!");
				else
					System.out.println(test.pobierzNetto(pesel));
				break;
			case 8:
				test.listAll();
				break;
			case 9:
				test.sortuj();
				break;			
			case 10:
				do{
					System.out.print("Podaj pesel");
					pesel = in.next();
				}while(!Pesel.fun(pesel));
				test.usun(pesel);
				break;
			}
		} while (x != 0);
		
	in.close();
	}
	
}
