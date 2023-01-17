package labs.lab4;

/**
 * A BasicAccount whose withdraw method will not withdraw more money than is
 * currently in the account
 */
public class BasicAccount extends BankAccount {
	/**
	 * Constructs a bank account with a given balance.
	 * 
	 * @param initialBalance the initial balance
	 */
	public BasicAccount(double initialBalance) {
		// FILL IN
		super(initialBalance);
	}

	/**
	 * Withdraws the specified amount.
	 * 
	 * @param amount the amount to be withdrawn
	 */
	@Override
	public void withdraw(double amount) {
		if (super.getBalance() > amount)
			super.withdraw(amount);
	}
}