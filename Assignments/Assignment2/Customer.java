// score 2 + extra credit 1
package INFO5100.Assignment2;
import java.util.*;
/*  5. Write a java class called customer (Add detail as needed) : 
 *  i. Create Attributes: customer name and which pizzas customer has ordered. 
 *  ii. Think about what kind of data structure can be used to record the pizza name and number of each kind of pizza.( Give me your thought, Extra credit of 1 point)
 *  iii. In main method , sum up how much money the customer spent. 
 * */

public class Customer {
	String name;
	String address;
	String phone;
	String pizzaType;
	int pizzaNumber;
		
	HashMap<String, Integer> order =new HashMap<String, Integer>();//use HashMap to record the user's order pizza type and number of each kind of pizza.
	
	public double orderPizza(String type, int num) {
		double oncOrderPrice = 0.0;
		double unitprice = 0.0;
		Pizza pizza;
		// order pizzaType and record in the map
		if ( type != null && num !=0 ) {
			pizza = new Pizza(type);	
			order.put(type, Integer.valueOf(num));
			pizza.createPizza(type,num);
			pizza.setUnitPrice(type);
			unitprice = pizza.getUnitPrice();
			//test get right unitprice
			//System.out.println("unit price should be 4.5: "+unitprice);
		}
		// count the price
		while (order.size()!=0 ) {
			Integer i =order.get(type);
			//test get right number
			//System.out.println("number should be ?: "+i);
			oncOrderPrice += order.get(type) * unitprice;
			order.remove(type);
			//test every order price
			//System.out.println("total price should be ?: "+oncOrderPrice);
		}
		return oncOrderPrice;
	}

	
	public static void main(String args[]) {
		
		Customer monica = new Customer();
		double price1 = 0.0, price2=0.0,price3=0.0;
		price1 = monica.orderPizza("cheese",1);
		price2 = monica.orderPizza("pepperoni",2);
		price3 = monica.orderPizza("supreme",3);
		double money= price1+price2+price3;
		System.out.println("the money Monica spend should be 32.5 : "+ money);			
	}

}
