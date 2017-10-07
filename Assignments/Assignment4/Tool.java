package INFO5100.Assignment4;

public class Tool {
	private int strength;
	private char type;
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}	
	public boolean fight(Scissors s) {
		return this.getStrength() > s.getStrength(); 
	}

	public boolean fight(Paper p) {
		
		return this.getStrength() > p.getStrength();
	}
	
	public boolean fight(Rock r) {
		
		return this.getStrength() > r.getStrength();
	}
	
	
}
