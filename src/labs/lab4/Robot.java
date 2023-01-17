package labs.lab4;

import java.awt.Point;

/**
 * A class for simulating a robot wandering on a 10 x 10 plane.
 */
public class Robot {
	
	// ADD YOUR INSTANCE VARIABLES HERE
	private int x;
	private int y;
	private int dir; 
	
	/**
	 * Creates a Robot at location (0, 0), which is in the center of the plane,
	 * and facing north
	 */
	public Robot() {
		// FILL IN
		x = 0;
		y = 0;
		dir = 0;
		}
	

	/**
	 * Changes the direction but not the location
	 */
	public void turnLeft() {
		// FILL IN
		dir = (dir+3)%4;
		}
	

	/**
	 * Changes the direction but not the location
	 */
	public void turnRight() {
		// FILL IN
		dir = (dir+1)%4;
	}

	
	/**
	 * Moves the robot by one unit in the direction it is facing. Returns true if the
	 * robot is still on the plane, or false if it has fallen off.
	 * 
	 * Note 1: In coordinate terms, |x| must be <= 5 and |y| must be <= 5 for the robot
	 * to stay on the plane (see below example).
	 * 
	 * Note 2: This method can still be called on a robot that has fallen off the plane,
	 * and its location should be updated as if it was still on the plane.
	 * 
	 * @return	true if the robot is still on the plane, false otherwise
	 */
	public boolean move() {
		if (dir == 0) {
			y+=1;
		}
		else if (dir == 2) {
			y-=1;
		}
		else if (dir == 1) {
			x+=1;
		}
		else if (dir == 3) {
			x-=1;
		}

		return (Math.abs(x)<=5 && Math.abs(y)<=5); // FIX ME
	}

	
	/**
	 * Returns the robot's current location on the plane
	 * 
	 * @return	robot's current location
	 */
	public Point getLocation() {
		System.out.print(x);
		System.out.println(y);

		return new Point(x, y); // FIX ME
	}

	
	/**
	 * Returns "N", "E", "S", or "W" (for north, east, south, or west, respectively)
	 * 
	 * @return	the robot's direction
	 */
	public String getDirection() {
		return (dir==0) ? "N" : (dir==1) ? "E" : (dir==2) ? "S" : "W"; 
	}
}

