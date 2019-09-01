package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// input number of items in store
		int numstoreitems = scan.nextInt();

		Item[] storeitems = new Item[numstoreitems];

		for (int i = 0; i < numstoreitems; i++) {
			// input name of item
			String name = scan.next();
			// input price of item
			double price = scan.nextDouble();
			storeitems[i] = new Item(name, price);

		}

		// input number of customers
		int numcustomers = scan.nextInt();
		Customer[] customers = new Customer[numcustomers];

		for (int i = 0; i < numcustomers; i++) {
			// input first name of customer
			String fname = scan.next();
			// input last name of customer
			String lname = scan.next();
			// input number of items bought
			int numitemsbought = scan.nextInt();
			
			//add new customer to array of customers based on inputed parameters
			customers[i] = new Customer(fname, lname, numitemsbought);

			for (int j = 0; j < customers[i].numitemsbought; j++) {
				// input integer quantity
				int frequency = scan.nextInt();
				// input name of items bought
				String name = scan.next();

				double price = 0;

				//this loop matches up the inputed item bought with the original
				//list of items based on the items name. This is necessary in order
				//to calculate the price of that item
				
				for (int m = 0; m < storeitems.length; m++) {
					if (storeitems[m].name.equals(name)) {
						price = storeitems[m].price;
					}
				}
				
				//once the price of the item is determined, that item, along with its price,
				//is added to the array of items bought for each customer
				customers[i].itemsbought[j] = new Item(frequency, name, price);

				//using the array of items bought for each customer, we calculate
				//the total amount spent by that customer and use the method setTotalSpent
				//to store that value as an instance variable for that customer
				customers[i].setTotalSpent(customers[i].itemsbought[j].price * customers[i].itemsbought[j].frequency);
			}
		}

		scan.close();
		
		//now that the total amount spent has been calcualted and stored for
		//each customer, we then determine the max/min amount spent by using
		//a simple algorithm

		double max = 0;
		String maxname = "";
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].totalspent > max) {
				max = customers[i].totalspent;
				maxname = customers[i].firstname + " " + customers[i].lastname;
			}

		}

		double min = Double.MAX_VALUE;
		String minname = "";
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].totalspent < min) {
				min = customers[i].totalspent;
				minname = customers[i].firstname + " " + customers[i].lastname;
			}

		}
		
		//finally, we calculate the average amount spent for all customers

		double average;
		double sum = 0;
		for (int i = 0; i < customers.length; i++) {
			sum += customers[i].totalspent;
		}
		average = sum / customers.length;

		//we then print off the max, min, and average values we just calculated
		//using the correct two-decimal format
		
		System.out.println("Biggest: " + maxname + " (" + String.format("%.2f", max) + ")");
		System.out.println("Smallest: " + minname + " (" + String.format("%.2f", min) + ")");
		System.out.println("Average: " + String.format("%.2f", average));

	}

}
