package brd2;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
public class CheckDataValidation {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Object objm;
		String sp;
//		System.out.println("Enter the field:");
//		objm=sc.nextLine();
//		System.out.println(DataValidation.DataType(123,"Byte"));
	//	System.out.println(DataValidation.DataLength(objm,(byte)15));
		System.out.println("Enter the restricted special characters:");
		sp=sc.nextLine();
//		System.out.println(DataValidation.ValidSpecialChar(objm,sp));
		List<String> values = new ArrayList<String>();
		values.add("monday");
		values.add("tuesday");
		String s ="thursday";
//		System.out.println(DataValidation.DomainValue(s,values));
		
//		System.out.println(DataValidation.EmailValidation("perurisivacharan@gmail.com"));
		SimpleDateFormat sm=new SimpleDateFormat("yyyy/MM/dd");
//		System.out.println(DataValidation.FormatValidation("1996/08/24",sm));

	}
}
	
	