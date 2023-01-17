package labs.lab4;

/**
 * Digital book item in a library
 */
public class DigitalBook extends Book {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int pages;
	private int checkouts;
	private final String LOAN_PERIOD = "14";
	/**
	 * Constructor
	 * 
	 * @param title		book title
	 * @param author	book author
	 * @param numPages	number of pages
	 */
	public DigitalBook(String title, String author, int numPages) {
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
	 * If the max number of checkouts for this item has not already been reached,
	 * this method checks this item out and returns the loan period; if no more
	 * check outs are available for this item, returns the String "NOT ALLOWED";
	 * overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (checkouts < 3) {
			this.setCheckedOut(true);		
			checkouts +=1;
			return LOAN_PERIOD+" days";
		}
		this.setCheckedOut(false);
		return "NOT ALLOWED";
	}
	
	
	/**
	 * Checks in this item  (frees up one checkout for this item); overrides 
	 * LibraryItem.checkIn()
	 */
	@Override
	public void checkIn() {
		// FILL IN
		checkouts=(checkouts>0)?checkouts-1:checkouts;
	}
	
	
	/**
	 * Returns true if the parameter object is a DigitalBook that has the same
	 * instance variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (this==otherObject)
			return true;
		if (otherObject == null || this.getClass() != otherObject.getClass())
			return false;
		DigitalBook b = (DigitalBook)otherObject;
		return this.getAuthor()==b.getAuthor() && this.getNumPages()==b.getNumPages();
	}
}