package labs.lab4;

/**
 * An audio book item in a library
 */
public class AudioBook extends Book {
	// ADD YOUR INSTANCE VARIABLES HERE
	private double time;
	private int checkouts;
	private final String LOAN_PERIOD = "28";
	/**
	 * Constructor
	 * 
	 * @param title			audio book title
	 * @param author		audio book author
	 * @param playingTime	audio book playing time
	 */
	public AudioBook(String title, String author, double playingTime) {
		// FILL IN
		super(title,author);
		time = playingTime;
		checkouts = 0;
	}

	
	public double getPlayingTime() {
		return time; // FIX ME
	}
	
	
	public void setPlayingTime(double playingTime) {
		time = playingTime;
	}
	
	
	/**
	 * If the max number of checkouts for this item has not already been reached,
	 * this method checks this item out and returns the loan period; if no more
	 * check outs are available for this item, returns the String "NOT ALLOWED";
	 * overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (checkouts < 2) {
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
		System.out.println();
		System.out.println(checkouts);
		checkouts=(checkouts>0)?checkouts-1:checkouts;
		System.out.println(checkouts);
	}
	
	
	/**
	 * Returns true if the parameter object is an AudioBook that has the same
	 * instance variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (this==otherObject)
			return true;
		if (otherObject == null || this.getClass() != otherObject.getClass())
			return false;
		AudioBook b = (AudioBook)otherObject;
		return this.getAuthor()==b.getAuthor() && this.getPlayingTime()==b.getPlayingTime();
	}
}