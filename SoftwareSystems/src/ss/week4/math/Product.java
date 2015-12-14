package ss.week4.math;

import ss.week4.math.interfaces.Function;
import ss.week4.math.interfaces.Integrandable;

public class Product implements Function {

	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	protected Function a, b;
	
	// ------------------------------- Constructors ------------------------------------ //
	
	public Product(Function a, Function b) {
		this.a = a;
		this.b = b;
	}
	
	// ------------------------------- Commands ---------------------------------------- //
	
	// ------------------------------- Queries ----------------------------------------- //
	
	@Override
	public double apply(double x) {
		return a.apply(x) * b.apply(x);
	}
	
	@Override
	public Function derivative() {
		return new Sum(new Product(a.derivative(), b), new Product(a, b.derivative()));
	}
	
	@Override
	public String toString() {
		return a.toString() + " * " + b.toString();
	}
}
