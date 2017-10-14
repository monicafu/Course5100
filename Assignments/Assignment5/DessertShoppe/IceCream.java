package INFO5100.Assignment5.DessertShoppe;

public class IceCream extends DessertItem {
	private double iceCreamPrice;
	
	public IceCream(String name, double iceCreamPrice ){
		super(name);
		this.iceCreamPrice = iceCreamPrice;	
	}
	@Override
	public double getCost() {	
		return iceCreamPrice;
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
		return sb.toString();
	}
}