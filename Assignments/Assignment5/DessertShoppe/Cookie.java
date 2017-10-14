package INFO5100.Assignment5.DessertShoppe;

public class Cookie extends DessertItem{
	private double number;
	private double pricePerDozen;
	
	public Cookie(String dessertName,double number,double pricePerDozen) {
		super(dessertName);
		this.number = number;
		this.pricePerDozen = pricePerDozen;
		
	}

	@Override
	public double getCost() {
		return number*pricePerDozen/12;
	}
	
	public String toString() {
		String formatDessertName  = DessertShoppe.formatString(dessertName);
		StringBuilder sb = new StringBuilder();
		int spaceLength = 0; 		
		sb.append(formatDessertName);
		spaceLength = DessertShoppe.WIDTH_ITEM_ONE_LINE-formatDessertName.length();
		for(int i = 0; i<spaceLength ;i++) {
			sb.append(" ");
		}
		sb.append(DessertShoppe.centsToDollarsAndCents(getCost()));
		return this.number+"lbs."+"  "+"@"+pricePerDozen/100+"/dz."+"\n"+sb.toString();
	}
}
