package labs.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Sorts a file of names alphabetically, ignoring case
 */
public class NameSorter {

	// ADD YOUR INSTANCE VARIABLES EHRE
	private String inputFile;
    private ArrayList<String> names;


	
	/**
	 * Constructs a name sorter with the names from the input file
	 * 
	 * @param inputFile	name of the input file
	 */
	public NameSorter(String inputFile) {
		names = new ArrayList<String>();
		this.inputFile = inputFile;
		try {
            Scanner in = new Scanner(new File(inputFile));
            while (in.hasNextLine()) { 
                String name = in.nextLine();
                names.add(name);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile);
        }
		
        }
    
		// FILL IN
	
	
	
	/**
	 * Sorts the names from the input file alphabetically, ignoring case, 
	 * then writes the sorted names back to the file, overwriting the 
	 * previous content
	 */
	public void sortNames() {
		Collections.sort(names, String.CASE_INSENSITIVE_ORDER);
	
		String s = String.join("\n", names);
		
		
		//System.out.println(s);
		try (FileWriter fileWriter = new FileWriter(inputFile)) {
			//System.out.println(s);
			fileWriter.write(s);
		} 
		catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// FILL IN
	}
	public static void main(String[] args) throws FileNotFoundException {
	NameSorter ns = new NameSorter("res/names1.txt");
	ns.sortNames();}
}