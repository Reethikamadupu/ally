package com.reethu.BP;

import java.util.ArrayList;
import java.util.Scanner;

public class Empdtls {

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> emp_dtls = new ArrayList<ArrayList<String>>();
		System.out.println("Enter emp dtls in organization");
		Scanner input = new Scanner(System.in);
		String Line="";
		int c=1;
		for(int k=0;c>0;k++)
		{
			emp_dtls.add(new ArrayList<String>());
			for(int l=0;c>0 && l<5;l++)
			{
				switch(l)
				{
				case 0:
				{
					System.out.print("Name of emp");
					break;
				}
				case 1:
				{
					System.out.print("emp ID");
					break;
				}
				case 2:
				{
					System.out.print("DOB");
					break;
				}
				case 3:
				{
					System.out.print("Salary");
					break;
				}
				case 4:
				{
					System.out.print("Designation");
					break;
				}
				}
				Line=input.nextLine();
				c=Line.length();
				emp_dtls.get(k).add(l,Line);
			}
		}
		print_employee_details(emp_dtls);
		System.out.println("Select accordingly\n"
				+ "1. Check whether the emp exists or not\n"
				+ "2. Add emp_dtls to the Organization");
		Line=input.next();
		switch(Integer.parseInt(Line))
		{
		case 1 :
		{
			System.out.println("Enter emp name to check");
			Line=input.next();
			for(ArrayList<String> list :emp_dtls)
			{
				if(list.get(0).equals(Line))
				{
					System.out.println("emp exists");
					System.out.print("Name,ID,DOB,Salary,Designation\n");
					for(String detail : list)
					{
						System.out.print(detail+"  ");
					}
					System.out.println("\n D to delete the employee details and N to exit");
					Line=input.next();
					if(Line=="D")
					{
						emp_dtls.remove(list);
						System.out.println("emp_dtls removed");
					}
				}
				else
				{
					System.out.println("emp does not exist");
				}
				break;
			}
			break;
		}
		case 2 :
		{
			add_emp_details(emp_dtls);
			break;
		}
		default :
		{
			System.out.println("Invalid");
			break;
		}
		}
		input.close();
	}
	public static void print_employee_details(ArrayList<ArrayList<String>> employee_details_list)
	{
		System.out.println("emp_dtls in organization");
		System.out.println("Name,ID,DOB,Salary,Designation");
		
		//for each loop
		for(ArrayList<String> list :employee_details_list)
		{
			//Iterator
			java.util.Iterator<String> detail = list.iterator();
			while(detail.hasNext())
			{
				String str = detail.next();
				if(str!="")
				{
					System.out.print(str+" , ");
				}
			}
			System.out.print("\n");
		}
	}
	public static void add_emp_details(ArrayList<ArrayList<String>> emp_dtls)
	{
		Scanner input = new Scanner(System.in);
		String Line="";
		int t=1;
		while(t==1)
		{
			ArrayList<String> list1 = new ArrayList<String>();
			System.out.println("Enter the Name of the employee :");
			Line=input.next();
			for(ArrayList<String> li : emp_dtls)
			{
				if(li.get(0).equals(Line))
				{
					System.out.println("Duplicate entry detectedand it is invalid");
					input.close();
					return;
				}
			}
			list1.add(Line);
			System.out.println("Enter emp_ID ");
			Line=input.next();
			list1.add(Line);
			System.out.println("Enter DOB");
			Line=input.next();
			list1.add(Line);
			System.out.println("Enter Salary");
			Line=input.next();
			list1.add(Line);
			System.out.println("Enter Designation");
			Line=input.next();
			list1.add(Line);
			emp_dtls.add(list1);
			System.out.println("emp_dtls added successfully");
			System.out.println("Type Y to add another employee details\n"
					+ "Type V to view employee details\n"
					+ "Type E to exit");
			Line=input.next();
			if(Line.equals("V"))
			{
				print_employee_details(emp_dtls);
			}
			if(!Line.equals("Y"))
			{
				t=0;
				System.out.println("Exited");
			}
		}
		input.close();
	}
		

}


