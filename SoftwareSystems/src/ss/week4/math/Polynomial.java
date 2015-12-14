package ss.week4.math;

import ss.week4.math.interfaces.Function;
import ss.week4.math.interfaces.Integrandable;

public class Polynomial implements Function, Integrandable {

	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	private Function[] parts;
	
	// ------------------------------- Constructors ------------------------------------ //
	
	public Polynomial(double[] a){
		parts = new Function[a.length];
		
		for(int i = 0; i < a.length; i++){
			parts[i] = new LinearProduct(new Constant(a[i]), new Exponent(a.length - i - 1));
		}
	}
	
	public Polynomial(LinearProduct[] lp){
		this.parts = lp;
	}
	
	// ------------------------------- Commands ---------------------------------------- //
	
	// ------------------------------- Queries ----------------------------------------- //
	
	@Override
	public double apply(double x) {
		double result = 0;
		
		for(Function f : parts){
			result += f.apply(x);
		}
		
		return result;
	}

	@Override
	public Function derivative() {
		LinearProduct[] result = new LinearProduct[parts.length - 1];
		
		for(int i = 0; i < parts.length - 1; i++){
			result[i] = (LinearProduct)parts[i].derivative();
		}
		
		return new Polynomial(result);
	}
	
	@Override
	public Function integrand() {
		boolean integrandable = true;
		for(int i = 0; i < parts.length; i++){
			if(!(parts[i] instanceof LinearProduct)){
				return null;
			}
		}
		
		LinearProduct[] result = new LinearProduct[parts.length + 1];
		
		for(int i = 0; i < parts.length; i++){
			result[i] = (LinearProduct)((LinearProduct)parts[i]).integrand();
		}
		
		// a * x ^ 0 : first constant is 0 and second constant represents x ^ 0;
		result[parts.length] = new LinearProduct(new Constant(0), new Constant(1));
		
		return new Polynomial(result);
	}
}
