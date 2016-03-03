package ttt;

import junit.framework.TestCase;

public class PositionValueTest extends TestCase {
	
	public PositionValueTest(String arg0) {
		super(arg0);
	}
	
	public void test() {
		TicTacToe ttt = new TicTacToe();		
		assertEquals(2, ttt.positionValue());
		
		ttt.playMove(0);
		assertEquals(2, ttt.positionValue());

		TicTacToe ttt1 = new TicTacToe();
		ttt1.setHumanPlays();
		
		ttt1.playMove(0);
		ttt1.playMove(4);
		ttt1.playMove(8);
		ttt1.playMove(3);
		ttt1.playMove(5);
		ttt1.playMove(2);
		ttt1.playMove(6);
		ttt1.playMove(7);
		ttt1.playMove(1);
		ttt1.playMove(0);
		
		assertEquals(1, ttt1.positionValue());
		
		TicTacToe ttt2 = new TicTacToe();
		ttt2.setHumanPlays();
		
		ttt2.playMove(0);
		ttt2.playMove(1);
		ttt2.playMove(3);
		ttt2.playMove(2);
		ttt2.playMove(6);
		assertEquals(0, ttt2.positionValue());
		
		
		TicTacToe ttt3 = new TicTacToe();
		ttt3.setComputerPlays();

		ttt3.playMove(0);
		ttt3.playMove(1);
		ttt3.playMove(3);
		ttt3.playMove(2);
		ttt3.playMove(6);;
		assertEquals(3, ttt3.positionValue());
		
	}

}
