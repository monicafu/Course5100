/* Good Work
 * Score 19
 * you are setting spades as shortest if it contains Ace or King or Queen. While the requirement is other way round
 */
package INFO5100.Project2;

import java.util.Scanner;

/* 
 * Entrance of the Game Class
 * call the playAGame to start one game
 * and ask user to play again
 * @author: Jing Fu
 * @date:  11/01/2017
 * */

public class GameDriver {
	public static void main(String[] args) {
		
		while(true) {
			Game game = new Game(4);
			game.playAGame();
			System.out.println("Play another game (y/n)?");
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			if (input.equalsIgnoreCase("n")) {
				System.out.println("Thanks, Bye!");
				break;
			}
			else if (input.equalsIgnoreCase("y")) continue;
		}

	}

}
