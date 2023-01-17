package labs.lab4;

/**
 * An abstract item that can be checked out of a library
 */
public abstract class LibraryItem {
	// ADD YOUR INSTANCE VARIABLES HERE
	private String title;
	private boolean b;
	/**
	 * Constructor
	 * 
	 * @param title	title of the item
	 */
	public LibraryItem(String title) {
		// FILL IN
		this.title=title;
		b = false;
	}
	
	
	public String getTitle() {
		return title; // FIX ME
	}
	
	
	public boolean isCheckedOut() {
		return b; // FIX ME
	}
	
	
	public void setCheckedOut(boolean checkedOut) {
		// FILL IN
		b = checkedOut;
	}
	
	
	/**
	 * Causes this item to be checked out
	 * 
	 * @return	a message about the check out
	 */
	public abstract String checkOut();
	
	
	/**
	 * Causes this item to be checked in
	 */
	public void checkIn() {
		// FILL IN
		b = false;
	}
	
	
	public String toString() {
		return ""; // FIX ME
	}
	
	
	/**
	 * Returns true if the parameter object is a LibraryItem that has the same instance
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (this==otherObject)
			return true;
		if (otherObject == null || this.getClass() != otherObject.getClass())
			return false;
		return ((LibraryItem)(otherObject)).getTitle().equals(title);
	}
}