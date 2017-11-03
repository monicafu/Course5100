package INFO5100.Project2;

public class Deck extends GroupOfCards{
	public static final int TOTAL_CARDS = 52;
	private int currentCard;
	private Card[] cards = getCard();
	
	public int getCurrentCard() {
		return currentCard;
	}

	public Card[] getCards() {
		return cards;
	}

	public void setCurrentCard(int currentCard) {
		this.currentCard = currentCard;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public Deck() {
		super(TOTAL_CARDS);
		int i = 0;
		for ( int suit = 0; suit <= 3; suit++)
			for (int num = 2; num <= 14; num++ )
				cards[i++] = new Card(num,suit);	
		currentCard = 0;
	}
	
	/* 
	 * make the cards disorder
	 * to random pick a card and shuffle to the end of the array
	 * */
	public void shuffle() {
		int unshuffled = getCurrentSize();		
		for (int i = unshuffled; i >= 0; i--) {
			int randomIndex = (int)(Math.random()*unshuffled);
			int num = cards[randomIndex].getNum();
			int suit = cards[randomIndex].getSuit();
			Card addCard = new Card(num,suit);			
			removeCard(cards[randomIndex]);
			addCard(addCard);
			unshuffled--;

			
		}	
	}
	/* deal a card to one player£¬remove the card at index = 0;
	 * @param: 
	 * @return: the index = 0 card*/
	public Card dealCard() {	
		
		return cards[currentCard++];
	}
	
	
	public String toString() {
		String s = "";
		int k = 0;		
		for (int i = 0; i< cards.length; i++ ) {
			s += cards[k++]+"";
		}
		return s ;
	}
	public static void main(String[] args) {
		//test init
		Deck deck = new Deck();
		//System.out.println(deck);
		//test shuffle
		deck.shuffle();
		System.out.println(deck);
		
		//test dealCard
		System.out.println(deck.dealCard());
	}

}
