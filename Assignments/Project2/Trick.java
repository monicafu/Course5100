package INFO5100.Project2;

public class Trick extends GroupOfCards{

	private int winner;//the player's number
	private Card winningCard;
	private boolean hearts = false;
	private boolean queenOfSpade = false;
	
	public Trick(int players) {
		//first trick should contain the undelt cards
		super( 2 * players -1 );		
	}

	public int getWinner() {
		return winner;
	}

	public Card getWinningCard() {
		return winningCard;
	}

	public boolean getHearts() {
		return hearts;
	}

	public boolean getQueen() {
		return queenOfSpade;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public void setWinningCard(Card winningCard) {
		this.winningCard = winningCard;
	}

	public void setHearts(boolean hearts) {
		this.hearts = hearts;
	}

	public void setQueen(boolean queen) {
		this.queenOfSpade = queen;
	}
	
	/* update the winner info and player info 
	 * @param: card: the current card
	 * @param: playerNum the number of player*/
	public void update(int playerNum,Card card) {
		if (card == null) return;
		if (isWinner(card)) {
			setWinner(playerNum);
			setWinningCard(card);			
		}
		if( card.getSuit() == 2) {
			hearts = true;
		}else if ( card.getSuit() == 3 && card.getNum() == 12 ) {
			queenOfSpade =true;
		}
	}
	
	/* give a card to judge is a winner card
	 * @param: the current card
	 * @return: if the current card if win
	 * */
	public boolean isWinner(Card card) {
		if (getWinningCard() == null) return true;
		if( card.getSuit() !=getWinningCard().getSuit() || card.getNum() < getWinningCard().getNum()) {
			return false;
		}
		return true;
		
	}
	
	public String toString() {
		Card[] cards = getCard();
		String s = "";
		int k = 0;		
		for (int i = 0; i< cards.length; i++ ) {
			s += cards[k++]+"";
		}
		return s ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
