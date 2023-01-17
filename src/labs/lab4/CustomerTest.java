package labs.lab4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	private final double EPSILON = 1e-13;
	@Test
	public void testPurchaseLessThan100() {
		// FILL IN
		Customer c = new Customer();
		c.makePurchase(80);
		assertEquals(0, c.getNumDiscountsToUse());
		assertEquals(80.0, c.getTotalAmountSpent(), EPSILON);
	}
	
	@Test
	public void testPurchaseMoreThan100() {
		// FILL IN
		Customer c = new Customer();
		c.makePurchase(150);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(150.0, c.getTotalAmountSpent(), EPSILON);
		
		c.makePurchase(151);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(285.9, c.getTotalAmountSpent(), EPSILON);
	}
	
	@Test
	public void testDiscountApplied() {
		// FILL IN
		Customer c = new Customer();
		c.makePurchase(175);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(175.0, c.getTotalAmountSpent(), EPSILON);
		
		c.makePurchase(100);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(265.0, c.getTotalAmountSpent(), EPSILON);
	}
	
	@Test
	public void testPurchaseEarningMultipleDiscounts() {
		// FILL IN
		Customer c = new Customer();
		c.makePurchase(175);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(175.0, c.getTotalAmountSpent(), EPSILON);
		
		c.makePurchase(100);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(265.0, c.getTotalAmountSpent(), EPSILON);
	}
	
	@Test
	public void testOnlyOneDiscountApplied() {
		// FILL IN
		Customer c = new Customer();
		c.makePurchase(175);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(175.0, c.getTotalAmountSpent(), EPSILON);
	}
}