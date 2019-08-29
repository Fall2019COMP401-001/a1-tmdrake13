package a1;

import java.util.Scanner;

public class A1Jedi {

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
						
						 customers[i].itemsbought[j] = new Item (frequency, name);

						customers[i].setTotalSpent (customers[i].itemsbought[j].price * customers[i].itemsbought[j].frequency);
					}
				}		
				
					
				
				scan.close();
				
				 for (int i = 0; i < storeitems.length; i ++) {
					 for (int j = 0; j < customers.length; j++) {
						 for (int m = 0; m < customers[j].itemsbought.length; m++) {
							 if (customers[j].itemsbought[m].name.equals((storeitems[i].name))) {
								 storeitems[i].incCustBought();
								 storeitems[i].addTotalNumBought(customers[j].itemsbought[m].frequency);
								 break;
							 }
									 
						 }
					 }
					 
				 } 
				 
				
				 
				 
				 
				 for (int i = 0; i < storeitems.length; i++ ) {
					 if (storeitems[i].custbought != 0) {
					 System.out.println (storeitems[i].custbought + " customers bought " + storeitems[i].totalnumbought + " " +  storeitems[i].name); }
					 else {
						 System.out.println ("No customers bought " + storeitems[i].name);
					 }
					 
				 }
				
	}
	
	
		
}
