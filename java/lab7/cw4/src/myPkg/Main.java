package myPkg;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Program4 test = new Program4();
		//test.connect();
		test.listAll();
		//
		System.out.println("********************");
		test.findAuthor("Aldous Huxley");
		test.removeAuthor("Aldous Huxley");
		System.out.println("********************");
		test.listAll();
	}

}
