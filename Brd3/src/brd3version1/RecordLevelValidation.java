package brd3version1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RecordLevelValidation {
	public static String check() throws IOException
	{
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		DataValidation valid=new DataValidation();
		String fileDirectory="D:\\charan\\BRD-FILERESOURCES\\BRD-File Upload\\Test Cases\\File2.txt";
		if( fileDirectory.endsWith(".txt"))
		{
		try {
			fileReader = new FileReader(fileDirectory);
			bufferedReader = new BufferedReader(fileReader);
			int totalNumberofLines = 0,validrecordnumber=0;
			ArrayList<Character> statusDomain = new ArrayList<Character>();
			ArrayList<Character> flagDomain = new ArrayList<Character>();
			statusDomain.add('N');	statusDomain.add('M');	statusDomain.add('D');	statusDomain.add('A');	statusDomain.add('R');
			flagDomain.add('A');	flagDomain.add('I');
			String[] record=new String[16];
			String st;
			while ((st = bufferedReader.readLine()) != null) {
				totalNumberofLines++;}
			for(int lineCount=0;lineCount<totalNumberofLines;lineCount++)
			 {
				String lineno = Files.readAllLines(Paths.get(fileDirectory)).get(lineCount);
				lineno+='~';
				char characters[] = lineno.toCharArray();
				String field="";
				int recordcount=0;
				for (int charCount = 0; charCount < characters.length; charCount++)
					{
					  if(characters[charCount]=='~')
					 {
					  if(field=="")
					  {
						  if(recordcount==4 ||recordcount==6)
						  {
						    recordcount++;
					    //    record[recordcount++]=null;
						  }
						  else
						  {
						        record[recordcount++]="";  
						  }
					   }
					  else
					  {
					  record[recordcount++]=field;
					  field="";
					  }
					 }
					 else
					 {
						 field+=characters[charCount];				
					 }
					}
				byte validcount=0;
				if(valid.isNumeric(record[4]))  validcount++;	
				if(valid.isNumeric(record[6]))  validcount++;
			    if(valid.DataLength(record[4],(byte)6))  validcount++;	
				
				if(valid.EmailValidation(record[5]))  validcount++;
				
				if(valid.CustomerNameValidation(record[1]))  validcount++;
				
				if(valid.DomainValue(record[8].charAt(0),statusDomain))  validcount++;
				
				if(valid.DomainValue(record[9].charAt(0),flagDomain))  validcount++;
				
				if(valid.Mandatory(record))  validcount++;
				
				if(validcount==8) 
				{ 
					validrecordnumber++;
					DbInsert.insert(validrecordnumber,record);
		
				}
			 }
			DbInsert.commit();
	     } catch (FileNotFoundException e) 
		  {
	    	 System.out.println("File not found");
	      }
		}
		else
		{
			System.out.println("File format not valid");
		}
		return "success";
	}

}
