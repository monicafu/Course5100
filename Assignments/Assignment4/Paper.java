package INFO5100.Assignment4;

public class Paper extends Tool {
	
	
	protected Paper( int strength) {
		setStrength(strength); 
		setType('p');
	}
	@Override
	public boolean fight(Rock r) {
		double strength = getStrength()*2;
		return  strength > r.getStrength();
	}
	@Override
	public boolean fight(Scissors s) {
		double strength = getStrength()*0.5;
		return strength> s.getStrength();
	}
}
