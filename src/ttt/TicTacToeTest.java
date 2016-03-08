package ttt;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class TicTacToeTest extends TestCase{
	public  TicTacToeTest(String arg0){
		super(arg0);
	}
	@Test
	public void test() {
		TicTacToe ttt = new TicTacToe();
		assertEquals(TicTacToe.UNCLEAR,ttt.positionValue());
		ttt.playMove(1);
		assertEquals(TicTacToe.UNCLEAR, ttt.positionValue());
		TicTacToe ticTest = new TicTacToe();
		ticTest.setComputerPlays();
		ticTest.playMove(1);
		ticTest.playMove(2);
		ticTest.playMove(4);
		ticTest.playMove(3);
		ticTest.playMove(7);
		assertEquals(TicTacToe.COMPUTER_WIN, ticTest.positionValue());
		assertEquals(true, ticTest.isAWin(1));
		assertEquals(false, ticTest.isAWin(0));
		
		TicTacToe moveTest = new TicTacToe();
		assertEquals(0, moveTest.chooseMove());
		moveTest.playMove(1);
		moveTest.playMove(2);
		moveTest.playMove(7);
		assertEquals(5, moveTest.chooseMove());
	}
	


}

