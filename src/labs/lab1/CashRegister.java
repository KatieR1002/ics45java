package labs.lab1;
/**
 * A cash register totals up sales and computes change due.
 */
public class CashRegister {
	private double purchase;
	private double payment;
	private int itemcount;
	private String receipt;
	private int salescount;
	private double totalPurchase;

	/**
	 * Constructs a cash register with no money in it.
	 */
	public CashRegister() {
		this.purchase = 0;
		this.payment = 0;
		this.itemcount = 0;
		this.receipt = "";
		this.itemcount = 0;
		this.salescount = 0;
		this.totalPurchase = 0;
	}

	/**
	 * Records the sale of an item.
	 * 
	 * @param amount the price of the item
	 */
	public void recordPurchase(double amount) {
		purchase = purchase + amount;
		totalPurchase += amount;
		itemcount += 1;
		receipt += String.valueOf(amount);
		receipt += "\n";

	}

	/**
	 * Processes a payment received from the customer.
	 * 
	 * @param amount the amount of the payment
	 */
	public void receivePayment(double amount) {
		payment = payment + amount;
		salescount += 1;
	}

	/**
	 * Computes the change due and resets the machine for the next customer.
	 * 
	 * @return the change due to the customer
	 */
	public double giveChange() {
		double change = payment - purchase;
		purchase = 0;
		payment = 0;
		return change;
	}

	/**
	 * Returns count of items purchased.
	 * 
	 * @return count of items purchased
	 */
	public int getItemCountInPurchase() {
		// WRITE YOUR CODE HERE 
		return itemcount; // FIX ME
	}

	/**
	 * Get the total amount of all sales for the day.
	 * 
	 * @return the total amount of all sales for the day
	 */
	public double getSalesTotal() {
		// WRITE YOUR CODE HERE 
		return totalPurchase; // FIX ME
	}

	/**
	 * Get the total number of sales for the day.
	 * 
	 * @return the number of sales for the day
	 */
	public int getSalesCount() {
		// WRITE YOUR CODE HERE 
		return salescount; // FIX ME
	}

	/**
	 * Reset counters and totals for the next day's sales.
	 */
	public void reset() {
		// WRITE YOUR CODE HERE 
		this.purchase = 0;
		this.payment = 0;
		this.itemcount = 0;
		this.receipt = "";
		this.itemcount = 0;
		this.salescount = 0;
		this.totalPurchase = 0;
	}

	public String getReceipt() {
		// WRITE YOUR CODE HERE 
		receipt += String.valueOf(purchase);

		return receipt;
	}

	public static void main(String[] args) {
		// transaction #1:
		CashRegister register = new CashRegister();
		register.recordPurchase(29.50);
		register.recordPurchase(9.25);
		System.out.println(register.getItemCountInPurchase()); // returns 2
		register.receivePayment(50.00);
		System.out.println(register.getReceipt()); // returns:
		// 29.5
		// 9.25
		// 38.75
		register.giveChange();

		// transaction #2:
		register.recordPurchase(30);
		register.recordPurchase(10);
		register.receivePayment(50);
		register.giveChange();

		// transaction #3:
		register.recordPurchase(20);
		register.receivePayment(20);
		register.giveChange();
		System.out.println(register.getSalesTotal()); // returns 98.75
		System.out.println(register.getSalesCount()); // returns 3

	}
}
