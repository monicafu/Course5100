package INFO5100.Assignment3;
import java.util.*;
public class Assignment3 {
	
	
	/*3. Write a Java function to remove vowels in a string. (Score 2)
		i. The function should take a string as input.
		ii. Should return the input string after omitting the vowels.
	 * 
	 */
	public String removeVowelsFromString(String input){
		int len =input.length();
		StringBuilder str = new StringBuilder();
		for ( int i = 0 ; i < len; i++) {
			if ( !isVowels(input.charAt(i)))
			str.append(input.charAt(i));
		}
		return str.toString();
	}
	
	public boolean isVowels(char c) {
		String vowels = "aeiouAEIOU";
		for ( int i = 0; i < vowels.length(); i++) {
			if ( c == vowels.charAt(i) )
				return true;
		}
		return false;
	}
	
	/* 4. Write a java function to check if two strings are Anagrams or not. (Score 2)
	 *  i. The function should take two input strings.
	 *  ii. Should return a boolean ¡®true¡¯ if the inputs are Anagrams else return ¡®false¡¯.
	 */
	public boolean checkIfTwoStringsAreAnagrams(String s1, String s2){
			if( s1.length()!=s2.length() || s1 == null || s2 == null) return false;
			int result = 1;
			char[] c1= s1.toCharArray();
			char[] c2= s2.toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			
			String ss1= new String(c1);
			String ss2= new String(c2);
			if( ss1.length() == ss2.length()) {
				result = ss1.compareTo(ss2);
			}
			if (result == 0)
				return true;
			else return false;
		}


	
	public static void main(String[] args) {
		Assignment3 assignment = new Assignment3();
		String result1 = assignment.removeVowelsFromString("abcdefgiou");
		System.out.println("3. Test the remove vowels from String, The result should be bcdfg: " +result1);
		System.out.println("----------------------------------------------------------------");
		boolean result2 = assignment.checkIfTwoStringsAreAnagrams("CBADd", "ABCdD");
		System.out.println("4. Check if two Strings are anagrams, The result should be true: " +result2);
		
		
	}

}
