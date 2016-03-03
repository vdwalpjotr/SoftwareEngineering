package ttt;

import junit.framework.TestCase;

public class IsAWinTest extends TestCase {
	
	public IsAWinTest(String arg0) {
		super(arg0);
	}
	
	public void test() {
		
		//Computer wins test
		TicTacToe ttt = new TicTacToe();
		ttt.setComputerPlays();
		
		ttt.playMove(0);
		ttt.playMove(1);
		ttt.playMove(3);
		ttt.playMove(2);
		ttt.playMove(6);
		
		assertEquals(true, ttt.isAWin(1));	
		assertEquals(false, ttt.isAWin(0));

		
		/*
		 * All win possibilities
		 * Human shout wins
		 */		
		TicTacToe ttt1 = new TicTacToe();
		ttt1.setHumanPlays();
		
		ttt1.playMove(0);
		ttt1.playMove(1);
		ttt1.playMove(3);
		ttt1.playMove(2);
		ttt1.playMove(6);
		
		assertEquals(true, ttt1.isAWin(0));	
		assertEquals(false, ttt1.isAWin(1));

		
		TicTacToe ttt2 = new TicTacToe();
		ttt2.setHumanPlays();
		
		ttt2.playMove(0);
		ttt2.playMove(3);
		ttt2.playMove(1);
		ttt2.playMove(6);
		ttt2.playMove(2);

		assertEquals(true, ttt2.isAWin(0));	
		assertEquals(false, ttt2.isAWin(1));
		
		
		TicTacToe ttt3 = new TicTacToe();
		ttt3.setHumanPlays();

		ttt3.playMove(0);
		ttt3.playMove(1);
		ttt3.playMove(4);
		ttt3.playMove(2);
		ttt3.playMove(8);
		
		assertEquals(true, ttt3.isAWin(0));	
		assertEquals(false, ttt3.isAWin(1));

		
		TicTacToe ttt4 = new TicTacToe();
		ttt4.setHumanPlays();

		ttt4.playMove(6);
		ttt4.playMove(1);
		ttt4.playMove(7);
		ttt4.playMove(2);
		ttt4.playMove(8);
		
		assertEquals(true, ttt4.isAWin(0));	
		assertEquals(false, ttt4.isAWin(1));

		
		TicTacToe ttt5 = new TicTacToe();
		ttt5.setHumanPlays();

		ttt5.playMove(6);
		ttt5.playMove(1);
		ttt5.playMove(4);
		ttt5.playMove(3);
		ttt5.playMove(2);
		
		assertEquals(true, ttt5.isAWin(0));	
		assertEquals(false, ttt5.isAWin(1));

		
		TicTacToe ttt6 = new TicTacToe();
		ttt6.setHumanPlays();
		
		ttt6.playMove(2);
		ttt6.playMove(1);
		ttt6.playMove(5);
		ttt6.playMove(3);
		ttt6.playMove(8);
		
		assertEquals(true, ttt6.isAWin(0));	
		assertEquals(false, ttt6.isAWin(1));

		
		TicTacToe ttt7 = new TicTacToe();
		ttt7.setHumanPlays();
		
		ttt7.playMove(3);
		ttt7.playMove(1);
		ttt7.playMove(4);
		ttt7.playMove(2);
		ttt7.playMove(5);
		
		assertEquals(true, ttt7.isAWin(0));	
		assertEquals(false, ttt7.isAWin(1));
		
	}

}
