package com.reethu.BP;

import java.util.HashMap;
import java.util.Scanner;

public class Empdtls_n_hobbies {

	public static void main(String[] args) {
		HashMap<String,ArrayList<String>> map = new HashMap<>();
		System.out.println("Enter Employee Details and their hobbies");
		try (Scanner input = new Scanner(System.in)) {
			String Line="";
			String ID="";
			ArrayList<String> list = new ArrayList<String>();
			while(true)
			{
				list.clear();
				System.out.print("emp_ID");
				ID=input.next();
				System.out.print("emp_name");
				list.add(input.next());
				System.out.print("emp_DOB");
				list.add(input.next());
				System.out.print("salary");
				list.add(input.next());
				System.out.print("designation");
				list.add(input.next());
				System.out.print("enter hobbies");
				list.add(input.next());
				map.put(ID,list);
				System.out.print("Type ADD to add another Employee or type anything to exit\n");
				Line=input.next();
				if(!Line.equals("ADD"))
				{
					System.out.println("uploaded successfully");
					break;
				}
			}
			int c=0;
			while(c==0)
			{
				System.out.println("Select an action");
				System.out.println("1.View all empdtls_n_hobbies");
				System.out.println("2.View only required emp_dtls_n_hobbies");
				System.out.println("3.del a emp");
				System.out.println("4.Exit");
				Line=input.next();
				switch(Integer.parseInt(Line))
				{
					case 1:
					{
						for(String id : map.keySet())
						{
							System.out.println("emp_ID: "+id);
							System.out.println("emp_name-"+map.get(id).get(0));
							System.out.println("DOB-"+map.get(id).get(1));
							System.out.println("sal-"+map.get(id).get(2));
							System.out.println("designation-"+map.get(id).get(3));
							System.out.println("hobbies-"+map.get(id).get(4));
							System.out.println("----------------------------------------------------");
						}
						System.out.println("P for previous and anything to exit");
						Line=input.next();
						if(!Line.equals("P"))
						{
							c=1;
							System.out.print("Exit");
						}
						break;
					}
					case 2:
					{
						System.out.println("enter emp_ID");
						Line=input.next();
						System.out.println("emp_id-"+Line);
						System.out.println("name-"+map.get(Line).get(0));
						System.out.println("DOB-"+map.get(Line).get(1));
						System.out.println("salary-"+map.get(Line).get(2));
						System.out.println("designation-"+map.get(Line).get(3));
						System.out.println(" Hobbies-"+map.get(Line).get(4));
						System.out.println("P for previous and anything to exit");
						Line=input.next();
						if(!Line.equals("P"))
						{
							c=1;
							System.out.print("Exit");
						}
						break;
					}
					case 3:
					{
						System.out.print("enter emp_Id");
						Line=input.next();
						if(map.containsKey(Line))
						{
							map.remove(Line);
							System.out.println("deleted");
						}
						else
						{
							System.out.println("emp_id not present");
						}
						System.out.println("P for previous and anything to exit");
						Line=input.next();
						if(!Line.equals("P"))
						{
							c=1;
							System.out.print("Exit");
						}
						break;
					}
					default :
					{
						c=1;
						System.out.print("Exit");
						break;
					}
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}

