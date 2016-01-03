package ss.week4.math.interfaces;

public interface Function {

	/**
	 * Applies the variable x to this function
	 * @param x the value to be applied
	 * @return the result of f(x)
	 */
	public double apply(double x);
	
	/**
	 * Creates a new function that represents the derivative of the current function
	 * @return the derivative of this function
	 */
	public Function derivative();
	
	/**
	 * Creates a human readable form of the function
	 * @return string of the function
	 */
	public String toString();
}
