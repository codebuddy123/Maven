package com.ashsoft;

public class Student {
	
	String sid;
	String sname;
	String saddr;
	
	public Student(String sid,String sname,String saddr)
	{
		this.sid=sid;
		this.sname=sname;
		this.saddr=saddr;
	}
	
	public void getStudentDetails()
	{
		System.out.println("Student Details");
		System.out.println("-----------------------");
		System.out.println("Student ID      :"+sid);
		System.out.println("Student Name    :"+sname);
		System.out.println("Student Address :"+saddr);
	}
}
