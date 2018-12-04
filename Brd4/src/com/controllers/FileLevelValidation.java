package com.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Part;

import com.dao.DbInsert;
import com.model.Customer;

public class FileLevelValidation {
	public static String check(Part filePart ,String fileName) throws IOException, SQLException 
	{
		InputStream fileContent1 = filePart.getInputStream();
		InputStream fileContent2 = filePart.getInputStream();
		BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(fileContent1));
		BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileContent2));
		DataValidation valid=new DataValidation();
		Customer customer=new Customer();
		if( fileName.endsWith(".txt"))
	    {
			int validRecordNumber=0;
			ArrayList<Character> statusDomain = new ArrayList<Character>();
			ArrayList<Character> flagDomain = new ArrayList<Character>();
			statusDomain.add('N');	statusDomain.add('M');	statusDomain.add('D');	statusDomain.add('A');	statusDomain.add('R');
			flagDomain.add('A');	flagDomain.add('I');
			String[] record=new String[16];
			 String lineno;
			while((lineno=bufferedReader1.readLine())!=null)
			 {
				lineno+='~';
				char characters[] = lineno.toCharArray();
				String field="";
				int recordcount=0;
				for (int ctr = 0; ctr < characters.length; ctr++)
				{
				if(characters[ctr]=='~')
			     {
				 if(field=="")
				 {
				  record[recordcount++]=null;
			     }
				 else
			     {
				  record[recordcount++]=field;
				  field="";
				 }
			    }
				else
				{
				 field+=characters[ctr];
				}
			   }
				byte validCount=0;
				if(valid.isNumeric(record[4]))  validCount++;	
				if(valid.isNumeric(record[6]))  validCount++;
			    if(valid.DataLength(record[4],(byte)6))  validCount++;	
				if(valid.EmailValidation(record[5]))  validCount++;
				if(valid.CustomerNameValidation(record[1]))  validCount++;
				if(valid.DomainValue(record[8].charAt(0),statusDomain))  validCount++;
				if(valid.DomainValue(record[9].charAt(0),flagDomain))  validCount++;
				if(valid.Mandatory(record))  validCount++;
				if(validCount!=8)
				{
					System.out.println(validCount);
					return "failed";
				}
			 }
			validRecordNumber=0;
			while((lineno=bufferedReader2.readLine())!=null)
			 {
				lineno+='~';
				char characters[] = lineno.toCharArray();
				String field="";
				int recordcount=0;
				for (int ctr = 0; ctr < characters.length; ctr++)
				{
				if(characters[ctr]=='~')
			     {
				 if(field=="")
				 {
				  record[recordcount++]=null;
			     }
				 else
			     {
				  record[recordcount++]=field;
				  field="";
				 }
			    }
				else
				{
				 field+=characters[ctr];
				}
			   }		
					validRecordNumber++;
					customer.setCUSTOMERID (Integer.toString(validRecordNumber));
					customer.setCUSTOMERCODE ( record[0]  );
					customer.setCUSTOMERNAME ( record[1]  );
					customer.setCUSTOMERADDRESS1 ( record[2]  );
					customer.setCUSTOMERADDRESS2 ( record[3]  );
					customer.setCUSTOMERPINCODE ( record[4]  );
					customer.setEMAILADDRESS ( record[5] );
					customer.setCONTACTNUMBER ( record[6] );
					customer.setPRIMARYCONTACTPERSON ( record[7] );
					customer.setRECORDSTATUS (record[8]  );
					customer.setFLAG ( record[9] );
					customer.setCREATEDATE ( record[10]  );
					customer.setCREATEDBY ( record[11]  );
					customer.setMODIFIEDDATE ( record[12]  );
					customer.setMODIFIEDBY ( record[13]  );
					customer.setAUTHORIZEDDATE ( record[14]  );
					customer.setAUTHORIZEDBY ( record[15] );
					try {
						DbInsert.insert(customer);
					} catch (SQLException daoException) {
						System.out.println("Error Connecting to Dao");
					}
				}
			DbInsert.commit();
			
	}
		else
		{
			System.out.println("File format not valid");
		}
		
		return "success";
}
}
