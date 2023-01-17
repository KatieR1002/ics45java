package labs.lab6;

import java.io.FileWriter;

/**
 * Represents a single product.
 */
public class Product {
	// ADD YOUR INSTANCE VARIABLES EHRE
	String name;
	double price;
	int quantity;
	/**
	 * Constructs a Product.
	 * 
	 * @param name    	product name
	 * @param price	  	price of product
	 * @param quantity	quantity of product
	 */
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		// FILL IN
	}

	/**
	 * Retrieve product name.
	 * 
	 * @return name
	 */
	public String getName() {
		return name; // FIX ME
	}

	/**
	 * Retrieve product price.
	 * 
	 * @return product price
	 */
	public double getPrice() {
		return price; // FIX ME
	}

	/**
	 * Retrieve quantity.
	 * 
	 * @return quantity of product
	 */
	public double getQuantity() {
		return quantity; // FIX ME
	}
	
	
	/**
	 * Returns the name, price, and quantity, each separated by a comma and
	 * space
	 */
	@Override
	public String toString() {
		return name +", " + String.valueOf(price) + ", "+ String.valueOf(quantity) ;  // FIX ME
	}
	
	
	/**
	 * Returns true if the given object is a Product with the same instance
	 * variable values as this one
	 */
	@Override
	public boolean equals(Object otherObj) {

		
		if(otherObj == null ) {
			System.out.print(1);
            return false;
            }
		if (this.getClass() != otherObj.getClass()) {
			System.out.print(2);
			return false;
		}
		Product p = (Product) otherObj;

		if(this.name.equals(p.name) && this.price == p.price && this.quantity == p.quantity)
			
		{ System.out.print(3);
			return true;}
        else {
        	System.out.print(4);
            return false;} // FIX ME
	}
}
