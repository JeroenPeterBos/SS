package ss.week4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ss.week4.math.Constant;
import ss.week4.math.LinearProduct;

public class ConstantTest {

    private static final double DELTA = 1e-15;
    private static final double CONSTANT_VALUE = Math.PI;
    private Constant constant;

    @Before
    public void setUp() {
        constant = new Constant(CONSTANT_VALUE);
    }

    @Test
    public void testApply() {
        assertEquals(CONSTANT_VALUE, constant.apply(0), DELTA);
        assertEquals(CONSTANT_VALUE, constant.apply(-1), DELTA);
        assertEquals(CONSTANT_VALUE, constant.apply(1), DELTA);
    }

    @Test
    public void testDerivative() {
        assertTrue(constant.derivative() instanceof Constant);
        assertEquals(0.0, constant.derivative().apply(0), DELTA);
    }
    
    @Test
    public void testIntegrand() {
        assertTrue(constant.integrand() instanceof LinearProduct);
        assertEquals(CONSTANT_VALUE * 3, constant.integrand().apply(3), DELTA);
    }
}
