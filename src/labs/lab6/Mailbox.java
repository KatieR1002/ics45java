package labs.lab6;

import java.util.ArrayList;

/**
 * An email mailbox.
 */
public class Mailbox {
	// ADD YOUR INSTANCE VARIABLES HERE
	String user;
	ArrayList<Message> message = new ArrayList<Message>() ;
	/**
	 * Constructs a Mailbox object.
	 * 
	 * @param user the user
	 */
	public Mailbox(String user) {
		this.user = user;

		// FILL IN
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user of this mailbox
	 */
	public String getUser() {
		
		return this.user; // FIX ME
	}

	/**
	 * Adds a message to the mailbox.
	 * 
	 * @param m the message to add
	 */
	public void addMessage(Message m) {
		this.message.add(m);
		// FILL IN
	}

	/**
	 * Retrieves text of all messages, in the following format:
	 * -----
	 * [MESSAGE1]
	 * -----
	 * [MESSAGE2]
	 * 
	 * etc.
	 */
	public String getAllMessages() {
		String s = "";
		for (Message m: message) {
			s += " -----\n";
			s += m.toString();
		}
		return s; // FIX ME
	}
}
