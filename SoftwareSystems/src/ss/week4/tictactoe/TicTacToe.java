package ss.week4.tictactoe;

import ss.week5.ComputerPlayer;
import ss.week5.SmartStrategy;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
        
        Player p1;
        if(args.length > 0){
            p1 = createPlayer(args[0], Mark.XX);
        } else {
        	p1 = new HumanPlayer("Player 1", Mark.XX);
        }
        
        Player p2;
        if(args.length > 1){
            p2 = createPlayer(args[1], Mark.OO);
        } else {
        	p2 = new HumanPlayer("Player 2", Mark.OO);
        }
        
        Game g = new Game(p1, p2);
        g.start();
    }
    
    public static Player createPlayer(String input, Mark m){
    	switch(input){
        case "-N":
        	return new ComputerPlayer(m);
        case "-S":
        	return new ComputerPlayer(m, new SmartStrategy());
        default:
        	return new HumanPlayer(input, m);
        }
    }
}
