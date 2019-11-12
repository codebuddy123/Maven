package com.ashsoft.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JdbcApp {
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	
	public JdbcApp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","ashish");
			st=con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getStudentDetails()
	{
		try {
			rs=st.executeQuery("select * from emp1");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-----------------------------------");
			while(rs.next())
			{
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.println(rs.getString("EADDR"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
