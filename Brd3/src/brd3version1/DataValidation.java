package brd3version1;
import java.util.List;

public class DataValidation {
	  boolean isNumeric(String string)  
	{  
	  try  
	  {  
	    Long d = Long.parseLong(string);  
	  }  
	  catch(NumberFormatException numberFormatException)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	  
	 boolean DataLength(String stringPincode, byte length)
	{
		int pincode = Integer.parseInt(stringPincode);
		byte pinlength=0;
		 while(pincode != 0)
		    {
		        pinlength++;
		        pincode /= 10;
		    }
		if(pinlength>=length)
		   return true;
		else
			return false;
		
	}
	/*static boolean ValidSpecialChar(Object obj,String sp)

	{
		boolean b=true;
		byte l1,l2;
		l1=(byte)((String) obj).length();
		l2=(byte)sp.length();
		for(byte i=0;i<l1;i++)
			for(byte j=0;j<l2;j++)
				if(((String) obj).charAt(i)==sp.charAt(j))
					return false;
		return b;
	}*/
	 boolean Mandatory(String [] s)
	{
		boolean b;
		if(s[0]!=null&&s[1]!=null&&s[2]!=""&&s[4]!=null&&s[5]!=null&&s[7]!=null&&s[8]!=null&&s[9]!=null&&s[10]!=null&&s[11]!=null)
		    b=true;
		else
			b=false;
		return b;
	}
	 boolean DomainValue(char c, List<Character> values)
	{
		boolean b=false;
		byte l1=(byte) values.size();
		for(byte i=0;i<l1;i++ )
			if(values.get(i)==c) return true;
		return b;
	}

	 boolean EmailValidation(String email)
    {
	 
	   return email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");
    }
	 boolean CustomerNameValidation(String name)
	{
		boolean b1=true;
		for(byte b=0;b<name.length();b++)
		{	
			char c=name.charAt(b);	
		    if(!((c>='A'&&c<='Z')||(c>='a'&&c<='z')||(c>='0'&&c<='9')||c==' '))
		    	b1=false;
		   
		}
		 return b1;  
	}
}


