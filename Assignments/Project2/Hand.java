package INFO5100.Project2;

import java.util.Arrays;

/* Hand class is like a player
 * playACard is the strategy use to choose a card
 * receive from Game class if  hearts is broken
 * receive from Trick class the previou
 * @author: Jing Fu
 * @date:   10/28/2017
 * */

public class Hand extends GroupOfCards{
	public final int NUM;//player's identification
	private int shortest;
	private Card[] cards = getCard();
	
	
	public Hand(int playerNum,int numberOfCards) {		
		super(numberOfCards);//new card array to store the player's maximum cards at hand
		this.NUM = playerNum;
	}
	public int getShortest() {
		return shortest;
	}
	/* set the minimum number of suits to be the shortest
	 * clubs and diamonds should be the first choice
	 * because these cards have no points 
	 * when deploy void, can discard bad cards 
	 * 
	 * */
	public void setShortest() {
		int numOfClubs = 0;
		int numOfDiamonds = 0;
		int numOfSpades = 0;
		//count the number of suits
		for( Card one : cards) {
			if (one.getSuit() == 0) numOfClubs++;
			if (one.getSuit() == 1) numOfDiamonds++;
			if (one.getSuit() == 3 && one.getNum() <= 11) numOfSpades++;
		}
		//set the shortest suit
		if ( numOfSpades > 0 && numOfSpades <= numOfClubs && numOfSpades <= numOfDiamonds) this.shortest = 3;
		else if (numOfDiamonds > 0 && numOfDiamonds <= numOfClubs) this.shortest =1;
		else if (numOfClubs > 0) this.shortest = 0;

	}
	/* use selection sort : value = 13 * suit + number
	 * to sort the cards in ascending order  
	 * cards sorted by suit from Ace of spades down to 2 of clubs
	 * */
	public void sort() {
		int unsorted = getCurrentSize();
		for (int i = 0; i < unsorted; i++) {
			int minIdx = i;
			int minValue = cards[i].getSuit() * 13 +cards[i].getNum();
			for (int j =i+1; j < unsorted; j++) {
				int value = cards[j].getSuit() * 13 +cards[j].getNum();
				if (value < minValue) {
					swap(cards,i,j);
					minValue = value;
				}
			}
			int var = cards[i].getSuit() * 13 +cards[i].getNum();
			if( var < minValue)
				swap(cards,i,minIdx);
		}
	}
	
	private void swap(Card[] cards,int lo, int hi) {
		Card temp = cards[lo];
		cards[lo] = cards[hi];
		cards[hi] =temp;
	}
	/* use the find method below to find a strategy to deal a card
	 * @param: game reference 
	 * @param: trick reference
	 * @return: the deal card
	 * */
	public Card playACard(Game game,Trick trick) {
		
		int index = 0;//the index of the card to play
		Card card = trick.getWinningCard();
		int suit = 0;
		//the first player to play, there is no card in the trick.
		if (card == null)  suit = findLowest(game);//error null
		//int suit = card.getSuit(); // the biggest error not the judge the null
		 		
		//case 1.first hand
		if (trick.getCurrentSize() == 0) {
			if (findCount(getShortest()) != 0) {
				//shortest suit's highest card
				index = findHighest(getShortest());
			}else {
				if (trick.getHearts()) {
					//heart broken
					if(findCount(1)!=0) index = findLowest(1);//diamonds
					else if(findCount(3)!=0) index = findLowest(3);//spades
					else index = findLowest(2);//hearts
				}else if ( !trick.getHearts() && findLowest(game) > 0){
					//heart not broken
					index = findLowest(game);
				}
			}	 
		}else if( (trick.getCurrentSize() == game.PLAYERS -1) 
				&& !trick.getHearts() && !trick.getQueen()) {
			//case 2.last hand and don't have hearts and queen of spades
			index = findHighest(suit);
		}else if((trick.getCurrentSize() == game.PLAYERS -1) 
				&& !trick.getHearts() && !trick.getQueen()
				&& (findLastHigh(suit)) >= 0) {
			//case 3: last hand no bad card in the trick and findLastHigh
			index = findLastHigh(suit);		
		}else if (trick.getCurrentSize() > 0 && (trick.getHearts() || trick.getQueen())) {
			//case 4: middle hand or last hand with bad cards in trick
			if(findHighestBelow(trick.getWinningCard()) >= 0) {
				index = findHighestBelow(trick.getWinningCard());
			}else if (( findHighestBelow(trick.getWinningCard()) < 0 ) && (findMiddleHigh(game, suit)) >=0) {
				index = findMiddleHigh(game, suit);
			}//cases: void and discard a bad card
			else if (findCount(suit) == 0 && (find(12,3)) >= 0) {
				index = find(12,3);
			}else if (findCount(suit) == 0 && (find(14,3)) >= 0) {
				index = find(14,3);
			}else if (findCount(suit) == 0 && (find(13,3)) >= 0) {
				index = find(13,3);
			}else if (findCount(suit) == 0 && (findHighest(2)) >= 0){
				index = findHighest(2);
			}else {
			//when cannot follow suit, and no bad cards either, play a card 
				index = findHighest();
			}
		}
		//remove the card with the result index
		//removeCard(cards[index]);  //don't remove, remove is in the playAGame,duplicate remove.
		//update trick and game
		trick.update(NUM, cards[index]);
		return cards[index];
		
	}
	
