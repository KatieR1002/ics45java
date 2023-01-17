package labs.lab6;

/**
 * An email message.
 */
public class Message {
	// ADD YOUR INSTANCE VARIABLES HERE
	String from;
	String to;
	String text;
	/**
	 * Constructs a Message object.
	 * 
	 * @param from 	the sender of the message
	 * @param to	the recipient of the message
	 * @param text	the text of the message
	 */
	public Message(String from, String to, String text) {
		this.from = from;
		this.to = to;
		this.text = text;// FILL IN
	}

	/**
	 * Gets the recipient.
	 * 
	 * @return the recipient
	 */
	public String getRecipient() {
		return this.to; // FIX ME
	}

	/**
	 * Formats the email message in the following format:
	 * From: [SENDER]
	 * To: [RECIPIENT]
	 * [TEXT]
	 */
	public String toString() {
		return "From: " + from + "\n" + "To: " + to + "\n" + text; // FIX ME
	}
}
