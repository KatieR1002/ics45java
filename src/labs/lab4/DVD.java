package labs.lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * A DVD item in a library
 */
public class DVD extends LibraryItem {
	private List<String>actors;
	private int checkouts;
	private final String LOAN_PERIOD = "7";
	/**
	 * Constructor
	 * 
	 * @param title		title of the DVD
	 * @param actors	actors in the DVD
	 */
	public DVD(String title, List<String> actors) {
		super(title);
		this.actors = new ArrayList<String>(actors);
		checkouts=0;
	}

	
	public List<String> getActors() {
		return this.actors; // FIX ME
	}
	
	
	public void setActors(List<String> actors) {
		this.actors = new ArrayList<String>(actors);
	}
	
	
	/**
	 * If this item is not already checked out, this method checks this item out and 
	 * returns the loan period; if it is already checked out, returns the String 
	 * "NOT ALLOWED"; overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (checkouts < 1) {
			this.setCheckedOut(true);		
			checkouts +=1;
			return LOAN_PERIOD+" days";
		}
		this.setCheckedOut(false);
		return "NOT ALLOWED";
	}
	
	
	/**
	 * Returns true if the parameter object is a DVD that has the same instance 
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (this==otherObject)
			return true;
		if (otherObject == null || this.getClass() != otherObject.getClass())
			return false;
		DVD d1 = (DVD)otherObject;
		List<String> l = d1.getActors();
		for (int i = 0; i < l.size(); i++)
			if (!l.get(i).equals(actors.get(i)))
				return false;
		return this.getTitle().equals(d1.getTitle()); // FIX ME
	}
}