	/* find a specific suit/num of a card
	 * @param: num of the card
	 * @param: suit of the card
	 * @return: index of the card, else return -1*/
	private int find(int num,int suit) {

		for (int i = 0; i < getCurrentSize(); i++) {
			if ( cards[i].getSuit() == suit && cards[i].getNum() == num) {
				return i;
			}
		}
		return -1;
	}
	
	/* count the given suit's number
	 * @param: input one suit
	 * @return: count number of suit, else return -1*/
	private int findCount(int suit) {
		int[] count = new int[4];
		for (int i = 0; i < getCurrentSize(); i++) {
			switch(cards[i].getSuit()){
			case 0: count[0]++;
			case 1: count[1]++;
			case 2: count[2]++;
			case 3: count[3]++;
			}
		}
		switch(suit){
		case 0: return count[0];
		case 1: return count[1];
		case 2: return count[2];
		case 3: return count[3];
		}
		return -1;
	}
	
	/* find the lowest number of the indicated suit
	 * @param: input a suit kind
	 * @return: index of the lowest numbered card in the  suit, else return -1.*/
	private int findLowest(int suit) {
		sort();
		if ( suit == 0 && findCount(0) !=0 ) return 0;
		if ( suit == 1 && findCount(1) !=0)  return findCount(0);
		if ( suit == 2 && findCount(2) !=0)  return findCount(0)+findCount(1);
		if ( suit == 3 && findCount(3) !=0)  return getCurrentSize()-findCount(3);
		return -1;		
	}
	
	/*  find the lowest number in your hand, consider the heart broken or not
	 *  @param : game 
	 *  @return: lowest number's index 
	 *  If hearts have not been broken and all you have left is hearts, return -1.*/
	private int findLowest(Game game) {
		sort();
		if ( !game.getHearts() && cards[0].getSuit() != 2) 
			//hearts not broken
			return 0;
		else if ( !game.getHearts() && (findCount(0)==0 && findCount(1)==0 && findCount(2)==0 )) return -1;
		//heart broken
		else return 0;
	}

	
	/* find the highest card in your shortest suit
	 * @return: the index of the highest card, if no cards in that suit -1
	 * */
	private int findHighest(int suit) {
		sort();
		if ( suit == 0 && findCount(0) !=0 ) return findCount(0)-1;
		if ( suit == 1 && findCount(1) !=0)  return findCount(0)+findCount(1)-1;
		if ( suit == 2 && findCount(2) !=0)  return getCurrentSize()-findCount(3);
		if ( suit == 3 && findCount(3) !=0)  return getCurrentSize()-1;
		return -1;			
	}
	/* find the highest card in the suit led when there are no bad cards in the trick
	 * @param: input a suit
	 * @return: the last high index*/
	private int findLastHigh(int suit) {
		//queen of spades
		if ( suit == 3 && findHighest(suit) == 12) {
			if (findHighest(3) < 12)
				return findHighest(3);
			else 
				return -1;
			}
		return findHighest(suit);
		}
		
	

	/* when follow suit,find card below the winning card
	 * @param: current winning card 
	 * @return: find a card same as the suit and less than the suit, else -1*/
	private int findHighestBelow(Card winningCard) {
		for (int i = 0; i < getCurrentSize()-1; i++) {
			if (cards[i].getSuit() == winningCard.getSuit() && cards[i].getNum() < winningCard.getNum() ) {
				if (cards[i+1].getSuit() != winningCard.getSuit()) {
					return -1;
				}else {
					return i;
				}		
			}
		}
		return -1;
	}
	/* find the middle card of the highest card of the suit
	 * @param: game reference to get the boolean values
	 * @param: suit of the card
	 * @return: index of the card, else return -1*/
	private int findMiddleHigh(Game game,int suit) {
		//if the suit is not spades, use the highest 
		if (suit != 3) return findHighest(suit);
		//if the suit is spades
		else if  ( suit == 3 && game.getQueenOfSpades() == false) {
			for (int i = 0; i< getCurrentSize(); i++) {
				if (cards[i].getNum() <= 11)
					return i;
			}
		}
		return -1;
	}
	
	/* when cannot follow suit, and no bad cards
	 * choose a highest remaining card,regardless of suit
	 * @return: the index of the card*/
	private int findHighest() {
		sort();
		return getCurrentSize()-1;
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
	
	public static void main(String[] args) {
		Hand hand = new Hand(4,13);
		System.out.println(Arrays.toString(hand.cards));
	}
	
}
