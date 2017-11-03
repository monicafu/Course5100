package INFO5100.Project2;

import java.util.Arrays;
/* game class is have many players(Hand objects) & many tricks (Trick objects)
 * players play cards to one trick
 * all done, compute the points
 * @author: Jing Fu
 * @date:   10/30/2017
 * */

public class Game {
	public final int PLAYERS;//number of players
	private Deck deck;
	private Hand[] players;
	private Trick[] tricks;
	private int numberOfTricks = 0;//identify one trick 
	private boolean hearts = false;
	private boolean queenOfSpades = false;
	
	
	/* 1.set the numbers of players
	 * 2.calculate the numbers of cards one player have
	 * 3.init every player
	 * 4.init Hand array and Trick array*/
	public Game(int numberOfPlayers) {		
		
		this.PLAYERS = numberOfPlayers;
		int numberOfCards = Deck.TOTAL_CARDS / numberOfPlayers;
		players = new Hand[PLAYERS];
		for ( int i = 0; i < numberOfPlayers; i++ ) {
			players[i] = new Hand(i,numberOfCards);
		}		
		tricks = new Trick[numberOfCards];
	}
	
	public int getNumberOfTricks() {
		return numberOfTricks;
	}

	public boolean getHearts() {
		return hearts;
	}

	public boolean getQueenOfSpades() {
		return queenOfSpades;
	}

	public void setNumberOfTricks(int numberOfTricks) {
		this.numberOfTricks = numberOfTricks;
	}

	public void setHearts(boolean hearts) {
		this.hearts = hearts;
	}

	public void setQueenOfSpades(boolean queenOfSpades) {
		this.queenOfSpades = queenOfSpades;
	}
	/* start to play a game*/
	public void playAGame() {
		int playerNum = 0;//record the first to play
		//shuffling a deck 
		deck = new Deck();
		deck.shuffle();
		
		//dealCard to each player
		for ( int i = 0; i < tricks.length; i++) {
			for (int j = 0; j < PLAYERS; j++) {							
				if(deck.getCurrentCard() != 52) {
					players[j].addCard(deck.dealCard());
				}
			}
		}
		//print each player's cards
		System.out.println("Output  -  first part: \n");
		System.out.println("Ok, Let's deal cards to players \n");
		System.out.println("**************************************");
		for (int j = 0; j < players.length; j++) {
			players[j].setShortest();
			int shortest = players[j].getShortest();
			System.out.println("          player " + j +" shortest = " + shortest);
			players[j].sort();
			System.out.println(Arrays.toString(players[j].getCard()));
		}
		//find the player have the lowest clubs
		int temp = 0;
		Card[] cards1 = players[0].getCard();
		Card  firstPlay = cards1[0];
		int lowestClub = 13 * cards1[0].getSuit() + cards1[0].getNum();
		for (int i = 1; i < players.length; i++) {
			Card[] cards2 = players[i].getCard();
			int value = 13 * cards2[0].getSuit() + cards2[0].getNum();
			if ( value < lowestClub) {
				lowestClub = value;
				firstPlay = cards2[0];
				temp = i;
			}else {
				continue;
			}
		}
		playerNum = temp;
		System.out.println("OK, deal cards to all players  \n");
		System.out.println("Lowest clubs player [ "+ playerNum +" ] can first play.");
		System.out.println("***********************************");
		/****************************
		 * trick one is different
		 * */		
		System.out.println("Output  -  second part: \n");
		System.out.println("Let's start to play tricks \n");
		System.out.println("***********************************");
		Trick one = new Trick(PLAYERS);
		tricks[0] = one;
		numberOfTricks++;
		one.addCard(firstPlay);
		players[playerNum].removeCard(firstPlay);
		one.setWinningCard(firstPlay);
		one.update(playerNum, firstPlay);
		System.out.print("Player "+playerNum+"          "+ firstPlay);
		for (int j = 1; j < PLAYERS; j++) {
			playerNum =  (playerNum + 1) % PLAYERS;
			Card c =players[playerNum].playACard(this, one);
			if (one.isWinner(c)) one.setWinningCard(c);
			one.addCard(c);
			players[playerNum].removeCard(c);
			one.update(playerNum, c);
			System.out.print("Player "+playerNum+"          "+ c);
		}
		//add undelt cards to trick one:
		int cardsLeft = Deck.TOTAL_CARDS % PLAYERS;
		for (int k = Deck.TOTAL_CARDS - cardsLeft; k < Deck.TOTAL_CARDS ; k++ ) {
			Card undelt = deck.getCard()[k];
			//update the hearts and queenOfSpades
			updateHearsAndQueen(undelt);
			if( undelt.getNum() == 12 && undelt.getSuit() == 3 )
				one.setQueen(true);
			if (undelt.getSuit() == 2)
				one.setHearts(true);
			System.out.print("undelt Card      "+ undelt);
		}
		System.out.println();
		
		/****************************
		 * tricks loop
		 * 1.initial a new Trick() object, add to tricks array
		 * 2.increment number of tricks
		 * 3.loop players to play a card : player remove a card; trick add a card
		 * 4.use the trick.update() the trick
		 * 5.display every trick
		 * */
		while ( numberOfTricks < tricks.length) {
			Trick oneTrick = new Trick(PLAYERS);
			tricks[numberOfTricks] = oneTrick;		
			//getWinner in the last trick
			Trick lastTrick = tricks[numberOfTricks-1];//not numberOfTricks--
			playerNum = lastTrick.getWinner();
			numberOfTricks++;
			for (int j = 0; j < PLAYERS; j++) {
				playerNum =  (playerNum + 1) % PLAYERS;			
				Card c =players[playerNum].playACard(this, oneTrick);
				if (oneTrick.isWinner(c)) oneTrick.setWinningCard(c);
				updateHearsAndQueen(c);//why not print??
				oneTrick.addCard(c);
				players[playerNum].removeCard(c);
				oneTrick.update(playerNum, c);
				System.out.print("Player "+playerNum+"          "+ c);
			}
			System.out.println();
		}
		//after all tricks done, print the points
		for (int j = 0; j < PLAYERS; j++) {
			System.out.println("Player "+j+"   score = "+computePoints(j));
		}
	}
	/* update the status of hearts and queenOfSpades
	 * when card == heart, and heart is still false, set heart broken 
	 * @param: input a card
	 * */
	public void updateHearsAndQueen(Card card) {
		if ( card.getSuit() == 2 && !getHearts()) {
			System.out.println("Hearts is now broken");
			hearts = true;
		}
		if ( card.getNum() == 12 && card.getSuit() == 3) {
			queenOfSpades = true;
		}
	}
	/* 
	 * compute the points in a trick if contains queenOfSpades or hearts
	 * @param:  player's identify NUM
	 * @return: points of the player
	 * */
	public int computePoints(int playerNum) {
		int points = 0;
		for ( Trick oneTrick : tricks ) {
			if ( oneTrick.getWinner() == playerNum) {
				for (int i = 0; i < PLAYERS; i++) {
					Card[] cards = oneTrick.getCard();
					if ( cards[i].getNum() == 12 && cards[i].getSuit() == 3) {
						points += 13;
					}else if (cards[i].getSuit() == 2) {
						points += 1;
					}
				}
			}
		}
		return points;	
	}
	

}
