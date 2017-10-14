package INFO5100.Assignment5.DessertShoppe;


/* The DessertItem class is an abstract superclass from which specific types of DessertItems can be derived.
 *  It contains only one data member, a name. It also defines a number of methods. 
 *  All of the DessertItem class methods except the getCost() method are defined in a generic way in the file Class-DessertItem,
 *  provided for you along with the other homework specific files in the directory. 
 *  The getCost() method is an abstract method that is not defined in the DessertItem class 
 *  because the method of determining the costs varies based on the type of item.
 *  Tax amounts should be rounded to the nearest cent. 
 *  For example, the calculating the tax on a food item with a cost of 199 cents with a tax rate of 2.0% should be 4 cents. 
 *  The complete specifications for the DessertItem class are provided in the file Class-DessertItem.
 * */

public abstract class DessertItem {
	String dessertName;
	
	public DessertItem(String dessertName) {
		this.dessertName = dessertName;
	}
	/*The getCost() method is an abstract method that is not defined in the DessertItem class 
	 * because the method of determining the costs varies based on the type of item.
	 * */ 
	public abstract double getCost();

}

