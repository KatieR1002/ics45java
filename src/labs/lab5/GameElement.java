package labs.lab5;

public abstract class GameElement {
	String name;
	double healthScore;
	
	// ADD YOUR INSTANCE VARIABLES HERE
	
	/**
	 * 
	 * @param name
	 * @param healthScore	from 0 (least healthy) to 10 (most healthy)
	 * 						(If below 0, sets it to 0; if above 10, sets it to 10)
	 */						
	public GameElement(String name, double healthScore) {
		this.name = name;
		healthScore = healthScore<0?0:healthScore;
		healthScore = healthScore>10?10:healthScore;
		this.healthScore = healthScore;
		// FILL IN
	}
	
	
	public String getName() {
		return this.name; // FIX ME
	}
	
	
	public double getHealthScore() {
		return this.healthScore; // FIX ME
	}
}