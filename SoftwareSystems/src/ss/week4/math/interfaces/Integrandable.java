package ss.week4.math.interfaces;

/**
 * Functions that are integrandable should implement this interface
 * @author Jeroen
 * @version 1.0
 */
public interface Integrandable{

	/**
	 * Creates a new function object that represents the integrand of this function.
	 * @return the integrand of the current function
	 */
	public Function integrand();
}
