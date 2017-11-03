package INFO5100.Project2;

public class GroupOfCards {
	private Card[] cards;//child class will set the size of cards 
	private int currentSize = 0;//the size of the cards 
	
	//initial the card array
	public GroupOfCards(int size) {
		cards = new Card[size];	
		currentSize = size;
		}
		
	public Card[] getCard() {
		return cards;
	}
	public int getCurrentSize() {
		return currentSize;
	}
	/* add a card at the current filled part of the cards array
	 * @param: create the add card*/
	public void addCard(Card card) {
		for (int i = 0 ; i< cards.length ; i++) {
			if ( cards[i] == null) {
				cards[i] = card;
				return;
			}
		}
		currentSize++;
	}
	
	/* remove a card in the cards array
	 * @param: input a card to be removed
	 * @return : the originally index of the removed card in the array
	 * */
	public int removeCard(Card card) {
		int index = 0;
		int suit = card.getSuit();
		int num = card.getNum();
		int i = 0;
		while( i < cards.length) {
			if (cards[i].getSuit() == suit && cards[i].getNum() == num) {
				index = i;
				break;
			}
			i++;
		}
		for( int j = index; j < cards.length-1; j++) {
			cards[j] =cards[j+1];		
		}
		cards[cards.length-1] = null;
		currentSize --;
		return i;
	}
	
	//for test 
	public static void display() {		
		GroupOfCards deck = new GroupOfCards(52);		
	}
	public String toString() {
		String s = "";
		int k = 0;		
		for (int i = 0; i< cards.length; i++ ) {
			s += cards[k++]+"";
		}
		return s ;
	}
	
	public static void main(String args[]) {
		display();
	}
	
}
