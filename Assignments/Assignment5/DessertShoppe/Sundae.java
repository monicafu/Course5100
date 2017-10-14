package INFO5100.Assignment5.DessertShoppe;

public class Sundae extends IceCream{
	private String topName;
	private double topPrice;
	
	public Sundae(String iceCreamName,double iceCreamPrice,String topName,double topPrice) {
		super(iceCreamName,iceCreamPrice);
		this.topName = topName;
		this.topPrice = topPrice;
	}
	public double getCost() {
		return super.getCost()+topPrice;
	}
	public String toString() {
		String formatIceCreamName  = DessertShoppe.formatString(dessertName);
		String formatTopName =DessertShoppe.formatString(topName);
		StringBuilder sb = new StringBuilder();	
		sb.append(formatIceCreamName+" with");
		int spaceLength1 = DessertShoppe.WIDTH_ITEM_ONE_LINE-formatIceCreamName.length();
		for(int i = 0; i<spaceLength1 ;i++) {
			sb.append(" ");
		}
		sb.append("\n");
		sb.append(formatTopName);
		int spaceLength2 = DessertShoppe.WIDTH_ITEM_ONE_LINE-formatTopName.length();
		for(int i = 0; i<spaceLength2 ;i++) {
			sb.append(" ");
		}
		return sb.toString()+DessertShoppe.centsToDollarsAndCents(getCost());
	}
}

