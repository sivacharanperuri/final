package brd3version2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import brd3version2.Customer;

public class FileLevelValidation {
	public static String check() throws IOException {
		BufferedReader bufferedReader1 = null;
		BufferedReader bufferedReader2 = null;
		FileReader fileReader1 = null;
		FileReader fileReader2 = null;
		int validRecordNumber = 0;
		DataValidation valid = new DataValidation();
		Customer customer=new Customer();
		String fileDirectory = "D:\\charan\\BRD-FILERESOURCES\\BRD-File Upload\\Test Cases\\File1.txt";
		if (fileDirectory.endsWith(".txt")) {
			try {
				fileReader1 = new FileReader(fileDirectory);
				bufferedReader1 = new BufferedReader(fileReader1);
				fileReader2 = new FileReader(fileDirectory);
				bufferedReader2 = new BufferedReader(fileReader2);
				int totalNumberofLines = 0;
				ArrayList<Character> statusDomain = new ArrayList<Character>();
				ArrayList<Character> flagDomain = new ArrayList<Character>();
				statusDomain.add('N');
				statusDomain.add('M');
				statusDomain.add('D');
				statusDomain.add('A');
				statusDomain.add('R');
				flagDomain.add('A');
				flagDomain.add('I');
				String[] record = new String[16];
				String lineno, st;
				while ((st = bufferedReader1.readLine()) != null) {
					totalNumberofLines++;
				}
				for (int lineCount = 0; lineCount < totalNumberofLines; lineCount++) {
					lineno = Files.readAllLines(Paths.get(fileDirectory)).get(lineCount);

					lineno += '~';
					char characters[] = lineno.toCharArray();
					String field = "";
					int recordcount = 0;
					for (int ctr = 0; ctr < characters.length; ctr++) {
						if (characters[ctr] == '~') {
							if (field == "") {
								record[recordcount++] = "";
							} else {
								record[recordcount++] = field;
								field = "";
							}
						} else {
							field += characters[ctr];
						}
					}
					byte validCount = 0;
					if (valid.isNumeric(record[4]))
						validCount++;
					if (valid.isNumeric(record[6]))
						validCount++;
					if (valid.DataLength(record[4], (byte) 6))
						validCount++;
					if (valid.EmailValidation(record[5]))
						validCount++;
					if (valid.CustomerNameValidation(record[1]))
						validCount++;
					if (valid.DomainValue(record[8].charAt(0), statusDomain))
						validCount++;
					if (valid.DomainValue(record[9].charAt(0), flagDomain))
						validCount++;
					if (valid.Mandatory(record))
						validCount++;
					if (validCount != 8) {
						return "failed";
					}
				}
				validRecordNumber = 0;
				for (int lineCount = 0; lineCount < totalNumberofLines; lineCount++) {
					lineno = Files.readAllLines(Paths.get(fileDirectory)).get(lineCount);					
					lineno += '~';
					char characters[] = lineno.toCharArray();
					String field = "";
					int recordcount = 0;
					for (int ctr = 0; ctr < characters.length; ctr++) {
						if (characters[ctr] == '~') {
							if (field == "") {
								record[recordcount++] = "";
							} else {
								record[recordcount++] = field;
								field = "";
							}
						} else {
							field += characters[ctr];

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
						DbInsert1.insert(customer);
					} catch (SQLException daoException) {
						System.out.println("Error Connecting to Dao");
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			}
		} else {
			System.out.println("File format not valid");
		}
		bufferedReader1.close();
		bufferedReader2.close();
		return "success";
	}

}
