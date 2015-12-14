package ss.week4.math;

import ss.week4.math.interfaces.Function;
import ss.week4.math.interfaces.Integrandable;

public class LinearProduct extends Product implements Integrandable{

	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	private Constant a;
	
	// ------------------------------- Constructors ------------------------------------ //
	
	public LinearProduct(Constant a, Function b) {
		super(a, b);
		this.a = a;
	}
	
	// ------------------------------- Commands ---------------------------------------- //
	
	// ------------------------------- Queries ----------------------------------------- //
	
	@Override
	public Function derivative() {
		return new LinearProduct(a, b.derivative());
	}
	
	@Override
	public Function integrand() {
		if (b instanceof Integrandable){
			return new LinearProduct(a, ((Integrandable)b).integrand());
		}
		return null;
	}
}
