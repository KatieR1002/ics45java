package labs.lab1;

/**
 * A class to represent an inflatable spherical balloon.
 */
public class Balloon {
	private double radius;

	/**
	 * Construct an unfilled balloon.
	 */
	public Balloon() {
		// FILL IN
		this.radius = 0.0;
	}

	/**
	 * Inflates the balloon.
	 * 
	 * @param amount the amount of increase to the radius of the balloon
	 */
	public void inflate(double amount) {
		this.radius += amount;
		// FILL IN
	}

	/**
	 * Computes the current volume of the balloon.
	 * 
	 * @return the volume of balloon (in cubic units)
	 */
	public double getVolume() {
		System.out.println(radius);
		double v = Math.PI * radius * radius * radius * 4 / 3;
		return v;
	}

	public static void main(String[] args) {
		Balloon balloon = new Balloon();
		System.out.println(balloon.getVolume()); // should print 0.0
		balloon.inflate(2.0);
		System.out.println(balloon.getVolume()); // should print 33.510321638291124
		balloon.inflate(4.0);
		System.out.println(balloon.getVolume()); // should print 904.7786842338604
	}
}