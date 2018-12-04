package brd3version1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileLevelValidation {
	public static String check() throws IOException {
		BufferedReader bufferedReader = null;
		BufferedReader bufferedReader2 = null;
		FileReader fileReader = null;
		int validRecordNumber = 0;
		DataValidation valid = new DataValidation();
		String fileDirectory = "D:\\charan\\BRD-FILERESOURCES\\BRD-File Upload\\Test Cases\\File1.txt";
		if (fileDirectory.endsWith(".txt")) {
			try {
				fileReader = new FileReader(fileDirectory);
				bufferedReader = new BufferedReader(fileReader);
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
				while ((st = bufferedReader.readLine()) != null) {
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
								record[recordcount++] =null;
							} else {
								record[recordcount++] = field;
								field = "";
							}
						} else {
							field+= characters[ctr];
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
					DbInsert.insert(validRecordNumber, record);

				}
				DbInsert.commit();
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			}
		} else {
			System.out.println("File format not valid");
		}
		bufferedReader.close();
		return "success";
	}

}
