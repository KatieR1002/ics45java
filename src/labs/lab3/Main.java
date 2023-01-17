package labs.lab3;

import java.util.Scanner;

public class Main {

	/**
	 * Accepts a String as a parameter and looks for a mirror image (backwards)
	 * string at both the beginning and end of the given string. In other words,
	 * zero or more characters at the very beginning of the given string, and at the
	 * very end of the string in reverse order (possibly overlapping). For example,
	 * the string "abXYZba" has the mirror end "ab".
	 * 
	 * @param str the string to check for mirror ends
	 * @return the mirror end, or the empty string if no mirror end exists
	 */
	public static String problem1_mirrorEnds(String str) {
		String rstr = "";
		String r = "";

		for(int i = str.length()-1; i>=0; i--) {
			rstr += str.charAt(i);
		}
//		System.out.println(str);
//		System.out.println(rstr);
	    for (int l = 0; l < str.length(); l++) {
			if(str.charAt(l) == rstr.charAt(l)) {
					r += str.charAt(l);
				}
			else {
					break;
				}
			}	
		return r; // FIX ME
		
	}


	/**
	 * Given a string, returns the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same.
	 * 
	 * @param str the string to check for blocks
	 * 
	 * @return the length of the largest block in the string
	 */
	public static int problem2_maxBlock(String str) {
		//System.out.print(str);
		if (str.equals("")) {return 0;}
		int pm = 1;
		int block = 0;
		char previous = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
//			System.out.print(1);
//			System.out.print(previous);
//			System.out.print(str.charAt(i));
			if(previous == str.charAt(i)) {
				pm += 1;
//				System.out.print(previous);
//				System.out.print(pm);
			}
			else {

				pm = 1;
//				System.out.print(pm);
//				System.out.print(block);
			}
			if (block < pm) {
				block = pm;
			};
			previous = str.charAt(i);
		}
		return block; // FIX ME
		
	}


	/**
	 * An uppercase 'E' in a string is "happy" if there is another uppercase 'E'
	 * immediately to its left or right. Returns true if all the E's in the given
	 * string are happy. (A string with no 'E' in it returns true.)
	 * 
	 * @param str
	 * @return whether or not all E's in the string are happy
	 */
	public static boolean problem3_EHappy(String str) {
		boolean r = true;
//		char previous = str.charAt(0);
//		int cnt = 0;
		if (str.equals("E") ) {
			r = false; 
		}
		if (str.length() == 2) {
			if ((str.charAt(0) == 'E' && str.charAt(1) != 'E')||(str.charAt(1) == 'E' && str.charAt(0) != 'E')) {
				r = false;
			}
		}
		if (str.length() >=3) {
		for(int i = 1; i < str.length()-1; i++) {
			if (str.charAt(i) == 'E' && str.charAt(i-1) != 'E' && str.charAt(i+1) != 'E') {
				r = false;}
			}
		if (str.charAt(str.length()-1) == 'E' && str.charAt(str.length()-2) != 'E') {
			r = false;
		}
		}
		
		
		return r; // FIX ME11
	}
	
	
	/**
	 * Returns the minimum number of twists to unlock a lock, based on the starting
	 * and target values
	 * 
	 * @param starting	the current numbers of the lock
	 * @param target	the combination required to unlock the lock
	 * 
	 * @return	the minimum number of twists to unlock the lock
	 */
	public static int problem4_getNumTwists(int starting, int target) {
//		String s = String.valueOf(starting);
//		String t = String.valueOf(target);
//		System.out.println(starting);
//		System.out.println(target);
		int twist = 0, o = 0, r = 0, lr = 0, mn = 0, f = 1000;
		for (int i = 0; i < 4; i++) {
			o = Math.abs(starting/f - target/f);
			r = Math.abs((starting/f + 10) - target/f);
			lr= Math.abs(starting/f - (target/f+10));
			mn = o<r?o:r;
			mn = mn<lr?mn:lr;
			twist += mn;
			starting %= f; 
			target %= f;
			f /= 10;
//			System.out.println(o);
//			System.out.println(r);
//			System.out.println(twist);

		}
		
		return twist;
			
		}
		
		
		
		
	
	
	
	/**
	 * Manages crowd control in an office
	 * 
	 * @param in       the Scanner to be used for user input
	 * @param capacity of the office
	 * 
	 *                 To run this method using the keyboard for user input, call it
	 *                 like this: problem5_officeCrowdControl(new Scanner(System.in), 100);
	 */
	public static void problem5_officeCrowdControl(Scanner in, int capacity) {
		// FILL IN
		    int ppl = 0, input = 0;
		    System.out.print("People entering or leaving: ");
		    input = in.nextInt();
		    while (true) {
		        if (input + ppl < capacity && input + ppl >= 0) {
		            ppl += input;
		            System.out.print("People in office: " + ppl + " | ");
		            System.out.print("People entering or leaving: ");
		            input = in.nextInt();
		        } else if (input + ppl == capacity) {
		            ppl += input;
		            System.out.print("People in office: " + ppl + " | ");
		            System.out.print("Office is full");
		            break;
		        } else {
		            System.out.print("People in office: " + ppl + " | ");
		            System.out.print("People entering or leaving: ");
		            input = in.nextInt();
		        }
		    }
	 }

	
	
	
	/**
	 * Takes an array of ints and returns an array that contains the exact same numbers 
	 * as the given array, but rearranged so that all the even numbers come before all
	 * the odd numbers
	 * 
	 * @param nums	the input array
	 * 
	 * @return	the rearranged array with all even numbers coming before all odd numbers
	 */
	public static int[] problem6_evenOdd(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while (left < right) {
		if (nums[left]%2 == 0) {
			left++;
		}
		if (nums[right]%2 != 0) {
			right--;
		}
		System.out.println(left);
		System.out.println(right);
		if (left < right) {
		if (nums[left]%2 != 0 && nums[right]%2 == 0) {
			int temp=nums[left];
		    nums[left]=nums[right];
		    nums[right]=temp;
		}}
		
		}
	    
		
	                                                    
	    return nums;
	}
	
	/**
	 * Given a non-empty array of ints, returns a new array containing the elements from
	 * the original array that come after the last occurrence of the number 4 in the original
	 * array
	 * 
	 * @param nums	the input array
	 * 
	 * @return	a new array containing the elements from the original array that come after 
	 * the last occurrence of the number 4 in the original array
	 * 
	 */
	public static int[] problem7_after4(int[] nums) {
		int i = nums.length - 1;
	    
	    while(nums[i] != 4) 
	        i--;
	              
	    int[] r = new int[nums.length - i - 1];
	                  
	    for(int j = 0; j < r.length; j++)
	        r[j] = nums[i + j + 1];
	                          
	    return r;
	}
	
	public static void main(String[] args) {
		//System.out.println(problem2_maxBlock("xyzz"));
	}
}