package com.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Customer;
import com.dao.DbInsert;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  

@WebServlet("/NewUserDataProces")
public class NewUserDataProcess extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		Customer customer=new Customer();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date=(String)dtf.format(now);
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession(false);  
        String user_id=(String)session.getAttribute("user_id");  
		/*String date;
		date="24/08/2018";*/
		customer.setCUSTOMERID("2");
//		customer.setCUSTOMERID (request.getParameter("user_id"));
		customer.setCUSTOMERCODE (request.getParameter("Customer_Code") );
		customer.setCUSTOMERNAME ( request.getParameter("Customer_Name")  );
		customer.setCUSTOMERADDRESS1 ( request.getParameter("Customer_Address1")  );
		customer.setCUSTOMERADDRESS2 ( request.getParameter("Customer_Address2")  );
		customer.setCUSTOMERPINCODE ( request.getParameter("Customer_PinCode")  );
		customer.setEMAILADDRESS ( request.getParameter("Email_Address") );
		customer.setCONTACTNUMBER ( request.getParameter("Contact_Number") );
		customer.setPRIMARYCONTACTPERSON ( request.getParameter("Primary_Contact") );
		customer.setRECORDSTATUS ("N");
		customer.setFLAG ( request.getParameter("Active_Inactive_Flag") );
		customer.setCREATEDATE (date);
		customer.setCREATEDBY (user_id);
		customer.setMODIFIEDDATE ( request.getParameter("Modified_Date") );
		customer.setMODIFIEDBY ( request.getParameter("Modified_By") );
		customer.setAUTHORIZEDDATE ( request.getParameter("Authorized_Date")  );
		customer.setAUTHORIZEDBY ( request.getParameter("Authorized_By"));

	/*	System.out.println(customer.getCUSTOMERID());
		System.out.println(customer.getCUSTOMERCODE());
		System.out.println(customer.getCUSTOMERNAME());
		System.out.println(customer.getCUSTOMERADDRESS1());
		System.out.println(customer.getCUSTOMERADDRESS2());
		System.out.println(customer.getCUSTOMERPINCODE());
		System.out.println(customer.getEMAILADDRESS());
		System.out.println(customer.getCONTACTNUMBER());
		System.out.println(customer.getPRIMARYCONTACTPERSON());
		System.out.println(customer.getRECORDSTATUS());
		System.out.println(customer.getFLAG());
		System.out.println(customer.getCREATEDATE());
		System.out.println(customer.getCREATEDBY());
		System.out.println(customer.getMODIFIEDDATE());
		System.out.println(customer.getMODIFIEDBY());
		System.out.println(customer.getAUTHORIZEDDATE());
		System.out.println(customer.getAUTHORIZEDBY());*/

		try {
			DbInsert.insert(customer);
		} catch (SQLException daoException) {
			daoException.printStackTrace();
			System.out.println("Error Connecting to Dao");
		}
		DbInsert.commit();	
	}

}
