package com.reethu.BP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
class Author_details{
		String authorName;
		String email;
		String gender;
		int age;
	}
class Book extends Author{
	String bookName ;
	double price;
	Book(String bookName,String authorName,String email,String gender,int age,double price){
		this.bookName=bookName;
		this.authorName=authorName;
		this.email=email;
		this.gender=gender;
		this.age=age;
		this.price=price;

	}

}

public class Demo {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Book> list=new ArrayList<>();
			do{
				System.out.println("Select 1 to enter n book entries.");
				System.out.println("Select 2 to display book entries.");
				System.out.println("Select 3 to get 1st five authors.");
				System.out.println("Select 4 to get sum of ages of female authors.");
				System.out.println("Select 5 to exit.");
				System.out.println("Enter your chioice :");
				int choice=sc.nextInt();
				switch(choice){
					case 1: bookEntries(list);
			               break;
					case 2: displayEntries(list);
					       break;
					case 3: displayFiveAuthors(list);
					       break;
					case 4: sumOfAges(list);
					       break;
					case 5: System.exit(0);
					       break;
				} 
			}while(true);
		}
	}
	static void bookEntries(List<Book> list){
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("How many entries u want to make :");
			int n=sc.nextInt();sc.nextLine();

			for(int i=0;i<=n;i++){
			System.out.println("Enter bookName-");
			String bookName=sc.nextLine();
			System.out.println("Enter author_Name-");
			String author_Name=sc.nextLine();
			System.out.println("Enter author_emailadd-");
			String email=sc.nextLine();
			System.out.println("Enter author_gender-");
			String gender=sc.nextLine();
			System.out.println("Enter author_age-");
			int age=sc.nextInt();
			System.out.println("Enter price-");
			double price=sc.nextDouble();sc.nextLine();
			list.add(new Book(bookName,authorName,email,gender,age,price));
			}
		} 
	}
	static void displayEntries(List<Book> list){
		for(Book b:list){
			System.out.println("book_name-"+b.bookName);
			System.out.println("author_Name"+b.authorName);
			System.out.println("author_emailadd-"+b.email);
			System.out.println("author_gender-"+b.gender);
			System.out.println("author_age-"+b.age);
			System.out.println("price-"+b.price);
		}

	} 
	static void displayFiveAuthors(List<Book> list){
		list.stream().filter(book->book.age>=30).limit(5).forEach(book->System.out.println(book));
		List<Book> temp=list.stream().filter(book->book.age>=30).limit(5).collect(Collectors.toList()); 
		for(Book b:temp){
			System.out.println(b.authorName);
			System.out.println(b.age); 
		}
		
	} 

	static void sumOfAges(List<Book> list){
		List<Book> temp=list.stream().filter(book->(book.gender.equalsIgnoreCase("female") && book.age<25)).collect(Collectors.toList());
		int sum=0;
		for(Book b:temp){
			sum +=b.age;
			System.out.println(b.authorName);
			System.out.println(b.age);
			System.out.println(b.gender); 
		}
		System.out.println("Sum of the ages of all female authors younger than 25 ="+sum);




}

		
	}


