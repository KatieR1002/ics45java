package labs.lab1;

/**
 * A simple voting machine that records votes for two parties.
 */
public class VotingMachine {
	private int dc;
	private int rp;

	// ADD YOUR INSTANCE VARIABLES HERE

	
	/**
	 * Constructs a voting machine, with vote counts set to zero.
	 */
	public VotingMachine() {
		this.dc =0;
		this.rp = 0;
		// FILL IN
	}


	/**
	 * Clears the vote counts.
	 */
	public void clear() {
		this.dc =0;
		this.rp = 0;
		// FILL IN
	}


	/**
	 * Records a vote for a democrat.
	 */
	public void voteForDemocrat() {
		this.dc +=1;
		
		// FILL IN
	}


	/**
	 * Records a vote for a republican.
	 */
	public void voteForRepublican() {
		this.rp += 1;
		// FILL IN
	}


	/**
	 * Gets the votes cast for a democrat.
	 * 
	 * @return the vote count
	 */
	public int getDemocratVotes() {
		return this.dc; // FIX ME
	}


	/**
	 * Gets the votes cast for a republican.
	 * 
	 * @return the vote count
	 */
	public int getRepublicanVotes() {
		return rp; // FIX ME
	}
}
