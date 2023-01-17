package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A bank contains account numbers and balances of each customer.
 */
public class Bank {
	// ADD YOUR INSTANCE VARIABLES HERE
	String productsFileName;
	ArrayList<BankAccount> BA = new ArrayList<BankAccount>();

	/**
	 * Construct a Bank object with accounts read from the given file
	 * 
	 * @param filename the name of the file
	 */
	public Bank(String fileName) 
	{
		this.productsFileName = fileName ;// FILL IN
		try {
			
			File inputFile = new File(productsFileName);
			Scanner db = new Scanner(inputFile);
			while(db.hasNextLine()) {
				String nextLine = db.nextLine();
				String[] b = nextLine.split(" ");
				BankAccount sb = new BankAccount( Integer.parseInt(b[0]),  Double.parseDouble(b[1]));
;				BA.add(sb);
				}
				db.close();
			}
			catch (FileNotFoundException e1) {
				System.out.print("File: "+ productsFileName + " not found");
				
			}
	}


	/**
	 * Gets the account with the lowest balance.
	 * 
	 * @return the account with the lowest balance, or null if there are
	 * no accounts in this bank
	 */
	public BankAccount getLowestBalanceAccount() {

		double s = 1000000000;
		for (BankAccount bb: BA) {
			if (bb.getBalance() < s) {
				s = bb.getBalance();
			}
		}
		for (BankAccount bb: BA) {
			if (bb.getBalance() == s) {
				return bb;
			}
		}
		
		return null; // FIX ME
	}
}
