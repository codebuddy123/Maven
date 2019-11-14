package com.ashsoft.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {
	
   Connection con=null;
   Statement st=null;
   ResultSet rs=null;
   
   public UserService() 
   {
	  try {
		  Class.forName("oracle.jdbc.OracleDriver");
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ashish");
		  st=con.createStatement();
	} catch (Exception e) {
		e.printStackTrace();
	}
 }
   
   // The method which checks if user exists in database
   public String checkLogin(String uname,String upwd) {
	   String status="";
	   
	   try {
		rs=st.executeQuery("select * from reg_Users where UNAME='"+uname+"'and UPWD='"+upwd+"'");
		boolean b=rs.next(); //returns true if a record exists in ResultSet
		if(b==true)  //if user exists
		{
			status="success";
		}
		else
		{
			status="failure";
		}
	} catch (Exception e) {
		status="failure";
		e.printStackTrace();
	}
	   return status;
   }
}