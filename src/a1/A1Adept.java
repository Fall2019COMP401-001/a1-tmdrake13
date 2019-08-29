package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//input number of items in store
		int numstoreitems = scan.nextInt();
		
		Item [] storeitems = new Item [numstoreitems];
		
		for (int i = 0; i < numstoreitems; i++) {
			//input name of item
			String name = scan.next();
			//input price of item
			double price = scan.nextDouble();
			storeitems[i] = new Item (name, price);
			
		}
		
		//input number of customers
		int numcustomers = scan.nextInt();
		 Customer [] customers = new Customer [numcustomers];
		
		for (int i = 0; i < numcustomers; i++) {
			//input first name of customer
			String fname = scan.next();
			//input last name of customer
			String lname = scan.next();
			//input number of items bought
			int numitemsbought = scan.nextInt();
			
			customers[i] = new Customer (fname, lname, numitemsbought);
	
			
			for (int j = 0; j < customers[i].numitemsbought; j++) {
				//input integer quantity
				 int frequency = scan.nextInt();
				 //input name of items bought
				 String name = scan.next();
				
				 double price = 0;
				 
					 
				for (int m = 0; m < storeitems.length; m++) {
					if (storeitems[m].name.equals(name)) {
						price = storeitems[m].price;
					}
				}
				 
				 customers[i].itemsbought[j] = new Item (frequency, name, price);

				
				customers[i].setTotalSpent (customers[i].itemsbought[j].price * customers[i].itemsbought[j].frequency);
			}
		}		
		
			
		
		scan.close();
		
			double max = 0;
			String maxname = "";
			for (int i = 0; i < customers.length; i++) {
				if (customers[i].totalspent > max) {
					max = customers [i].totalspent;
					maxname = customers[i].firstname + " " + customers[i].lastname;
				}
			
		}
			
			double min = Double.MAX_VALUE;
			String minname = "";
			for (int i = 0; i < customers.length; i++) {
				if (customers[i].totalspent < min) {
					min = customers [i].totalspent;
					minname = customers[i].firstname + " " +  customers[i].lastname;
				}
			
		}
			
			double average;
			double sum = 0;
			for (int i = 0; i < customers.length; i++) {
				sum += customers[i].totalspent;
			}
			average = sum / customers.length ;
			
			System.out.println ("Biggest: " + maxname + " (" + String.format("%.2f", max) + ")");
			System.out.println ("Smallest: " + minname + " (" + String.format("%.2f", min) + ")");
			System.out.println ("Average: " + String.format("%.2f", average));
			
		
	}
	
}
