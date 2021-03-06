package myPkg;
import java.sql.*;
//import com.mysql.jdbc.Driver;

public class Program {
	private Connection conn = null;
	  private Statement stmt = null;
	  private ResultSet rs = null;
	  
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
		      // znajduj�ce si� w tabeli users
		      rs = stmt.executeQuery("SELECT * FROM books");
		 
		      while(rs.next()){
		        //String name = rs.getString(1);
		        String line = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3);
		        System.out.println(line);
		      }
		    }catch (SQLException ex){
		      // handle any errors
		 
		    }finally {
		      // zwalniamy zasoby, kt�re nie b�d� potrzebne
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
	public void findAuthor(String author) throws SQLException{
		rs = stmt.executeQuery("SELECT * FROM books WHERE author='"+author+"'");
		while(rs.next()){
	        //String name = rs.getString(1);
	        String line = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3);
	        System.out.println(line);
	      }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Program test = new Program();
		test.listAll();
	}

}
