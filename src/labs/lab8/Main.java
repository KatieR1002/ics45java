package labs.lab8;

import java.util.Iterator;
import java.util.List;
public class Main {

	/**
	 * Takes as a parameter any object that implements the Iterable<E> interface, and 
	 * returns a  String containing its elements (whatever is returned by that 
	 * element's toString method), each one separated by a comma and a space. 
	 * 
	 * @param <T>		type of the iterable parameter
	 * @param <E>		type of the elements contained in T
	 * @param iterable	object to get elements from
	 * 
	 * @return	a String containing iterable's elements (whatever is returned by that 
	 * element's toString method), each one separated by a comma and a space
	 */
	// WRITE PROBLEM 1 METHOD HERE
	public static  <E> String problem1_getElements(Iterable<E> iterable) {
		Iterator<E> iter = iterable.iterator();
		if(iter == null) {
			return "";
			}
			String r = "";
			while(iter.hasNext()) {
				r += iter.next();
				if(iter.hasNext()) {
				r += ", ";
			}
			}
			return r;
			}
	
	
	/**
	 * Takes a Pair, swaps the two elements, and returns it
	 * 
	 * @param <T>	type of the first element in the pair
	 * @param <S>	type of the second element in the pair
	 * @param p		the pair to swap
	 * 
	 * @return		the swapped pair
	 */
	// WRITE PROBLEM 2 METHOD HERE
	public static <T,S> Pair<S, T> problem2_swap(Pair<T, S> pair) {
        
		Pair<S,T> r = new Pair<>(pair.getSecond(), pair.getFirst());
		return r;
    }
	/**
	 * Checks whether a generic list is a palindrome; that is, whether 
	 * the values at index i and n - 1 - i are equal to each other, where n 
	 * is the size of the list. 
	 * 
	 * @param <T>	the type of element in the List
	 * @param a		the List
	 * 
	 * @return	true if it is a palindrome, or false if not
	 */
	// WRITE PROBLEM 5 METHOD HERE
	public static <T> boolean problem5_isPalindrome(List<T> a) {
		boolean r = true;
		int l = a.size()-1;
		int m = a.size()/2;
		for (int i =0; i < m; i++ ) {
			if(!a.get(i).equals(a.get(l))) {
				r = false;
				break;
			}
			l--;
			}
		return r;
		}		
		
	
	
}
