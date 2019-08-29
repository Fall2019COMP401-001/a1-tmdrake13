package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numofcustomers;
		
		
		//input number of customers
		numofcustomers = scan.nextInt();
		
		//declares and instantiates a new array of Customers based on the number of customers
		Customer [] customers = new Customer [numofcustomers];
		
		for (int i = 0; i < numofcustomers; i++) {
			//input first name
			String firstname = scan.next();
  			//input last name
			String lastname = scan.next();
			//input number of items bought
			int numitemsbought = scan.nextInt();
			//adds customer to array of customers with inputed parameters
			customers[i] = new Customer (firstname, lastname, numitemsbought);
			
			
			
			for (int j = 0; j < customers[i].numitemsbought; j++) {
				//input integer quantity
				 int frequency = scan.nextInt();
				 //input name of items bought
				 String name = scan.next();
				//input price of item
				double price = scan.nextDouble();
				//adds a new item to the array of items for that customer with inputed parameters
				 customers[i].itemsbought[j] = new Item (frequency, name, price);

				//calculates and sets the amount spent for each customer by accessing each item bought by that customer and the frequency of each
				customers[i].setTotalSpent (customers[i].itemsbought[j].price * customers[i].itemsbought[j].frequency);
			}
		}
		scan.close();
		
		//loops through array of customers and prints in the format "F. LAST: TOTAL"
		for (int i = 0; i < numofcustomers; i++) {
			char initial = customers[i].firstname.charAt(0);
			String finitial = initial + ". " ;
			String last = customers[i].lastname;
			double spent = customers[i].totalspent;
			System.out.println (finitial + last + ": " +  String.format("%.2f", spent));
			
			
		}
		
	}
	
}

	//this class defines the object Customer - the class holds instance variables for the name,
	//number of items bought, amount total spent, and an array of the items bought by that customer

	class Customer {

		
		String firstname;
		String lastname;
		int numitemsbought;
		double totalspent = 0;
		Item [] itemsbought;
		
		
		public Customer (String fname, String lname, int items) {
			firstname = fname;
			lastname = lname;
			numitemsbought = items;
			itemsbought = new Item [numitemsbought];
		}
		
		//takes the amount sent as a parameter and adds it to the instance variable tracking total amount spent
		public void setTotalSpent (double spent) {
			totalspent += spent;
		}
		
	}
	
	//this class defines the object Item which holds instance data for the price and name of the item
	//as well as the number of customers who bought that item
	
	class Item {
		int frequency;
		String name;
		double price;
		int totalnumbought = 0;
		int custbought = 0;;

		public Item(int freq, String nm, double prc) {
			frequency = freq;
			name = nm;
			price = prc;
		}
		
		public Item (String nm, double prc) {
			name = nm;
			price = prc;
		}
		
		public Item (int freq, String nm) {
			frequency = freq;
			name = nm;
		}
		
		public void addTotalNumBought (int add) {
			totalnumbought += add;
		}
		
		public void incTotalNumeBought () {
			totalnumbought++;
		}
		
		public void incCustBought () {
			custbought++;
		}
	}

		

	
