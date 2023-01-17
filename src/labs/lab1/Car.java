package labs.lab1;

/**
 * A car that can drive and consume fuel.
 */
public class Car {
	private double gas;
	private double efficiency;
	private double uG;

	/**
	 * Constructs a car with a given fuel efficiency and no gas
	 * 
	 * @param anEfficiency the fuel efficiency of the car (in miles per gallon)
	 */
	public Car(double anEfficiency) {
		this.gas  = 0.0;
		this.efficiency = anEfficiency;
		this.uG = 0;
		// FILL IN
	}

	/**
	 * Adds gas to the tank.
	 * 
	 * @param amount the amount of fuel to add (in gallons)
	 */
	public void addGas(double amount) {
		this.gas += amount;
		// FILL IN
	}

	/**
	 * Drives a certain amount, consuming gas
	 * 
	 * @param distance the distance driven
	 */
	public void drive(double distance) {
		this.uG = distance/efficiency;
		this.gas -= this.uG;
		//System.out.println(uG);
		// FILL IN
	}

	/**
	 * Gets the amount of gas left in the tank (in gallons)
	 * 
	 * @return the amount of gas
	 */

	public double getGasInTank() {
		
		return this.gas; // FIX ME
		
	}
}
