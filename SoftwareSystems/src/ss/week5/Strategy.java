package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public interface Strategy {

	public String getName();
	
	public int determineMove(Board b, Mark m);
}
