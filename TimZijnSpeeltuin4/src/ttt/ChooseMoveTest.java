package ttt;

import junit.framework.TestCase;
import ttt.TicTacToe.Best;

public class ChooseMoveTest extends TestCase {
	
	public ChooseMoveTest(String arg0) {
		super(arg0);
	}
	
	public void test() {
		Best best = null;
		TicTacToe ttt = new TicTacToe();
		ttt.computerPlays();
		
		ttt.playMove(0);
		ttt.playMove(6);
		ttt.playMove(1);

		best = ttt.chooseMove(1);
		ttt.playMove(best.row*3+best.column);
		assertEquals(2, best.row*3+best.column);
				
		Best best1 = null;
		TicTacToe ttt1 = new TicTacToe();
		ttt.computerPlays();
		
		ttt1.playMove(1);
		ttt1.playMove(0);
		ttt1.playMove(2);

		best1 = ttt1.chooseMove(0);
		ttt1.playMove(best1.row*3+best1.column);
		assertEquals(4, best1.row*3+best1.column);
		
	}

}
