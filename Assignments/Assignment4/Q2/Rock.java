package INFO5100.Assignment4;

public class Rock extends Tool {
		
	
	protected Rock( int strength) {
		setStrength(strength); 
		setType('r');
	}
	@Override
	public boolean fight(Paper p) {
		
		double strength = getStrength()*0.5;
		return strength > p.getStrength();
	}
	
	@Override
	public boolean fight(Scissors s) {
		
		double strength = getStrength()*2;
		return strength > s.getStrength();
	}
	
}
