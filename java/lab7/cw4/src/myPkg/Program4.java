package myPkg;

import java.sql.SQLException;

public class Program4 extends Program3 {
	public void removeAuthor(String author) throws SQLException{
		
		try{
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM books WHERE author= '" + author + "'");
			int deleteCount = stmt.executeUpdate("DELETE FROM books WHERE author= '" + author + "'");
			System.out.print(deleteCount);
			
		} catch (Exception e){
			e.printStackTrace();
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
	
	public void removeID(String id) throws SQLException{
		
		try{
			connect();
			stmt = conn.createStatement();
			int deleteCount = stmt.executeUpdate("DELETE FROM books WHERE isbn= '" + id + "'");
			System.out.println(deleteCount);
			
		} catch (Exception e){
			e.printStackTrace();
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
}
