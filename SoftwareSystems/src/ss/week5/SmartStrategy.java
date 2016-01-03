package ss.week5;

import java.util.ArrayList;
import java.util.List;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class SmartStrategy implements Strategy{

	@Override
	public String getName() {
		return "Smart";
	}

	@Override
	public int determineMove(Board b, Mark m) {
		if(b.getField(1, 1) == Mark.EMPTY){
			return b.index(1, 1);
		}
		
		List<Integer> emptyFields = new ArrayList<Integer>();
		
		for(int i = 0; i < Board.DIM * Board.DIM; i++){
			if(b.getField(i) == Mark.EMPTY){
				emptyFields.add(i);
			}
		}
		for(int i : emptyFields){
			if(guaranteesWin(b.deepCopy(), i, m)){
				return i;
			}
		}
		
		for(int i : emptyFields){
			if(guaranteesWin(b.deepCopy(), i, m.other())){
				return i;
			}
		}
		int index = emptyFields.get((int)(Math.random() * (emptyFields.size() - 1)));
		System.out.println(index);
		return index;
	}
	
	private boolean guaranteesWin(Board b, int i, Mark m){
		b.setField(i, m);
		return b.hasRow(m) || b.hasColumn(m) || b.hasDiagonal(m);
	}

}
