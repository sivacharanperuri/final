package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Customer;
public class DbInsert {

	static Connection connection=null;
	static
	{
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			
       System.out.println("Driver Class not found");		
       }
	}
	public static void insert(Customer customer) throws SQLException
	{
		PreparedStatement ps=connection.prepareStatement("insert into temp_customer_det values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1,customer.getCUSTOMERID( ));  
		ps.setString(2,customer.getCUSTOMERCODE ( ));  
		ps.setString(3,customer.getCUSTOMERNAME ( ));  
		ps.setString(4,customer.getCUSTOMERADDRESS1 (  ));  
		ps.setString(5,customer.getCUSTOMERADDRESS2 (  ));  
		ps.setString(6,customer.getCUSTOMERPINCODE (  ));  
		ps.setString(7,customer.getEMAILADDRESS (  ));  
		ps.setString(8,customer.getCONTACTNUMBER (  ));  
		ps.setString(9,customer.getPRIMARYCONTACTPERSON (  ));  
		ps.setString(10,customer.getRECORDSTATUS (  ));  
		ps.setString(11,customer.getFLAG (  ));  
		ps.setString(12,customer.getCREATEDATE ( ));  
		ps.setString(13,customer.getCREATEDBY (  ));  
		ps.setString(14,customer.getMODIFIEDDATE ( ));  
		ps.setString(15,customer.getMODIFIEDBY ( ));  
		ps.setString(16,customer.getAUTHORIZEDDATE ( ));  
		ps.setString(17,customer.getAUTHORIZEDBY (  ));  
		ps.executeUpdate();  
	}
	public static int nOR()
	{
		int size = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "select * from temp_customer_det";
			ResultSet resultSet = statement.executeQuery(query);
		    try {
		        while(resultSet.next()){
		            size++;
		        }
		    }
		    catch(Exception ex) {
		    }

		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return size;
	}
	public static String accessRecords(int rowNumber)
	{
		String row=null;
		try {
			Statement statement = connection.createStatement();
			String query = "select * from temp_customer_det";
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()) { 
				 row= resultSet.getString(2); 
			//	 row[1] = resultSet.getString("CUSTOMERCODE");
				}

		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return row;
		
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
