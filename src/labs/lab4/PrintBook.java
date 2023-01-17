package labs.lab4;

/**
 * Print book item in a library
 */
public class PrintBook extends Book {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int pages;
	private int checkouts;
	private final String LOAN_PERIOD = "21";
	/**
	 * Constructor
	 * 
	 * @param title		book title
	 * @param author	book author
	 * @param numPages	number of pages
	 */
	public PrintBook(String title, String author, int numPages) {
		// FILL IN
		super(title,author);
		pages = numPages;
		checkouts = 0;
	}

	
	public int getNumPages() {
		return pages; // FIX ME
	}

	
	public void setNumPages(int numPages) {
		pages = numPages;
	}

	
	/**
	 * If this item is not already checked out, this method checks this item out
	 * and returns the loan period; if it is already checked out, returns the
	 * String "NOT ALLOWED"; overrides LibraryItem.checkOut()
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
	 * Returns true if the parameter object is a PrintBook that has the same
	 * instance variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (this==otherObject)
			return true;
		if (otherObject == null || this.getClass() != otherObject.getClass())
			return false;
		PrintBook b = (PrintBook)otherObject;
		return this.getAuthor()==b.getAuthor() && this.getNumPages()==b.getNumPages();
	}
}
