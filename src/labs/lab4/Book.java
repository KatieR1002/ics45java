
package labs.lab4;

/**
 * A book in a library
 */
public abstract class Book extends LibraryItem {
	private String author;
	
	
	/**
	 * Constructor
	 * 
	 * @param title		title of the book
	 * @param author	author of the book
	 */
	public Book(String title, String author) {
		// FILL IN
		super(title);
		this.author = author;
	}

	
	public String getAuthor() {
		return author; // FIX ME
	}

	
	public void setAuthor(String author) {
		// FILL IN
		this.author = author;
	}
	
	
	/**
	 * Returns true if the parameter object is a Book that has the same instance 
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (this==otherObject)
			return true;
		if (this.getClass() != otherObject.getClass()|| otherObject == null )
			return false;
		Book b = (Book)otherObject;
		return this.getAuthor()==b.getAuthor();
	}
}