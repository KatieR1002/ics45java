package labs.lab5;

public class Player {
	
	// ADD YOUR INSTANCE VARIABLES EHRE
	String name;
	double health;
	
	/**
	 * 
	 * Creates a new Player with the given name and health=0.5
	 */
	public Player(String name) {
		this.name = name;
		this.health = 0.5;
		
		
		// FILL IN
	}
	
	
	public String getName() {
		return this.name; // FIX ME
	}
	
	
	public void setName(String s) {
		this.name = s;
		// FILL IN
	}
	
	
	/**
	 * 
	 * @return	the health, which is always a number from 0 (least healthy) to 1 (most healthy)
	 */
	public double getHealth() {
		
		return this.health; // FIX ME
	}
	
	
	/**
	 * 
	 * Sets the health to the new value, as long as it's within the bounds
	 * (If below 0, sets it to 0; if above 1, sets it to 1)
	 * 
	 * If health == 0, print out a message "[this.name] died!"
	 */
	public void setHealth(double d) {
		d = d<0?0:d;
		d = d>1?1:d;
		this.health = d;
        if (health == 0) {
        	System.out.print(this.name + " died!");
        }
		// FILL IN
	}
}