package ss.week4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ss.week4.math.Exponent;
import ss.week4.math.LinearProduct;
import ss.week4.math.Polynomial;

public class PolynomialTest {

	public static final int CONSTANT_VALUE = 3;
	public static final double[] CONSTANT_VALUES = new double[]{1.00, 2.35, 5.75};
    private static final double DELTA = 1e-15;
	
	@Test
	public void testApply() {
		assertEquals(21.8, new Polynomial(CONSTANT_VALUES).apply(CONSTANT_VALUE), DELTA);
		assertEquals(31.15, new Polynomial(CONSTANT_VALUES).apply(CONSTANT_VALUE + 1), DELTA);
	}
	
	@Test
    public void testDerivative() {
        Polynomial polynomial = new Polynomial(CONSTANT_VALUES);
        assertTrue(polynomial.derivative() instanceof Polynomial);
        assertEquals(8.35, polynomial.derivative().apply(CONSTANT_VALUE), DELTA);
    }

	@Test
	public void testIntegrand() {
		Polynomial polynomial = new Polynomial(CONSTANT_VALUES);
		assertTrue(polynomial.integrand() instanceof Polynomial);
		assertEquals(36.825, polynomial.integrand().apply(CONSTANT_VALUE), DELTA);
	}
}
