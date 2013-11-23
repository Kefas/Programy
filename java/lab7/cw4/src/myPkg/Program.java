package myPkg;
import java.sql.*;
//import com.mysql.jdbc.Driver;

public class Program {
	protected Connection conn = null;
	  protected Statement stmt = null;
	  protected ResultSet rs = null;
	  
	public void connect(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/piokon","piokon","LRxRkgFF");

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}catch(Exception e){e.printStackTrace();}	
	}
	public void listAll(){
		 try {
		      connect();
		      stmt = conn.createStatement();
		 
		      // Wyciagamy wszystkie pola z kolumny name
		      // znajduj¹ce siê w tabeli users
		      rs = stmt.executeQuery("SELECT * FROM books");
		 
		      while(rs.next()){
		        //String name = rs.getString(1);
		        String line = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4);
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

	
}
