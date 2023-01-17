package labs.lab4;
import java.awt.Point;
import static org.junit.Assert.*;

import org.junit.Test;


public class RobotTest {

	@Test
    public void testConstructor() {
		// FILL IN
		Robot robot = new Robot();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("N", robot.getDirection());
    }

	@Test
    public void testTurnLeft() {
		// FILL IN
		Robot robot = new Robot();
		robot.turnLeft();
		assertEquals("W", robot.getDirection());
    }
	
	@Test
    public void testTurnRight() {
		// FILL IN
		Robot robot = new Robot();
		robot.turnRight(); 
		assertEquals("E", robot.getDirection());
    }
	
	@Test
    public void testMove() {
		// FILL IN
		Robot robot = new Robot();
		assertTrue(robot.move()); 
		assertEquals(true, robot.getLocation().equals(new Point(0, 1))); 
		assertEquals("N", robot.getDirection());
		robot.turnLeft(); 
		assertTrue(robot.move());  
		assertTrue(robot.move()); 
		assertEquals(true, robot.getLocation().equals(new Point(-2, 1))); 
		assertEquals("W", robot.getDirection());
		robot.turnRight(); 
		assertTrue(robot.move());  
		assertTrue(robot.move()); 
		assertEquals(true, robot.getLocation().equals(new Point(-2, 3))); 
		assertEquals("N", robot.getDirection());
    }
}