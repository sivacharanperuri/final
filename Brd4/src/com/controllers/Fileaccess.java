package com.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

@WebServlet("/Fileaccess")
@MultipartConfig
public class Fileaccess extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String rejectionLevel = request.getParameter("rejectionLevel"); // Retrieves <input type="text"
																		// name="rejectionLevel">
		Part filePart = request.getPart("myFile"); // Retrieves <input type="file" name="myFile">
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		String status="success";
		if (rejectionLevel.equals("FILELEVEL")) {
			try {
				status = FileLevelValidation.check(filePart, fileName);
				if(status=="success")
				{
					out.print("Data entered into the Database following FILE LEVEL REJECTION");
				}
				else
				{
					out.print("Data counld not enter into the Database due to one or more records are not satisfying validation rules");

				}
			} catch (SQLException sqlException) {
				System.out.println("error accessing status of file");
			}
			if (status.equals("success")) {

			}
		} else if (rejectionLevel.equals("RECORDLEVEL")) {
			try {
				status = RecordLevelValidation.check(filePart, fileName);
				if(status=="success")
				{
					out.print("Data entered into the Database following RECORD LEVEL REJECTION");
				}
				else
				{
					out.print("Data could not enter into the database because no record is satisfying the validation rules");
				}
			} catch (SQLException sqlException) {
				System.out.println("error accessing status of file");
			}
		}
	}

}
