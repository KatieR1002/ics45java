package labs.lab4;

/**
 * A magazine item in a library
 */
public class Magazine extends LibraryItem {
	// ADD YOUR INSTANCE VARIABLES HERE
	int num;
	String date;
	private int co;
	private final String lp = "7";
	/**
	 * Constructor
	 * 
	 * @param title				magazine title
	 * @param issueNumber		magazine issue number
	 * @param publicationDate	magazine publication date
	 */
	public Magazine(String title, int issueNumber, String publicationDate) {
		// FILL IN
		super(title);
		num = issueNumber;
		date = publicationDate;
		co = 0;
	}
	
	
	public int getIssueNumber() {
		return num; // FIX ME
	}
	
	
	public void setIssueNumber(int issueNumber) {
		// FILL IN
		num = issueNumber;
	}

	
	public String getPublicationDate() {
		return date; // FIX ME
	}

	
	public void setPublicationDate(String publicationDate) {
		// FILL IN
		date = publicationDate;
	}
	
	
	/**
	 * If this item is not already checked out, this method checks this item out and 
	 * returns the loan period; if it is already checked out, returns the String 
	 * "NOT ALLOWED"; overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (co < 1) {
			this.setCheckedOut(true);		
			co +=1;
			return lp+" days";
		}
		this.setCheckedOut(false);
		return "NOT ALLOWED";// FIX ME
	}
	
	
	/**
	 * Returns true if the parameter object is a Magazine that has the same instance 
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (this==otherObject)
			return true;
		if (otherObject == null || this.getClass() != otherObject.getClass())
			return false;
		Magazine m = (Magazine)otherObject;
		return (this.getIssueNumber()==m.getIssueNumber() && this.getTitle().equals(m.getTitle()) && 
				this.getPublicationDate()==m.getPublicationDate()); // FIX ME
	}
}