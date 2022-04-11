package com.edu;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDataoperations {



	static Connection scon=null;
	static ResultSet rs= null;
	static Statement st=null;
	static Scanner sc= new Scanner(System.in);
	static int sid;
	static String sname;
	static String scourse;




	public static void insertStudentInfo() {
		//getconnection
		try
		{
			scon=Dbconnection.getConnection();
			st=scon.createStatement();

			System.out.println("My connection"+scon);
			// input data from user 
			System.out.println("enter id of the student");
			sid=sc.nextInt();
			//check id exists
			String sql="select *from edustudent where sid="+sid;
			rs=st.executeQuery(sql);

			if(!rs.next()) {
				System.out.println("enter the student name");
				sname=sc.next();
				System.out.println("enter the course name");
				scourse=sc.next();
				String ins="insert into edustudent values("+sid+",'"+sname+"','"+scourse+"')";
				int i=st.executeUpdate(ins);
				if(i>0)
				{
					System.out.println("student information is registered");

				}

			}else
			{
				System.out.println("id alreadyesists choose another id");

			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}


	}


	private static Scanner  Scanner(InputStream in) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void UpdateStudentInfo()  {
		System.out.println("enter student id to update information");
		sid=sc.nextInt();
		scon=Dbconnection.getConnection();
		try {


			st=scon.createStatement();
			String sql= "select*from edustudent where sid="+sid;
			rs=st.executeQuery(sql);
			if(rs.next())
			{


				System.out.println("select field which youupdate");
				System.out.println("1. update name based on id");
				System.out.println("2. update scourse name based on id");
				System.out.println("3. update name and scourse name based on id");
				int ch= sc.nextInt();
				switch(ch)
				{

				case 1:
					System.out.println(" enter name to change:");
					String n=sc.next();
					String upd="update edustudent  set sname='"+n+"' where sid="+sid;


					int i=st.executeUpdate(upd);
					if(i>0)
					{
						System.out.println("name is change");
					}
					break;
				case 2:
					System.out.println("enter course name to change");
				     String c=sc.next();
					String cup="update edustudent set scorse= '"+c+"'where sid="+sid;

					int cr=st.executeUpdate(cup);
					if(cr>0)
					{
						System.out.println("scorse name is change");
					}
					break;
				case 3:
					System.out.println("enter name  to change");
					String n1=sc.next();
					System.out.println("enter course to change");
					String c1=sc.next();
					String upnamecourse="update edustudent set sname='"+n1+"', scorse='"+c1+"' where sid="+sid;
					int ncchange=st.executeUpdate(upnamecourse);
					if(ncchange>0)
					{
						System.out.println("name and course name change");
					}
				}
			}
			else {
				System.out.println("id not exists");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
	}


	public static void selectStudentInfo() {
		try {
			scon=Dbconnection.getConnection();
			st=scon.createStatement();
			System.out.println("enter the student to display information");
			sid=sc.nextInt();
			String sql="Select*from edustudent where sid="+sid;
			rs=st.executeQuery(sql);
			if(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			else 
			{
				System.out.println("id not found");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void displayStudentInfo() {
		try
		{
			scon=Dbconnection.getConnection();
			st=scon.createStatement();

			String sql="Select*from edustudent ";
			rs=st.executeQuery(sql);
			System.out.println("sid\tName\tCourse Name");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();

		}

	}

	public static void deleteStudentInfo() {
		try {
			scon=Dbconnection.getConnection();
			st=scon.createStatement();
			System.out.println("enter the student id to delete information");
			sid=sc.nextInt();
			String sql=" select * from edustudent where sid="+sid;
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				String del="delete from edustudent where sid="+sid;
				int i= st.executeUpdate(del);
				if(i>0)
				{
					System.out.println("record is deleted");

				}
			}
			else
			{
				System.out.println("records not deleted");

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
	}
}
