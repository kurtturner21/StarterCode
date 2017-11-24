import java.sql.*;
import java.util.ArrayList;

/*
This code is helpful to learn how to create JAVA code around SQLite
https://www.tutorialspoint.com/sqlite/sqlite_java.htm

This is the site where it explains how to use SQLite and interface app download 
https://sqlite.org/download.html

This is a site that has the JARs needed by JAVA to interface with SQLite
https://bitbucket.org/xerial/sqlite-jdbc/downloads/
*/


public class SalesDB {
	Connection c = null;

	
	// connecting to the data base file 
	public void connectDB(){
		try {
			// Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:Users.db");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
	
   
	public void createTables(){
		Statement stmt = null;
		
		// Customer Table
		try {
			stmt = c.createStatement();
			String sql = "create table if not exists customers \n" +
				"(id integer primary key autoincrement, \n" +
				" name           text    not null, \n" + 
				" address        char(50), \n" + 
				" city        	 char(50), \n" + 
				" state        	 char(50), \n" + 
				" zip        	 char(15), \n" +
				" phone        	 char(15))"; 
			stmt.executeUpdate(sql);
			stmt.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}

		// Customer Sales Table 
		try {
			stmt = c.createStatement();
			String sql = "create table if not exists sales(id integer primary key autoincrement, customer_id int not null, product int not null, ammount real)"; 
			stmt.executeUpdate(sql);
			stmt.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}	
	}

	
	// Adds data to the people table
	public void addDataToPeopleTable(String Name, int Age, String Address, String City, 
		String State, String Zip, Double Salery){
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			String sql = "insert into people (name, age, address, city, state, zip, salary) " +
						"values ('" + Name + "'," + Age + ", '" + Address + "', '" + City + 
						"', '" + State + "', '" + Zip + "', " + Salery + ");"; 
			stmt.executeUpdate(sql);
			stmt.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
			
			
		// UDB.addDataToPeopleTable("Bob", 43, "123 Any St.", "Cleveland", "TN", "37320", 43000.25);
		// UDB.addDataToPeopleTable("Sandy", 25, "400 North Lee Hwy", "Cleveland", "TN", "37317", 16700.12);
		// UDB.addDataToPeopleTable("April", 49, "10 You Know It Drive", "Greensboro", "NC", "27012", 82000.00);
		}
	}


	// returns a count of rows in customer table
	public int getCustomerCount(){
		Statement stmt = null;
		int CustomerCount = 0;
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "select count(*) as rowct from customers;" );
			CustomerCount = rs.getInt("rowct");				
			rs.close();
			stmt.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		return CustomerCount;
	}
	
	// get a list of all customer ids to store into memory
	public ArrayList<Integer> getCustomerIds(){
		Statement stmt = null;
		ArrayList<Integer> CustomerIds = new ArrayList<Integer>();
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "select id from customers order by id asc;" );
			while ( rs.next() ){
				CustomerIds.add(rs.getInt("id"));
			}
			rs.close();
			stmt.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		return CustomerIds;		
	}
	
	// pull one customer data row
	public String[] getCustomerRecord(int neededCustomerId){
		Statement stmt = null;
		String[] CustomerData = {null, null, null, null, null, null};
		try {
			stmt = c.createStatement();
			ResultSet rs  = stmt.executeQuery( "select * from customers where id = " + neededCustomerId + ";" );
			CustomerData[0] = rs.getString("name");
			CustomerData[1] = rs.getString("address");
			CustomerData[2] = rs.getString("city");
			CustomerData[3] = rs.getString("state");
			CustomerData[4] = rs.getString("zip");
			CustomerData[5] = rs.getString("phone");
			rs.close();
			stmt.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		return CustomerData;		
		
	}

}