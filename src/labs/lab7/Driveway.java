package labs.lab7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Class for simulating a driveway and a street, using stacks of cars with
 * license plate numbers as representation.
 */
public class Driveway {
	private Stack<Integer> driveway; // represents cars in the driveway
	private Stack<Integer> street; // represents cars on the street

	/**
	 * Constructor
	 */
	public Driveway() {
		driveway = new Stack<Integer>();
		street = new Stack<Integer>();
		// FILL IN
		
	}

	
	/**
	 * Returns a String representation of the driveway. For a driveway stack
	 * with cars 1, 2, 3, and 4, with 1 first-in and 4 first-out, the string
	 * returned by this method would be: "Driveway: 1 2 3 4"
	 * 
	 * @return	a String representation of this driveway
	 */
	public String getDriveway() {
		String s = "";
		if (driveway.size() != 0)
		for(int i = 0; i<= driveway.size()-1; i++) {
			s += String.valueOf(driveway.get(i)) + " ";
		}
		//System.out.print(driveway.size());
		return "Driveway: " + s.strip(); // FIX ME
	}

	
	/**
	 * Returns a String representation of the street. For a street stack 
	 * with cars 1, 2, 3, and 4, with 1 first-in and 4 first-out, the string 
	 * returned by this method would be: "Street: 1 2 3 4"
	 * 
	 * @return	a String representation of the street
	 */
	public String getStreet() {
		String s = "";
		System.out.println("b");

		if (street.size() != 0) {        		System.out.println("c");

		for(int i = 0; i< street.size(); i++) {
			
			s += String.valueOf(street.get(i))+ " ";
		}}
		return "Street: "+s.strip(); // FIX ME
	}

	
	/**
	 * Adds the given license plate to the driveway if it's not already in the
	 * driveway. Returns a log of the process.
	 * 
	 * @param licensePlate number of license plate.
	 * 
	 * @return a log of the process
	 */
	public List<String> add(int licensePlate) {
		List<String>  sl=new ArrayList<String>();
		String log="";
        if (driveway.contains(licensePlate)) {
        	sl.add("That car is already in the driveway.");
        	}
        else {
        	 driveway.push(licensePlate);
        	 sl.add(getDriveway());
        	 sl.add(getStreet());
        	
        }
//        sl.add(log);
//        String[] str = new String[sl.size()];
//        for (int i = 0; i < sl.size(); i++) {
//            str[i] = sl.get(i);
//        }
//       
        return sl;
        }
        
        
        // FIX ME
	

	/**
	 * Remove the given license plate from the driveway if it's in the driveway.
	 * Returns a log of the process
	 * 
	 * @param licensePlate number of license plate.
	 * 
	 * @return a log of the process
	 */
	public List<String> remove(int licensePlate) {
		List<String>  sl=new ArrayList<String>();
		String log="";
		int i = driveway.size()-1;
		if (driveway.contains(licensePlate)) {
        while (driveway.contains(licensePlate)) {
        	System.out.println(1);
        	System.out.println(driveway.get(i));
        	if (driveway.get(i) == licensePlate) {
        		
        		System.out.println(2);
        		driveway.pop();
        		if (street.size() != 0)
        		{driveway.push(street.get(street.size()-1));
        		street.pop();}
    
        		//log = this.getDriveway() + ", " + this.getStreet();
        		 sl.add(getDriveway());
            	 sl.add(getStreet());
        	}
        	else {
        		System.out.println(3);
        		street.push(driveway.get(i));
        		driveway.remove(i);
        		
        		
        		sl.add(getDriveway());

            	 sl.add(getStreet());
         		System.out.println("a");

            	
        		
        	} 
        	
        	
        	i--;
        	}
        int a = street.size()-1;
        System.out.print(4);
        while (street.size() != 0){
        	System.out.print(5);
        	driveway.add(street.get(a));
        	street.pop();
        	sl.add(getDriveway());
       	 	sl.add(getStreet());
        	a--;
        }
        
        }
        else {
        	log = "That car is not in the driveway.";
        	sl.add(log);
        	}
// 
//		String[] str = new String[sl.size()];
//        for (int j = 0; j < sl.size(); j++) {
//            str[j] = sl.get(j);
//        }
       
        return sl;
        
		 // FIX ME
	
}
}
