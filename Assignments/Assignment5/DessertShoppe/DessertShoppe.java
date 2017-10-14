package INFO5100.Assignment5.DessertShoppe;

/* The DessertShoppe class  contains constants such as the tax rate as well the name of the store
 *  the maximum size of an item name and the width used to display the costs of the items on the receipt
 *  Your code should use these constants wherever necessary
 *  The DessertShoppe class also contains the cents2dollarsAndCents method which takes an integer number of cents
 *  and returns it as a String formatted in dollars and cents. For example, 105 cents would be returned as "1.05".*/


//helper class,method must be static
public class DessertShoppe {
	public static final double TAX_RATE = 0.065;
	public static final String STORE_NAME ="M & M Dessert Shoppe";
	public static final int SIZE_ITEM_NAME =25;
	public static final int WIDTH_ITEM_ONE_LINE = 40;
	
	public static double centsToDollarsAndCents(double cents) {
		double dollar = cents / 100;
		return	Double.parseDouble(String.format("%.2f", dollar));
	}
	
	public static String formatString(String name) {
		if(name.length() > DessertShoppe.SIZE_ITEM_NAME ) 
			return name.substring(0, DessertShoppe.SIZE_ITEM_NAME);
		return name;		
	}
	
	public static String taxFormat(double tax) {
		if(tax <  1) {
			String[] s = String.valueOf(tax).split("\\.");
			return "."+s[1];
		}
		return String.valueOf(tax);
	}
	
}
