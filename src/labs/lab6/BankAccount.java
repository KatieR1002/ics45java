package labs.lab6;

/**
 * A bank account has a balance that can be changed by deposits and withdrawals.
 */
public class BankAccount {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int accountNumber;
	private double initialBalance;
	private double currentBalance;
	/**
	 * Constructs a bank account with a given balance.
	 * 
	 * @param initialBalance the initial balance
	 */
	public BankAccount(int accountNumber, double initialBalance) {
		this.accountNumber = accountNumber;
		this.initialBalance = initialBalance;
		this.currentBalance = initialBalance;// FILL IN
	}

	/**
	 * Gets the current balance of the bank account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return this.currentBalance; // FIX ME
	}
	
	public void setBalance(double balance) {
		this.currentBalance = balance;
		// FILL IN
	}

	/**
	 * Gets the account number of the bank account.
	 * 
	 * @return the account number
	 */
	public int getAccountNumber() {
		return this.accountNumber; // FIX ME
	}
	
	
	/**
	 * Returns a string containing the account number and balance, separated by 
	 * a comma and space
	 */
	@Override
	public String toString() {
		return String.valueOf(this.accountNumber) + ", " +String.valueOf(this.currentBalance); // FIX ME
	}
	
	
	/**
	 * Returns true if the given object is a BankAccount with the same instance
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
		BankAccount p = (BankAccount) otherObj;

		if(this.accountNumber == p.accountNumber && this.currentBalance == p.currentBalance && this.initialBalance == p.initialBalance)
			
		{ 
			return true;}
        else {
        	
            return false;} // FIX ME
	}
}
