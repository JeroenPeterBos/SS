package ss.week6;

public class TooFewArgumentsException extends WrongArgumentException{
	private static final long serialVersionUID = 1L;

	public TooFewArgumentsException(){
		super("error: must pass two command line arguments");
	}
	
	public TooFewArgumentsException(String message){
		super(message);
	}
}
