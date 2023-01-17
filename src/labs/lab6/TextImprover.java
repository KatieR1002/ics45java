package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class to improve a piece of text by replacing over-used words with better
 * word choices
 */
public class TextImprover { 
	String wordMapFileName;
	ArrayList<String[]> word = new ArrayList<String[]>();;
	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Constructor
	 * 
	 * @param wordMapFileName	name of the file containing the over-used words and their replacements
	 * @throws FileNotFoundException 
	 */
	public TextImprover(String wordMapFileName) throws FileNotFoundException {
		this.wordMapFileName = wordMapFileName;
		
		
		
		
		// FILL IN
	}


	/**
	 * Replaces all of the over-used words in the given file with better words, based on the word map
	 * used to create this TextImprover
	 * 
	 * @param fileName	name of the file containing the text to be improved
	 * @throws IOException 
	 */
	public void improveText(String fileName) throws IOException {
		
		try {
			File inputFile = new File(wordMapFileName);
			Scanner in = new Scanner(inputFile);
			
			while (in.hasNextLine()) {
				String nextLine = in.nextLine();
		        String w[] = nextLine.split("\\s+");
		        word.add(w);
		
			}
			ArrayList<String> overuse = new ArrayList<String>();
			ArrayList<String> replace = new ArrayList<String>();
			File changeFile = new File(fileName);
			Scanner sc;
			sc = new Scanner(changeFile);
			StringBuilder sb = new StringBuilder();
			while (sc.hasNextLine()) {
				sb.append(sc.nextLine() + "\n");	
			}
			sc.close();
			String s = sb.toString();

		    for (int i = 0; i < word.size(); i++) {
		    	String temp1 = word.get(i)[0];
		    	String temp2 = word.get(i)[1];
		    		overuse.add((" " + temp1.toUpperCase()+"!"));
		    		overuse.add(" " + temp1+" ");
			    	overuse.add(" " + temp1.substring(0, 1).toUpperCase()+ temp1.substring(1)+" ");
			    	overuse.add(" " + temp1+". ");
//			    	overuse.add(" " + temp1.substring(0, 1).toUpperCase()+ temp1.substring(1)+".");
			    	overuse.add(" " + temp1+",");
			    	overuse.add(" " + temp1.substring(0, 1).toUpperCase()+ temp1.substring(1)+",");
			    	overuse.add("\n" + temp1+",");
			    	overuse.add("\n" + temp1.substring(0, 1).toUpperCase()+ temp1.substring(1)+",");
			    	overuse.add("\"" + temp1+"\"");
			    	overuse.add("\"" + temp1.substring(0, 1).toUpperCase()+ temp1.substring(1)+"\"");
			    	replace.add(" " + temp2.toUpperCase()+"!");
			    	replace.add(" " + temp2+" ");
			    	replace.add(" " + temp2.substring(0, 1).toUpperCase()+ temp2.substring(1)+" ");
			    	replace.add(" " + temp2+". ");
//			    	replace.add(" " + temp2.substring(0, 1).toUpperCase()+ temp2.substring(1)+".");
			    	replace.add(" " + temp2+",");
			    	replace.add(" " + temp2.substring(0, 1).toUpperCase()+ temp2.substring(1)+",");
			    	replace.add("\n" + temp2+",");
			    	replace.add("\n" + temp2.substring(0, 1).toUpperCase()+ temp2.substring(1)+",");
			    	replace.add("\"" + temp2+"\"");
			    	replace.add("\"" + temp2.substring(0, 1).toUpperCase()+ temp2.substring(1)+"\"");
			    	if (s!= "") {
			    	if(String.valueOf(s.substring(0,temp1.length())) == (temp1+"[^a-zA-Z]")) {
			    		s = s.replaceAll(s.substring(0,temp1.length()-1), (temp2));
			    	}
			    	if (String.valueOf(s.substring(0,temp1.length())) == (temp1.substring(0, 1).toUpperCase()+ temp1.substring(1)+"[^a-zA-Z]")) {
			    		s = s.replaceAll(s.substring(0,temp1.length()-1), (temp2.substring(0, 1).toUpperCase()+ temp2.substring(1)));
			    	}
			    	if(s.substring(s.length()-temp1.length()-1, s.length()-1) == ("[^a-zA-Z]"+temp1)) {
			    		s = s.replaceAll(s.substring(s.length()-temp1.length()-2, s.length()-1), temp2);
			    	}
			    	if(s.substring(s.length()-temp1.length()-1, s.length()-1) == ("[^a-zA-Z]"+temp1.substring(0, 1).toUpperCase()+ temp1.substring(1))) {
			    		s = s.replaceAll(s.substring(s.length()-temp1.length()-2, s.length()-1), temp2.substring(0, 1).toUpperCase()+ temp2.substring(1));
			    	}
  		    	    if(s.substring(s.length()-2) == (" " + temp1.toUpperCase())) {
  		    	    	s = s.substring(0, s.length()-1) +  temp2.toUpperCase();
			    	}
			    	}
		    	
		    	
//			    	overuse.add(temp1);
//			    	overuse.add(temp1.substring(0, 1).toUpperCase()+ temp1.substring(1));
//			    	replace.add(temp2);
//			    	replace.add(temp2.substring(0, 1).toUpperCase()+ temp2.substring(1));
			    	

		    }
		    

			in.close();
			
			for (int j = 0; j < overuse.size(); j++) {
//				System.out.println(overuse.get(j));
//				System.out.println(replace.get(j));
		        s = s.replaceAll(overuse.get(j), replace.get(j));
			}
			try (FileWriter fileWriter = new FileWriter(fileName)) {
				fileWriter.write(s);
			}
			
	   
			//System.out.print(s);
		}
		catch (FileNotFoundException e1) {
			System.out.print("File: " + fileName + " not found");
		}



	}
		// FILL IN
	
//	public static void main(String[] args) throws FileNotFoundException {
//		TextImprover test = new TextImprover("./res/overused-words.txt");
//		test.improveText("res/overused2.txt");	}

}

