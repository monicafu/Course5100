package INFO5100.Project2;

public class GroupOfCards {
	private Card[] cards;//child class will set the size of cards 
	private int currentSize = 0;//the size of the cards 
	
	//initial the card array
	public GroupOfCards(int size) {
		cards = new Card[size];	
		currentSize = size;
		}
		
	/* for testing add and remove 
	 * int i = 0;
		for ( int suit = 0; suit <= 3; suit++)
			for (int num = 2; num <= 14; num++ )
				cards[i++] = new Card(num,suit);	
	*/
	public Card[] getCard() {
		return cards;
	}
	public int getCurrentSize() {
		return currentSize;
	}
	/* add a card at the current filled part of the cards array
	 * @param: create the add card*/
	public void addCard(Card card) {
	
		//System.out.println("before add, the card is : "+cards[currentSize]);
		for (int i = 0 ; i< cards.length ; i++) {
			if ( cards[i] == null) {
				cards[i] = card;
				return;
			}
		}
		//cards[i]= card;//new Card(num,suit);	
		//cards[currentSize].setSuit(suit);
		//System.out.println("after add, the card is : "+cards[currentSize]);
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
		//System.out.println("before move index: "+i+" card: "+cards[i]);
		//System.out.println("before move index: "+index+" card: "+cards[index]);
		//System.out.println("intend move index: "+(index+1)+" card: "+cards[index+1]);
		//System.out.println("-----------------------");
		//shift all array elements down by one place
		for( int j = index; j < cards.length-1; j++) {
			cards[j] =cards[j+1];
			//System.out.println("move this index: "+(j)+" card: "+cards[j]);
			//System.out.println("after this index: "+(j+1)+" card: "+cards[j+1]);			
		}
		cards[cards.length-1] = null;
		currentSize --;
		return i;
	}
	
	//for test 
	public static void display() {		
		GroupOfCards deck = new GroupOfCards(52);
		//System.out.println(deck);
		//System.out.println(deck.cards[0]);
		int num = deck.cards[9].getNum();
		int suit = deck.cards[9].getSuit();
		deck.removeCard(deck.cards[9]);
		System.out.println(deck);
		deck.addCard(new Card(num,suit));
		System.out.println(deck);
		
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
