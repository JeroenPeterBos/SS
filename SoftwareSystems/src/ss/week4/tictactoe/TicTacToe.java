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
        System.out.println(args.length);
        
        Player p1;
        switch(args[0]){
        case "-N":
        	p1 = new ComputerPlayer(Mark.XX);
        	break;
        case "-S":
        	p1 = new ComputerPlayer(Mark.XX, new SmartStrategy());
        	break;
        default:
        	p1 = new HumanPlayer(args[0], Mark.XX);
        	break;
        }
         
        Player p2;
        switch(args[1]){
        case "-N":
        	p2 = new ComputerPlayer(Mark.OO);
        	break;
        case "-S":
        	p2 = new ComputerPlayer(Mark.OO, new SmartStrategy());
        	break;
        default:
        	p2 = new HumanPlayer(args[1], Mark.OO);
        	break;
        }
        
        Game g = new Game(p1, p2);
        g.start();
    }
}
