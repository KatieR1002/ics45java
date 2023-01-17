package labs.lab2;

/**
 * A rectangle defined by its x- and y-coordinates of its upper-left and lower-right corners
 */
public class Rectangle {
	// ADD YOUR INSTANCE VARIABLES HERE
	/**
	 * Constructor
	 * 
	 * @param x1	upper-left corner x value
	 * @param y1	upper-left corner y value
	 * @param x2	lower-right corner x value
	 * @param y2	lower-right corner y value
	 */
	private double x1, y1, x2, y2;
	
	public Rectangle(double x1, double y1, double x2, double y2) {
		// FILL IN
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	
	/**
	 * Gets the orientation of this rectangle
	 * 
	 * @return "square", "portrait", or "landscape"
	 */
	public String getOrientation() {
		double xl = x2-x1;
		double yl = y1-y2;
		if (xl == yl) {
			return "square";
		}
		if (xl > yl) {
			return "landscape";
		}
		if (xl < yl) {
			return "portrait";
		}
		return "";
		// FILL IN
	}
}
