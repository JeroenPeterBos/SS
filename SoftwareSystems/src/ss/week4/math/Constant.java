package ss.week4.math;

import ss.week4.math.interfaces.Function;
import ss.week4.math.interfaces.Integrandable;

public class Constant implements Function, Integrandable {
	
	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	private double constant;
	
	// ------------------------------- Constructors ------------------------------------ //
	
	public Constant(double c) {
		this.constant = c;
	}
	
	// ------------------------------- Commands ---------------------------------------- //
	
	// ------------------------------- Queries ----------------------------------------- //
	
	@Override
	public double apply(double x) {
		return constant;
	}
	
	@Override
	public Function derivative() {
		return new Constant(0);
	}
	
	@Override
	public Function integrand(){
		return new LinearProduct(this, new Exponent(1));
	}
	
	@Override
	public String toString() {
		return Double.toString(constant);
	}
}
