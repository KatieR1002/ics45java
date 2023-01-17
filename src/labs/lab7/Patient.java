package labs.lab7;

/**
 * Class representing a patient in a hospital emergency room
 */
public class Patient implements Comparable<Patient> {

	// ADD YOUR INSTANCE VARIABLES HERE
	private Injury i;
	private String d;
	/**
	 * Creates a new Patient object with the given injury and description
	 */
	public Patient(Injury injury, String description) {
		i = injury;
		d = description;// FILL IN
	}


	public int getPriority() {
		return Injury.getTriageLevel(i); // FIX ME
	}


	public Injury getInjury() {
		return i; // FIX ME
	}


	public String getDescription() {
		return d; // FIX ME
	}


	/**
	 * Compares patients by priority
	 */
	@Override
	public int compareTo(Patient p) {
		return this.getPriority() - p.getPriority(); // FIX ME
	}
	
	
	/**
	 * Returns a string representation of this patient in the format:
	 * "Injury: [INJURY], Description: [DESCRIPTION]"
	 */
	@Override
	public String toString() {
		return "Injury: " + this.getInjury() + "Description: " + this.getDescription(); // FIX ME
	}

}