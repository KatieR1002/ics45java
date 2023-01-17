package labs.lab1;

import java.awt.Point;


public class Main {

	/**
	 * Given a string, return a version without the first 2 chars. Except keep the
	 * first char if it is 'a' and keep the second char if it is 'b'. The string
	 * will always have at least 2 chars.
	 * 
	 * @param str the input string
	 * 
	 * @return the string with the front removed, according to the rules
	 */
	public static String problem1_removeFront(String str) {
		String first_letter = str.substring(0,1);
		String second_letter = str.substring(1,2);
		String r = str.substring(2);
		if (first_letter.equals("a") && second_letter.equals("b")) {
			return str;
		}else if (first_letter.equals("a")){
			return first_letter + r;
		}else if (second_letter.equals("b")){
			return second_letter + r;
		}
		return str.substring(2);
				
		
	}


	/**
	 * Given a string, if one or both of the first 2 chars is 'r', return the string
	 * without those 'r' chars; otherwise return the string unchanged. The string
	 * may be any length, including 0.
	 * 
	 * @param str	the input string
	 * 
	 * @return	the string with the r's removed, according to the rules
	 */
	public static String problem2_withoutR2(String str) {
		if (str.length() >= 2) {
			String first_letter = str.substring(0,1);
			String second_letter = str.substring(1,2);
			if (first_letter.equals("r") && second_letter.equals("r")) {
				str = str.substring(2);
				return str;
			}else if (first_letter.equals("r")) {
				str = str.substring(1);
			}else if (second_letter.equals("r")) {
				str = first_letter + str.substring(2);
		}}
		else if (str.length() == 1) {
			String first_letter1 = str.substring(0,1);
			if (first_letter1.equals("r")) {
				str = "";
			}
		}else if (str.length() == 0) {
			str = "";
		}

		return str; // FIX ME
	}
//	
//	
//	/**
//	 * This method will pick a combination of numbers in a lottery. In this lottery, 
//	 * players can choose 6 numbers (possibly repeated) between 1 and 99 (both inclusive). 
//	 * Construct an object of the Random class (see the Java API docs) and invoke an 
//	 * appropriate method to generate each number. Your method should return a String that
//	 * contains this sentence: "The winning numbers are ", followed by the 6 numbers with 
//	 * one space in between each number.
//	 * 
//	 * @return	"The winning numbers are ", followed by 6 randomly-generated numbers 
//	 * with one space in between each number.
//	 */
//	public static String problem3_drawNumbers() {
//		return ""; // FIX ME
//	}
//	
//	
//	/**
//	 * Given a string and an integer, return a new string with the following transformations
//	 * applied:
//	 * 1. Reverse the characters in the string
//	 * 2. Insert the integer after the first character in the string
//	 * 
//	 * The string will always have length of at least 1, and the integer will always be a valid integer.
//	 * 
//	 * Hint: See the StringBuilder class in the Java API docs. 
//	 * 
//	 * @param str	the input string
//	 * @param num	the integer to insert
//	 * 
//	 * @return	the string reversed, with the number inserted after the first character in the string
//	 */
//	public static String problem4_reverseAndInsert(String str, int num) {
//		return ""; // FIX ME
//	}
//	
//	
//	/**
//	 * This method will calculate and return the distance from the line segment joining the points
//	 * (100, 100) and (200, 200) to the given Point. 
//	 * 
//	 * Hint: use the ptSegDist method of the Line2D class.
//	 * 
//	 * @param p	the point from which to calculate the distance to the line segement
//	 * 
//	 * @return	the distance from the given point to the line segment joining the points
//	 * (100, 100) and (200, 200)
//	 */
	public static double problem5_getLineDistance(Point p) {
		Line2D line = new Line2D.Float(100, 100, 200, 200);
        return line.ptSegDist(p);
	}
}