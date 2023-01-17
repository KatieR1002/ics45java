package labs.lab1;

/**
 * This class models a simple letter.
 */
public class Letter {
	// ADD YOUR INSTANCE VARIABLES HERE
	private String from;
	private String to;
	private String text;

	/**
	 * Constructs a letter with a given sender and recipient.
	 * 
	 * @param from the sender
	 * @param to   the recipient
	 */
	public Letter(String from, String to) {
		this.from = from;
		this.to = to;
		this.text =  "Dear " + to + ":\n\n";
		
		// FILL IN
	}

	/**
	 * Adds a line to the end of the body of this letter
	 * 
	 * @param	line	line to add
	 */
	public void addLine(String line) {
		this.text +=  line+"\n";
		// FILL IN
	}

	/**
	 * Gets the entire text of this letter
	 * 
	 * @return	the entire text of this letter
	 */
	public String getText() {
		this.text += "\nSincerely,\n\n" + from;
		System.out.print(text);
		return this.text; // FIX ME
	}
}
