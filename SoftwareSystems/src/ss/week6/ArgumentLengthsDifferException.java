package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException{
	private static final long serialVersionUID = 1L;

	private int a, b;
	
	public ArgumentLengthsDifferException(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String getMessage(){
		return "error: length of command line arguments differs (" + a + ", " + b + ")";
	}
}
