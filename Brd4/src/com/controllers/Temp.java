package com.controllers;

import com.dao.DbInsert;

public class Temp {

	public static void main(String[] args)
	{
		int no,i;
		no=DbInsert.nOR();		
		for(i=1;i<=no;i++)
		{
			String row=DbInsert.accessRecords(i);
			System.out.println(row);
		}
	}
}
