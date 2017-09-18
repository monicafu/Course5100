package INFO5100.Assignment2;

/* 4. Write a java class called pizza with (Add detail as needed) : 
 * i. At least 3 attributes :pizza type , unit price and loyalty points. More attributes are welcome to have. 
 * ii. Constructor is needed. Extra-credit for 0.5 point if you write more than 1 right constructor for this class
 * */

public class Pizza {
	
	String pizzaType;//flavor:1. cheese; 2.pepperoni 3.meatLove 4. supreme 5.createOwn
	double unitPrice;
	int loyaltyPoints;
	int pizzaCode;//the code is a other identify for seller, type is for customer
	String size;//the size can be small,medium,large
	double fat;
	double calory;
	double quantity;	
	String crusts;// thin, thick
	String sauces;//tomato, cheese
	String ingredients;//vegetable,meat
	boolean isNew;
	boolean inDeal;
	boolean isBestSeller;
	
	
	public Pizza() {
		super();
	}
	
	public Pizza(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	
	
	public Pizza(String type,double price,int points){
		this.pizzaType = type;
		this.unitPrice = price;
		this.loyaltyPoints = points;	
	}
	
	public Pizza(double fat, double calory, double quantity) {
		this.fat = fat;
		this.calory = calory;
		this.quantity = quantity;
	}
	
	public Pizza(String crusts, String sauces, String ingredients) {
		this.crusts = crusts;
		this.sauces = sauces;
		this.ingredients = ingredients;
	}
	public Pizza(boolean isNew, boolean inDeal, boolean isBestSeller) {
		this.isNew = isNew;
		this.inDeal = inDeal;
		this.isBestSeller = isBestSeller;
	}

	public Pizza(String pizzaType, double unitPrice, int loyaltyPoints, int code, String size, double fat,
			double calory, double quantity) {
		this.pizzaType = pizzaType;
		this.unitPrice = unitPrice;
		this.loyaltyPoints = loyaltyPoints;
		this.pizzaCode = code;
		this.size = size;
		this.fat = fat;
		this.calory = calory;
		this.quantity = quantity;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setUnitPrice(String type) {
		if (type != null) {
			if (type.equals("cheese")) {
				this.unitPrice = 4.5;
			} else if (type.equals("pepperoni")) {
				this.unitPrice =  5.0;
			} else if (type.equals("meatLove")) {
				this.unitPrice =  5.5;
			} else if (type.equals("supreme")) {
				this.unitPrice =  6.0;
			} else {
				this.unitPrice = 7.0;
			}
		}
	}

	public double getUnitPrice() {
		return this.unitPrice;
	}
	
	
	public void createPizza(String type, int num) {		
		System.out.println("Pizza: "+type+" is successfully order,number:"+ num);
	}
}
