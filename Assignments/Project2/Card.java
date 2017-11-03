package INFO5100.Project2;

public class Card {
	private int num;//numbers of cars from 2--14
	private int suit;//0--clubs,1,--diamonds,2--hearts,3--spades.
	
	public Card(int num,int suit) {
		this.num = num;
		this.suit = suit;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public int getNum() {
		return num;
	}

	public int getSuit() {
		return suit;
	}

	public  String getNumOfCards() {
		switch(num) {
		case 2:  return "2";
		case 3:  return "3";
		case 4:  return "4";
		case 5:  return "5";
		case 6:  return "6";
		case 7:  return "7";
		case 8:  return "8";
		case 9:  return "9";
		case 10: return "10";
		case 11: return "Jack";
		case 12: return "Queen";
		case 13: return "King";
		case 14: return "Ace";
		default: return "";
		}
	}
	
	public String getSuitOfCards() {
		switch(suit) {
		case 0:  return "Clubs";
		case 1:  return "Diamonds";
		case 2:  return "Hearts";
		case 3:  return "Spades";
		default: return "";
		}
	}
	
	//for test 
	public static void display() {
		Card card = new Card(14,2);
		System.out.println(card);
	}
	
	
	@Override
	public String toString() {
		String number = getNumOfCards();
		String suits =  getSuitOfCards();
		return number + " of " + suits+"\n";
	}
	
	public static void main(String args[]) {
		display();
	}
	
	
}
