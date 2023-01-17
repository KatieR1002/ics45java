 package labs.lab2;

import java.util.Scanner;

public class Main {

	/**
	 * Reads a number between 1,000 and 999,999 from the user and prints it with a 
	 * comma separating the thousands.
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem2_printWithCommas(new Scanner(System.in));
	 */
	public static void problem2_printWithCommas(Scanner in) {
		System.out.print("Please enter an integer between 1000 and 999999: ");
		int num = in.nextInt();
		while(num < 1000 || num > 999999)
		{
			System.out.print("Enter an integer between 1000 and 999999: ");
			num = in.nextInt();
		}
		String r = String.valueOf(num);
		System.out.print(r.substring(0, r.length()-3) + ',' + r.substring(r.length()-3));
		in.close();
		
		// FILL IN
	}
	
	
	/**
	 * Computes the total of a sticker order based on the price per sticker and number
	 * of stickers, which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem3_calculateTotal(new Scanner(System.in));
	 */
	public static void problem3_calculateTotal(Scanner in) {
		// FILL IN
		System.out.print("Enter price per sticker: ");
		double price = in.nextDouble();
		System.out.print("Enter the number of stickers: ");
		int num = in.nextInt();
		double r = price * num *1.1 + 0.15*num;
		System.out.printf("Your total is: $%.2f", r );
		
	}
	
	
	/**
	 * Computes the total of a sticker order based on the price per sticker and number
	 * of stickers, which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problemr_compoundInterest(new Scanner(System.in));
	 */
	public static void problem4_compoundInterest(Scanner in) {
		// FILL IN
		System.out.print("Enter principal amount: ");
		double p = in.nextDouble();
		System.out.print("Enter the annual rate of interest: ");
		double r = in.nextDouble();
		System.out.print("Enter the number of years the amount is invested: ");
		int t = in.nextInt();
		System.out.print("Enter the number of times the interest is compounded per year: ");
		int n = in.nextInt();
		double A = p*Math.pow((1+r/100/n), n*t);
		System.out.print("$");
		System.out.printf("%.2f", p);
		System.out.print(" invested at "+r+"% for "+t+" years compounded "+n+" times annually is $");
		System.out.printf("%.2f", A);
		System.out.print(".");
	}
	
	
	/**
	 * Computes the number of months it will take to pay off a credit card balance, based
	 * on the balance, APR, and monthly payment which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem5_creditCardPayoff(new Scanner(System.in));
	 */
	public static void problem5_creditCardPayoff(Scanner in) {
		// FILL IN
		System.out.print("What is your balance? ");
		double b  = in.nextDouble();
		System.out.print("What is the APR on the card? ");
		double apr = in.nextDouble();
		System.out.print("What is the monthly payment you can make? ");
		double p = in.nextDouble();
		double i = apr/36500;
		int n = (int)(Math.ceil((-1)*(Math.log((1-Math.pow(1+i, 30))*b/p+1)/Math.log(1+i))/30));
		
		System.out.print("It will take you "+n+" months to pay off this card.");
		
	}
	
	
	/**
	 * Walk the user through troubleshooting issues with a car.
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem6_troubleshootCarIssues(new Scanner(System.in));
	 */
	public static void problem6_troubleshootCarIssues(Scanner in) {
		// FILL IN
		System.out.print("Is the car silent when you turn the key? ");
		String a1 = in.nextLine();
		boolean invalid = true;
		if (a1.toUpperCase().charAt(0) == 'Y') {
			System.out.print("Are the battery terminals corroded? ");
			String a2 = in.nextLine();
			if (a2.toUpperCase().charAt(0) == 'Y') {
				System.out.print("Clean terminals and try starting again.");
				invalid = false;
			}
			else if (a2.toUpperCase().charAt(0) == 'N') {
				System.out.print("Replace cables and try again.");
				invalid = false;
			}
		}
		else if (a1.toUpperCase().charAt(0) == 'N') {
			System.out.print("Does the car make a clicking noise? ");
			String a3 = in.nextLine();
			if (a3.toUpperCase().charAt(0) == 'Y') {
				System.out.print("Replace the battery.");
				invalid = false;
			}
			else if (a3.toUpperCase().charAt(0) == 'N') {
				System.out.print("Does the car crank up but fail to start? ");
				String a4 = in.nextLine();
				if (a4.toUpperCase().charAt(0) == 'Y') {
					System.out.print("Check spark plug connection");
					invalid = false;
				}
				else if (a4.toUpperCase().charAt(0) == 'N') {
					System.out.print("Does the engine start and then die? ");
					String a5 = in.nextLine();
					
					if (a5.toUpperCase().charAt(0) == 'Y') {
						System.out.print("Does your car have fuel injection? ");
						String a6 = in.nextLine();
						if (a6.toUpperCase().charAt(0) == 'N') {
							System.out.print("Check to ensure the choke is opening and closing.");
							invalid = false;
						}
						else if (a6.toUpperCase().charAt(0) == 'Y') {
							System.out.print("Get it in for service.");
							invalid = false;
						} 
					else if(a5.toUpperCase().charAt(0) == 'N') {
						System.out.print("Get it in for service.");
						invalid = false;}					
					}
					}
				}
			}
			if (invalid == true){
				System.out.print("Invalid input. Exiting.");
				}
			}
	
			
	
	
	/**
	 * Assesses the strength of a password based on these rules:
	 * 
	 * * A very weak password contains only digits and is fewer than eight characters
	 * * A weak password contains only letters and is fewer than eight characters
	 * * A strong password contains at least one letter and at least one digit and is at least
	 * eight characters
	 * * A very strong password contains at least one letter, at least one digit, and at least
	 * one special character (non letter or digit) and is at least eight characters
	 * * All other passwords are medium strength
	 * 
	 * @param password	the password to assess
	 * @return	a string describing its strength
	 */
	public static String problem7_assessPasswordStrength(String password) { // FIX ME
		boolean digits = false;
		boolean letters = false;
		boolean special = false;
		boolean l = false;

		for (char i : password.toCharArray()) {
			if ((int)i >= 47 && (int)i <= 57) {
				digits = true;
			}
			else if (((int)i >= 65 && (int)i <= 90) || ((int)i >= 97 && (int)i <= 122)) {
				letters = true;
			}
			else {special = true;
			}
			if (password.length()>=8) {
				l = true;
			}
		}
		if (digits== true && letters == false && special == false && l == false) {
			return "very weak";
		}
		else if (digits== false && letters == true && special == false && l == false) {
			return "weak";
		}
		else if (digits== true && letters == true && special == false && l == true) {
			return "strong";
		}
		else if (digits== true && letters == true && special == true && l == true) {
			return "very strong";
		}
		return "medium";		
		
	}
	
	
	/**
	 * Translates a letter grade into a numeric grade
	 * 
	 * @param letterGrade	the letter grade to translate
	 * @return	the numeric grade
	 */
	public static double problem8_getNumericGrade(String letterGrade) {
		String l = letterGrade.toUpperCase();
		System.out.println(l);
		if (l.equals("A+")) {
			return 4.0;
		}
		else if(l.equals("A")) {
			return 4;
		}
		else if(l.equals("A-")) {
			return 3.7;
		}
		else if(l.equals("B+")) {
			return 3.3;
		}
		else if(l.equals("B")) {
			return 3.0;
		}
		else if(l.equals("B-")) {
			return 2.7;
		}
		else if(l.equals("C+")) {
			return 2.3;
		}
		else if(l.equals("C")) {
			return 2.0;
		}
		else if(l.equals("C-")) {
			return 1.7;
		}
		else if(l.equals( "D+")) {
			return 1.3;
		}
		else if(l.equals("D")) {
			return 1.0;
		}
		else if(l.equals("D-")) {
			return 0.7;
		}
		else if(l.equals("F")) {
			return 0.0;
		}
		else {
		return -1.0;} // FIX ME
		
	}

	
	/**
	 * Translates a numeric grade into a letter grade
	 * 
	 * @param numericGrade	the numeric grade to translate
	 * 
	 * @return	the letter grade
	 */
	public static String problem8_getLetterGrade(double numericGrade) {
		if (numericGrade > 4.0)
			return "Error";
		else if (numericGrade==4.0) {
			return "A+";
		} else if (numericGrade >= 3.85) {
			return "A";
		} else if (numericGrade >= 3.5) {
			return "A-";
		} else if (numericGrade >= 3.15) {
			return "B+";
		} else if (numericGrade >= 2.85) {
			return "B";
		} else if (numericGrade >= 2.5) {
			return "B-";
		} else if (numericGrade >= 2.15) {
			return "C+";
		} else if (numericGrade >= 1.85) {
			return "C";
		} else if (numericGrade >= 1.5) {
			return "C-";
		} else if (numericGrade >= 1.15) {
			return "D+";
		} else if (numericGrade >= 0.85) {
			return "D";
		} else if (numericGrade >= 0.5) {
			return "D-";
		} else if (numericGrade >= 0) 
			return "F";
		return "Error"; // FIX ME
	}
	
	
	
	/**
	 * If one or both of the first 2 chars in the given string is the char 'x' 
	 * (lower case only), returns the string without those 'x' chars. Otherwise, 
	 * returns the string unchanged. 
	 * 
	 * @param str	the string to change
	 * 
	 * @return	the changed string
	 */
	public static String problem10_withoutX2(String str) {
		String r = str;
		if(str.length() == 0 || (str.length() == 1 && str.charAt(0) == 'x') ) {
			return "";
		}
		else if (str.charAt(1)=='x') {
			r = str.charAt(0)+str.substring(2);}
		if (r.charAt(0)=='x') {
			r = r.substring(1);}
		return r; }
}