package labs.lab7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class for simulating trading a single stock at varying prices.
 */
public class StockSimulator {

	private Queue<Block> blocks;
	private ArrayList<Block> cb;
	private int q;
	

	/**
	 * Constructor
	 */
	public StockSimulator() {
		blocks = new LinkedList<Block>();
		cb = new ArrayList<Block>();
		q = 0;	
		
		// FILL IN
	}


	/**
	 * Handle a user buying a given quantity of stock at a given price.
	 * 
	 * @param quantity how many to buy.
	 * @param price    the price to buy at.
	 * 
	 * @throws IllegalArgumentException if the requested quantity/price cannot be
	 *                                  sold i.e., quantity <= 0 or price < 0
	 */
	public void buy(int quantity, int price) throws IllegalArgumentException {
		if  (quantity <= 0 || price < 0) {
			throw new IllegalArgumentException("Unable to complete purchase");
		}
		q += quantity;
		Block b = new Block(quantity, price);
		cb.add(b);
		blocks.add(b);
		
		// FILL IN
	}


	/**
	 * Handle a user selling a given quantity of stock at a given price.
	 * 
	 * @param quantity how many to sell.
	 * @param price    the price to sell.
	 * 
	 * @return the gain (can be positive or negative)
	 * 
	 * @throws IllegalArgumentException if the requested quantity cannot be sold
	 *                                  e.g., quantity exceeds quantity owned,
	 *                                  quantity < 1, price < 0
	 */
	public int sell(int quantity, int price) throws IllegalArgumentException {
		int profit =0;
		
		if  (quantity <1 || price < 0 || quantity > q) {
			throw new IllegalArgumentException("Unable to complete sale");
		}
		    //System.out.println(cb.size());
		
			for(int i = 0; i < cb.size(); i++) {
				if (quantity !=0) {
				Block b = cb.get(i);
				if (b.getQuantity() < quantity) {
					profit += (price-b.getPrice())*b.getQuantity();
					
					quantity -= b.getQuantity();
					q -= b.getQuantity();
					cb.set(i, new Block(0, b.getPrice()));
				}
				else {
					profit += (price-b.getPrice())*quantity;
					q -= quantity;
					cb.set(i, new Block(b.getQuantity()-quantity, b.getPrice()));
					quantity = 0;
				}}
		
		
		}
		System.out.println(cb.size());

		for(Block b: cb) {	
		System.out.print(b.getPrice());
		System.out.print(" ");
		System.out.println(b.getQuantity());
		}

		return profit; // FIX ME
	}


	/**
	 * This is a method for us to test your class
	 * 
	 * @return a List of Blocks owned
	 */
	public List<Block> getBlocks() {
		return (List<Block>) blocks; // FIX ME
	}

}
