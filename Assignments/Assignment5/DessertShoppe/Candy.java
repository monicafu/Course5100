package INFO5100.Assignment5.DessertShoppe;

import java.util.ArrayList;

public class Candy extends DessertItem{
	private double weight;
	private double pricePerPound;
	
	public Candy(String name, double weight, double pricePerPound ){
		super(name);		
		this.weight = weight;
		this.pricePerPound = pricePerPound;
	}
	@Override
	public double getCost() {		
		return weight*pricePerPound;
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
		return (double)this.weight+" lbs."+"  "+"@ "+DessertShoppe.taxFormat(pricePerPound/100)+" /lb."+"\n"+sb.toString();
	}
}
