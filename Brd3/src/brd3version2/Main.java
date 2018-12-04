package brd3version2;
import java.io.IOException;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner sc=new Scanner(System.in);
		int rejectionLevel=0;
		String result;
		System.out.println("Please enter the corresponding option for rejection level:\n1.FILELEVEL\n2.RECORDLEVEL");
		rejectionLevel=sc.nextInt();
		if(rejectionLevel==1)
		{
			result=FileLevelValidation.check();
			if(result=="success")
			{
				System.out.println("Details Entered into database successfully following FileLevelValidation");
			}
			else
			{
				System.out.println("Details could not be entered into database because one or more records are not satisfying datavalidation rules");
			}
		}
		else if(rejectionLevel==2)
		{
			result=RecordLevelValidation.check();
			if(result=="success")
			{
				System.out.println("Details Entered into database successfully following RecordLevelValidation");
			}
			else
			{
				System.out.println("Details could not be entered into database because no record is not satisfying datavalidation rules");
			}
		}
	}
}