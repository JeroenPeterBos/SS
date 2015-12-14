package ss.week4.math;

import ss.week4.math.interfaces.Function;
import ss.week4.math.interfaces.Integrandable;

public class Exponent implements Function, Integrandable {

	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	private int n;
	
	// ------------------------------- Constructors ------------------------------------ //
	
	public Exponent(int n) {
		this.n = n;
	}
	
	// ------------------------------- Commands ---------------------------------------- //
	
	// ------------------------------- Queries ----------------------------------------- //
	
	@Override
	public double apply(double x) {
		double result = 1;
		
		if (x == 0) {
			return 0;
		}
		
		for (int i = 0; i < n; i++) {
			result *= x;
		}
		
		return result;
	}
	
	@Override
	public Function derivative() {
		return new LinearProduct(new Constant(n), new Exponent(n - 1));
	}
	
	@Override
	public Function integrand() {
		return new LinearProduct(new Constant(1.0/(n+1)), new Exponent(n + 1));
	}
	
	@Override
	public String toString() {
		return "x^" + Integer.toString(n);
	}
}
