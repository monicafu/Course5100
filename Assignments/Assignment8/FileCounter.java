package INFO5100.Assignment8;

import java.io.*;
import java.util.*;

public class FileCounter {
	private int characterCount,wordCount,lineCount;
	
	public int getCharacterCount() {
		return characterCount;
	}
	public int getWordCount() {
		return wordCount;
	}
	public int getLineCount() {
		return lineCount;
	}
	public FileCounter() {
		super();
	}
	/**
    Processes an input source and adds its character, word, and line
    counts to the respective variables.
    @param in the scanner to process
	 */
	public void read(Scanner in) throws IOException {
		StringBuilder sb = new StringBuilder();
		while(in.hasNextLine()) {
			this.lineCount++;
			sb.append(in.nextLine());
		}
		//System.out.println(sb);
		String str = sb.toString();
		String[] word= str.split(" ");
		//System.out.println(Arrays.toString(word)+",");
		this.wordCount = word.length;
		for (String ele : word) {
			this.characterCount += ele.length();
		}
	}
}
