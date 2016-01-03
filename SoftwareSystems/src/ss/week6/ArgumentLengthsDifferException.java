package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException{
	private static final long serialVersionUID = 1L;

	public ArgumentLengthsDifferException(int a, int b){
		super("error: length of command line arguments differs (" + a + ", " + b + ")");
	}
	
	public ArgumentLengthsDifferException(String message){
		super(message);
	}
}
