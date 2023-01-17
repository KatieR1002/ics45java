package labs.lab5;

/**
 * A person in the Pest game
 */
public abstract class Person implements Comparable {
	private String name;

	
	/**
	 * Constructor
	 * 
	 * @param name	name of person
	 */
	public Person(String name) {
		this.name = name;
		// FILL IN
	}

	
	public String getName() {
		return this.name; // FIX ME
	}

	
	/**
	 * Compares Persons by name, lexicographically
	 */
	public int compareTo(Object otherPerson) {
		
		return this.name.compareTo(((Person) otherPerson).getName()); // FIX ME
	}
}