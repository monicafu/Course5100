package INFO5100.Assignment4;

public class RockPaperScissorsGame { // score 2
	
	public static void main(String args[]){
		Scissors s = new Scissors(5);
		Paper p = new Paper(7);
		Rock r = new Rock(15);
		System.out.println(s.fight(p) + " , "+ p.fight(s) );
		System.out.println(p.fight(r) + " , "+ r.fight(p) );
		System.out.println(r.fight(s) + " , "+ s.fight(r) );
		}
}
