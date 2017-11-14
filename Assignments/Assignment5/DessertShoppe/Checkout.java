package INFO5100.Assignment5.DessertShoppe;

import java.util.*;
/* The Checkout class, provides methods to enter dessert items into the cash register, clear the cash register,
 * get the number of items, get the total cost of the items (before tax),
 * get the total tax for the items, and get a String representing a receipt for the dessert items. 
 * The Checkout class must use a Vector to store the DessertItem's. 
 * The total tax should be rounded to the nearest cent. 
 * The complete specifications for the Checkout class are provided in the file Class-Checkout.
 * */
public class Checkout {
	
	Vector<DessertItem> desserts =new Vector<DessertItem>(); // access should be private
	
	public void enterItem(DessertItem item) {
		desserts.add(item);
	}
	public int numberOfItems() {
		return desserts.size();
	}
	public int totalCost() {
		double sum = 0;
		for(DessertItem item:desserts) {
			sum += item.getCost();
		}
		return (int)Math.round(sum);
		//return (int)sum;
	}
	public int totalTax() {
		return (int)Math.round(totalCost()*DessertShoppe.TAX_RATE);
	}	
	public void clear() {
		desserts.clear();
	}
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		//print title
		//the TestCheckout has already printed.
		
		//print shop name
		sb.append("          "+DessertShoppe.STORE_NAME+"          "+"\n");
		sb.append("         "+"--------------------------"+"          "+"\n");
		
		
		//print the item (name+weight+price)
		for(DessertItem item:desserts) {
			 sb.append(item.toString()+"\n") ;
		}
		sb.append("\n");
		//print the dollars and cents tax +total cost
		double tax = DessertShoppe.centsToDollarsAndCents((double)totalTax());
		
		double total_cost = DessertShoppe.centsToDollarsAndCents((double)(totalCost()+totalTax()));
		
		int spaceLength1 = DessertShoppe.WIDTH_ITEM_ONE_LINE-"Tax".length();
		int spaceLength2 = DessertShoppe.WIDTH_ITEM_ONE_LINE-"Total Cost".length();
		sb.append("Tax");
		for(int i = 0; i<spaceLength1 ;i++) {
			sb.append(" ");
		}
		String taxFormat = DessertShoppe.taxFormat(tax);
		sb.append(taxFormat); // tax amount is not right aligned in the display
		sb.append("\n");
		
		sb.append("Total Cost");
		for(int i = 0; i<spaceLength2 ;i++) {
			sb.append(" ");
		}
		sb.append(total_cost+"\n");
		sb.append("\n");	
		return sb.toString();		
		
	}	
}
