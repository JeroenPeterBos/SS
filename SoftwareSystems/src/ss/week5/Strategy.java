package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public interface Strategy {

	/**
	 * Gives the name of this computerplayer strategy.
	 * @return name of the strategy.
	 */
	public String getName();
	
	/**
	 * Chooses a move based on the strategy.
	 * @param b	The board that is being played on.
	 * @param m the mark of this player
	 * @return the field that the player should choose
	 */
	public int determineMove(Board b, Mark m);
}
