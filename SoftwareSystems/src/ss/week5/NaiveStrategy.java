package ss.week5;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class NaiveStrategy implements Strategy{

	@Override
	public String getName(){
		return "Naive";
	}
	
	@Override
	public int determineMove(Board b, Mark m){
		Set<Integer> emptyFields = new HashSet<Integer>();
		
		for(int i = 0; i < Board.DIM * Board.DIM; i++){
			if(b.getField(i) == Mark.EMPTY){
				emptyFields.add(i);
			}
		}
		int index = (int)((Math.random()) * emptyFields.size());
		return (Integer)(emptyFields.toArray()[index]);
	}
}
