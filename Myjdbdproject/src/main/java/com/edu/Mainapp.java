package com.edu;

import java.util.Scanner;

public class Mainapp {
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true)
		{
	System.out.println("Database operation");
	System.out.println("enter your choice");
	System.out.println(" 1. display student Information");
	System.out.println("2. Insert student record");
	System.out.println("3. update student Information based on id");
	System.out.println("4. delete student Information based on id");
	System.out.println("5. select student based on ID");
	int ch= sc.nextInt();
	switch(ch)
	{
	case 1: StudentDataoperations.displayStudentInfo();
	break;
	case 2: StudentDataoperations.insertStudentInfo();
	break;
	case 3: StudentDataoperations.UpdateStudentInfo();
	break;
	case 4: StudentDataoperations.deleteStudentInfo();
	break;
	case 5:StudentDataoperations.selectStudentInfo();
	break;
	default:System.out.println("Invalid choice");
	
	}
	System.out.println("do you want to continue yes/no");
	String choice=sc.next();
	if(choice.equalsIgnoreCase("no"))
	{
	break;
	
	}
}
		
System.out.println("program terminated");
}
}
