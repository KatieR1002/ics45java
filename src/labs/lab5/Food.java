package labs.lab5;

public class Food extends GameElement implements Ingestible {

		
	/**
	 * 
	 * @param name
	 * @param healthScore
	 */
	public Food(String name, double healthScore) {
		super(name, healthScore);
	}
	
	
	/**
	 * For every this.healthScore point above 5, adds 0.1 to the player's health.
	 * For every this.healthScore point below 5, subtracts 0.1 from the player's health.
	 * If this.healthScore == 5, makes no change to the player's health
	 */
	@Override
	public String ingest(Player player) {
		if (this.healthScore > 5) {
			player.setHealth(player.getHealth()+ 0.1*(this.healthScore -5));
			}
		else if (this.healthScore < 5) {
			player.setHealth(player.getHealth()- 0.1*(5-this.healthScore));
		}
		
		
		return player.getName() + " is eating " + this.name; // FIX ME
	}
}