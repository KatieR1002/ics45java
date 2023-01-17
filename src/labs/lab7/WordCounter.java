package labs.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * A program that reads text from a file and breaks it up into individual words,
 * inserts the words into a tree set, and allows you to get stats about the
 * words.
 */
public class WordCounter {
	private TreeSet<String> uniqueWords;
	private ArrayList<String> words;
	
	// FILL IN ANY OTHER PRIVATE INSTANCE VARIABLES YOU NEED HERE

	/**
	 * Constructor
	 * 
	 * @param filename file from which to read words
	 */
	public WordCounter(String filename) {
		words = new ArrayList<String>();
		uniqueWords = new TreeSet<String>();	
		File inputFile = new File(filename);
		Scanner in;
		try {
			in = new Scanner(inputFile);
			while (in.hasNextLine()) {
				String nextLine = in.nextLine();
			    String[] ws = nextLine.split(" ");
			    for (String w: ws) {
			    	System.out.println(w);
			    	w = w.replaceAll("[^a-zA-Z\\d-]", "").toLowerCase();
			    	if(w != "") {
			    		w = w.replaceAll("[^a-zA-Z\\d]", "");
				    	words.add(w);
				    	uniqueWords.add(w);
			    }}
			   
			      }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
		
		// FILL IN
	}


	/**
	 * Returns the number of unique words in the file
	 * 
	 * @return number of unique words
	 */
	public int getNumUniqueWords() {
		
		return uniqueWords.size(); // FIX ME
	}


	/**
	 * Returns the number of words in the file
	 * 
	 * @return number of words
	 */
	public int getNumWords() {
		return words.size(); // FIX ME
	}


	/**
	 * returns a list of the unique words with all non-letter and non-digit
	 * characters removed, all in lower case, as a List in alphabetical order
	 * 
	 * @return list of unique words
	 */
	public List<String> getUniqueWords() {
		List<String> r = new ArrayList<>(uniqueWords);

        return r;
	}
}
