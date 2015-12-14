package ss.week4.math;

import ss.week4.math.interfaces.Function;
import ss.week4.math.interfaces.Integrandable;

public class Sum implements Function, Integrandable {

	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	private Function a, b;
	
	// ------------------------------- Constructors ------------------------------------ //
	
	public Sum(Function a, Function b) {
		this.a = a;
		this.b = b;
	}
	
	// ------------------------------- Commands ---------------------------------------- //
	
	// ------------------------------- Queries ----------------------------------------- //
	
	@Override
	public double apply(double x) {
		return a.apply(x) + b.apply(x);
	}
	
	@Override
	public Function derivative() {
		return new Sum(a.derivative(), b.derivative());
	}
	
	@Override
	public Function integrand() {
		if(a instanceof Integrandable && b instanceof Integrandable){
			return new Sum(((Integrandable)a).integrand(), ((Integrandable)b).integrand());
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return a.toString() + " + " + b.toString();
	}
}
