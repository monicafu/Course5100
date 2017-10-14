package INFO5100.Project1;

import java.io.*;

public class GameHelper {
	
	public String userInput(){
		
		System.out.println("=================================================");
		System.out.print(" Enter your guess character:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			str = br.readLine().toLowerCase();
			if( str.equals("")||str.equals(null)) {
				System.out.println("|--------------------------------------|");
				System.out.println("| Dear user: You must input a character|");
				System.out.println("|--------------------------------------|");
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;		
	}
	
}
