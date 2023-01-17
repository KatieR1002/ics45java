package labs.lab2;
/**
 * A class that performs simple calculations on two integers
 */
public class Calculator {
// ADD YOUR INSTANCE VARIABLES HERE
/**
 * 
 * Constructor
 * 
 * @param num1 first number
 * @param num2 second number
 */
	private int num1;
	private int num2;
	public Calculator(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	// FILL IN
	}
	/**
	 * Sums the two numbers
	 * 
	 * @return the sum of the two numbers
	 */
	public int getSum() {
	return num1 + num2; // FIX ME
	}
	/**
	 * Computes the difference between num1 - num2
	 * 
	 * @return the difference
	 */
	public int getDifference() {
		
	return num1 - num2; // FIX ME
	}
	/**
	 * Computes the product of the two numbers
	 * 
	 * @return the product
	 */
	public int getProduct() {
	return num1 * num2; // FIX ME
	}
	/**
	 * Computes the average of the two numbers
	 * 
	 * @return the average
	 */
	public double getAverage() {
		double n1 = num1;
		double n2 = num2;
	return (n1+n2)/2; // FIX ME
	}
	/**
	 * Computes the distance between the two numbers
	 * 
	 * @return the distance
	 */
	public int getDistance() {
	return Math.abs(num1-num2); // FIX ME
	}
	/**
	 * Returns the maximum of the two numbers
	 * 
	 * @return the maximum
	 */
	public int getMax() {
	return num1>num2?num1:num2; // FIX ME
	}
	/**
	 * Returns the minimum of the two numbers
	 * 
	 * @return the minimum
	 */
	public int getMin() {
	return num1<num2?num1:num2; // FIX ME
	}
	
	public static void main(String[] args) {
		Calculator c1 = new Calculator(5, 10);
		System.out.println(c1.getSum()); // returns 15
		System.out.println(c1.getDifference()); // returns -5
		System.out.println(c1.getProduct()); // returns 50
		System.out.println(c1.getAverage()); // returns 7.5
		System.out.println(c1.getDistance()); // returns 5
		System.out.println(c1.getMax()); // returns 10
		System.out.println(c1.getMin()); // returns 5
	}
}