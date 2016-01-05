package ss.week6;

public class TooFewArgumentsException extends WrongArgumentException{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage(){
		return "error: must pass two command line arguments";
	}
}
