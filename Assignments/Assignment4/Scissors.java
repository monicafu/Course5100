package INFO5100.Assignment4;


public class Scissors extends Tool {

	protected Scissors(int strength) {
		this.setStrength(strength); 
		this.setType('s');
	}
	@Override
	public boolean fight(Paper p) {
		double strength = getStrength()*2;
		return strength>p.getStrength();
	}
	@Override
	public boolean fight(Rock r) {
		double strength = getStrength()*0.5;
		return strength > r.getStrength(); 
	}
}
