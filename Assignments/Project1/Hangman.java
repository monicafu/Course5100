package INFO5100.Project1;
import java.io.IOException;
import java.util.*;

import acm.util.RandomGenerator;


public class Hangman {
	
	public static String[] original = {"computer","algorithm","java","object","oriented","siva","harsha","professor","monica","student"};
	GameHelper helper = new GameHelper();//get user input
	private ArrayList<String> secretWordList = new ArrayList<String>();//the secret the word list
	private ArrayList<String> correctList;//correct guess,used to display
	private ArrayList<String> chooseWord;//why use ArrayList, because the end to game won will use isEmpty
	private String userInput;//Receive from the helper class 
	private int guessTimes = 0;//count user's total guess time
	private int wrongCount = 0;//count user's wrong time 
	static final int MAX_WRONG_COUNTS = 8;//the max wrong times
	private boolean isFinished = false;//sentinel to calculate if user guess the word
	
	//init the wordlist
	public Hangman(ArrayList<String> secretWordList){
		this.secretWordList = secretWordList;		
	}
	//Randomly chooses a word from the list
	//update the instance var: chooseWord
	//init correctList with dashes
	public void chooseWord(){	
		
		chooseWord =new ArrayList<String>();//error:forget to init, and create another local var chooseWord not the same as instance var
		//产生一个0--size之间的坐标
		int random =(int)(Math.random()*secretWordList.size());
		//System.out.println(random);
		String ramdomWord = secretWordList.get(random);
		char[] c = ramdomWord.toCharArray();
		for(int i=0; i<c.length;i++ ) {
			chooseWord.add(String.valueOf(c[i]));//char transfer to String
		}	
		//System.out.println(chooseWord);//used for test
		
		//init correct list
		correctList = new ArrayList<String>();
		for(int i = 0 ;i < chooseWord.size();i++) {
			correctList.add("-");
		}
	}
	
	//1.start the game,display instructions to user
	public void playGame() {
		System.out.println("----------------------------------------------");
		System.out.println("| I'm the Hangman, Let's play guess a word    |");
		System.out.println("| You total have 8 times                      |");
		System.out.println("| If wrong, You will be hanged at a scaffold. |");
		System.out.println("| Don't be scared, Let's play with fun        |");
		System.out.println("-----------------------------------------------");
		System.out.println();
	}

	//2.handle the guess and add the letter to CorrectList and WrongList
	//update the instance var: correctList
	//update the instance var:guessTimes and wrongCount
	//judge the gameWon or gameOver
	public void handleGuess() throws IOException{
		
		//ask user to input
		userInput = helper.userInput();
		if( userInput != null) {
			//word==userInput--->update  correctList
			if(!chooseWord.contains(userInput)) {
				wrongCount++;
				printHangman();
				displayWord();
			}else {
				for (int i = 0; i < correctList.size(); i++) {
					if (chooseWord.get(i).equalsIgnoreCase(userInput)) {
						//replace the dash with userInput, use set method!
						correctList.set(i, userInput);
						//update the chooseWord, because maybe have duplicate character
						chooseWord.set(i, "!");//set the guessed to special char
						guessTimes++;
						printHangman();
						displayWord();
						break;
					}else {
						continue;
					}
				}	
			}
		}
		if ( wrongCount == MAX_WRONG_COUNTS ) gameOver();
		int count = 0;
		for (int i = 0 ; i < correctList.size();i++) {
			
			if ( chooseWord.get(i) == "!" )  count++;
		}
		if(count == chooseWord.size()) {//count the special to make sure user's guess
			gameWon();
			isFinished = true;//Sentinel
			}
	}
	
	//3.print hangman after every guess
	//print Scaffold class
	public void printHangman() {
		switch(wrongCount) {
		case 0: System.out.println( Scaffold.hangman); break;
		case 1: System.out.println( Scaffold.head);break;
		case 2: System.out.println( Scaffold.body);break;
		case 3: System.out.println( Scaffold.larm);break;
		case 4: System.out.println( Scaffold.rarm);break;
		case 5: System.out.println( Scaffold.lleg);break;
		case 6: System.out.println( Scaffold.rleg);break;
		case 7:	System.out.println( Scaffold.lfoot);break;
		case 8: System.out.println( Scaffold.rfoot);break;
		}
		
	}
	
	//4.display the correctly guessed letters and hide the remaining with dashes.
	public void displayWord() {
		//print the correctList 
		System.out.print("Your word now looks like this: [ ");
		for(int i = 0 ;i < correctList.size();i++) {
			System.out.print(correctList.get(i));
		}
		System.out.print(" ]");
		System.out.println("\nYour have "+(MAX_WRONG_COUNTS-wrongCount)+" times left.");
	}
	
	//5.return true if user wins the game
	//print a message to user about the words/guess times or the congratulations
	public boolean gameWon() {
		System.out.println("--------------------------------");
		System.out.println("| Congratulations, you guess it.|");
		System.out.println("| Your guess time is  "+guessTimes+"         |");
		System.out.println("--------------------------------");
		return true;
	}
	
	//6.exit the program after the game is over
	//clear the word list 
	public void gameOver() {	
		System.out.println("----------------------------");
		System.out.println("| Sorry, game over!        |");
		System.out.println("| You have guessed 8 times |");
		System.out.println("----------------------------");
		correctList.clear();
	}
	
	public static void  main(String args[]) throws IOException {
		
		ArrayList<String> secret= new ArrayList<String>();
		//add the String words list to secret list
		for(int i = 0; i< original.length;i++) {
			secret.add(original[i]);
		}
		//init the secret word
		Hangman hm = new Hangman(secret);
		//show instructions to user
		hm.playGame();	
		//randomly chooseWord 
		hm.chooseWord();
		//first time to give user the word display // all dashes
		System.out.print("Your word now looks like this: [ ");
		for(int i = 0 ;i < hm.correctList.size();i++) {
			System.out.print(hm.correctList.get(i));
		}
		System.out.print(" ]");
		System.out.println("\nYour have "+(MAX_WRONG_COUNTS-hm.wrongCount)+" times left.");
		System.out.println();
		//play the game use the method flow	
		while( hm.wrongCount != MAX_WRONG_COUNTS && hm.isFinished == false) {	
			hm.handleGuess();
		}
	}

}
