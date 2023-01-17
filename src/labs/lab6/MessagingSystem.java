package labs.lab6;

import java.util.ArrayList;

/**
 * An email messaging system.
 */
public class MessagingSystem {
	ArrayList<Mailbox> um = new ArrayList<Mailbox>();
	
	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Constructs a MessagingSystem object
	 */
	public MessagingSystem() {
		
		// FILL IN
	}


	/**
	 * Delivers a message to the recipient
	 * 
	 * @param sender		message sender
	 * @param recipient		message recipient
	 * @param text			text of the message
	 */
	public void deliver(String sender, String recipient, String text) {
		Message m = new Message(sender, recipient, text);
		boolean exist = false;
		int it = 0;
		for (int i = 0; i < um.size(); i++) {
			if (um.get(i).getUser().equals(recipient)) {
				exist = true;
				it = i;
			}
		}

			
		if (exist) {
			Mailbox temp = um.get(it);
			temp.addMessage(m);
			um.set(it, temp);
			}
		
		else {
			Mailbox r = new Mailbox(recipient);
			r.addMessage(m);
			um.add(r);}

		
		
		
		// FILL IN
	}

	
	/**
	 * Retrieves the messages for a user
	 * 
	 * @param user the user
	 */
	public String getMessages(String user) {
		for (Mailbox mbox: um) {
			if (mbox.getUser().equals(user)) {
				return mbox.getAllMessages();
			}
		}
		return ""; // FIX ME
	}
}
