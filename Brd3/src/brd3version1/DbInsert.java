package brd3version1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInsert {
	static Connection connection = null; 
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		}
			catch (SQLException sqlException) {
				
				sqlException.printStackTrace();
			} 
		catch (ClassNotFoundException classNotFound) {
		
			classNotFound.printStackTrace();
		}
		
	
	}

	public static void insert(int validRecordNumber, String[] record) {

		try {
			System.out.println(record[2]);
			Statement statement = connection.createStatement(); 
			ResultSet employeeResultSet = statement.executeQuery("INSERT INTO customer_det " +
	                   "VALUES ("+validRecordNumber+", '"+record[0]+"','"+record[1]+"','"+record[2]+"','"+record[3]+"','"+record[4]+"','"+record[5]+"','"+record[6]+"','"+record[7]+"','"+record[8]+"','"+record[9]+"','"+record[10]+"','"+record[11]+"','"+record[12]+"','"+record[13]+"','"+record[14]+"','"+record[15]+"' )");

			}catch (SQLException exception) {
			System.out.println(exception);
		}
	}
	public static void commit() 
	{
		try {
			connection.commit();
		} catch (SQLException sqlException) {
			System.out.println("Could not commit the transaction");
		}
	}
}