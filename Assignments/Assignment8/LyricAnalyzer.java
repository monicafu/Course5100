package INFO5100.Assignment8;

import java.io.*;
import java.util.*;

public class LyricAnalyzer {
	
	
	private HashMap<String, ArrayList<Integer>> map;
	
	public LyricAnalyzer() {
		map = new HashMap<String, ArrayList<Integer>>();
	}
	
	/**
	 * read the lyrics from file and add to hashmap
	 * @param file object 
	 * @throws IOException */
	public void read(File file) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		int count = 1;
		while(true) {
			try {
				String str = br.readLine();
				if (str == null) break;
				String[] line = str.split(" ");
				for(String word: line ) {
					//check if the last words
					String last = line[line.length-1]; 
					if( word.equals(last)) {
						add(word, -count);
						count = Math.abs(count)+1;			
					}else{
						add(word,count++);	
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		br.close();
		fr.close();
	}
	/**
	 * add words and position to the map
	 * @param1 key: the lyric words 
	 * @param2 value:word Position*/
	private void add(String lyricWord,int wordPosition) {
		if (map.containsKey(lyricWord.toUpperCase())) {
			map.get(lyricWord.toUpperCase()).add(wordPosition);
		}else {
			ArrayList<Integer> pos = new ArrayList<Integer>();
			pos.add(wordPosition);
			map.put(lyricWord.toUpperCase(),pos);
		}
	}
	
	/**
	 * display words in alphabetical order*/
	public void displayWords() {
		List<String> key = new ArrayList<>(map.keySet());
		Collections.sort(key);
		System.out.println("Word      Word Position(s)");
		System.out.println("==========================");
		for (String str: key) {
			System.out.print(str);
			int space = 10 - str.length();
			for (int i = 0; i < space; i++) {
				System.out.print(" ");
			}
			System.out.print(map.get(str).toString());
			System.out.println();
		}
		
	}
	/**
	 * write the lyrics for the song in the map to file
	 * @param file object
	 * @throws IOException */
	
	public void writeLyrics(File file) throws IOException {
		int size = 0;
		Set<String> wordList =map.keySet(); 
		for (String word : wordList) {
			size += map.get(word).size();
		} 
		String[] str = new String[size + 1];
		
		for (String word: wordList) {
			ArrayList<Integer> list= map.get(word);
			for (Integer pos : list) {
				if (pos < 0) {
					pos = Math.abs(pos);
					str[pos] = word+"\n"; 
				}else {
					str[pos] = word+" ";
				}
			}
		}
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = null;
		for (int i = 1; i< str.length; i++) {
			pw = new PrintWriter(fw);
			pw.write(str[i]);
		}
		pw.close();
		fw.close();
	}
	
	/**
	 * count the number of unique words in lyric
	 * @return number of words*/
	public int count() {
		Set<String> wordList =map.keySet();  
		return wordList.size();
	}
	
	/**
	 *@return most frequently words 
	 * @throws IOException */
	public String mostFrequentWord() {
		StringBuilder freq = new StringBuilder();
		int max = 0;
		Set<String> wordList =map.keySet();  
		for (String word: wordList) {
			int len = map.get(word).size();
			if ( len > max) {
				max = len;
			}
		}
		for (String word: wordList) {
			if (map.get(word).size() == max)
				freq.append(word+",");
		}		
		return freq.toString();
	}
	
	

	public static void main(String[] args) throws IOException {
		LyricAnalyzer analyzer = new LyricAnalyzer();
		File file = new File("src/INFO5100/Assignment8/Question2_test4.txt");
		analyzer.read(file);
		analyzer.displayWords();
		File write = new File("src/INFO5100/Assignment8/Question2_write.txt");
		write.createNewFile();
		analyzer.writeLyrics(write);
		System.out.println("====================================");
		System.out.println("The count of the unique words is: "+analyzer.count());
		System.out.println("The most renquently words in this lyrics is: "+analyzer.mostFrequentWord());
		
	}

}
