package myPkg;

import java.sql.SQLException;



public class Program3 extends Program{
	public void findAuthor(String author) throws SQLException{
		try{
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM books WHERE author= '" + author + "'");
			while(rs.next()){
		        //String name = rs.getString(1);
		        String line = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getShort(4);
		        System.out.println(line);
			}
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
	public void findByID(String id){
		try{
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM books WHERE isbn= '" + id + "'");
			while(rs.next()){
		        //String name = rs.getString(1);
		        String line = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getShort(4);
		        System.out.println(line);
			}
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
