package ttt;

import java.util.Random;

class TicTacToe {
	private static final int HUMAN = 0;
	private static final int COMPUTER = 1;
	public static final int EMPTY = 2;

	public static final int HUMAN_WIN = 0;
	public static final int DRAW = 1;
	public static final int UNCLEAR = 2;
	public static final int COMPUTER_WIN = 3;

	private int[][] board = new int[3][3];
	private Random random = new Random();
	private int side = random.nextInt(2);
	private int position = UNCLEAR;
	private char computerChar, humanChar;

	// Constructor
	public TicTacToe() {
		clearBoard();
		initSide();
	}

	private void initSide() {
		if(this.side == COMPUTER) {
			computerChar = 'X';
			humanChar = 'O';
		}
		else {
			computerChar = 'O';
			humanChar = 'X';
		}
	}

	public void setComputerPlays() {
		this.side = COMPUTER;
		initSide();
	}

	public void setHumanPlays() {
		this.side = HUMAN;
		initSide();
	}

	public boolean computerPlays() {
		return side == COMPUTER;
	}

	public int chooseMove() {
		Best best=chooseMove(COMPUTER);
		return best.row*3+best.column;
		//return 0;
	}

	// Find optimal move
	public Best chooseMove(int side) {
		int opp; // The other side
		Best reply = null; // Opponent's best reply
		int simpleEval; // Result of an immediate evaluation
		int bestRow = 0;
		int bestColumn = 0;
		int value = 2;
		int boardRows = board.length;
		int boardColumns = board[0].length;

		if((simpleEval = positionValue()) != UNCLEAR) {
			return new Best(simpleEval);
		}
		// TODO: implementeren m.b.v. recursie/backtracking
		else {
			   if(side == HUMAN) {
		            value = COMPUTER_WIN;
		        }
		        else {
		            value = HUMAN_WIN;
		        }
			for(int row = 0; row < boardRows; row++) {
				for(int column = 0; column < boardColumns; column++) {
					if(!squareIsEmpty(row, column) || !moveOk((row *3) + column)) {
						continue;
					}
					else {
						place(row, column, side);
						if(side == HUMAN) {
							//value = COMPUTER_WIN;
							reply = chooseMove(COMPUTER);

							if(reply.val < value) {
								value = reply.val;
								bestRow = row;
								bestColumn = column;
							}
						}
						else if(side == COMPUTER) {
							//value = HUMAN_WIN;
							reply = chooseMove(HUMAN);

							if(reply.val > value) {
								value = reply.val;
								bestRow = row;
								bestColumn = column;
							}
						}
						place(row, column, EMPTY);
					}
				}
			}
		}


		return new Best(value, bestRow, bestColumn);
	}

	// check if move ok
	public boolean moveOk(int move) {
		return ( move>=0 && move <=8 && board[move/3 ][ move%3 ] == EMPTY );
		//return true;
	}

	// play move
	public void playMove(int move) {
		board[move / 3][move % 3] = this.side;
		if(side == COMPUTER) {
			this.side = HUMAN;
		}
		else {
			this.side = COMPUTER;
		}
	}

	// Simple supporting routines
	private void clearBoard() {
		// TODO:
		for(int i = 0; i < (board.length * board.length); i++) {
			board[i / 3][i % 3] = 2;
		}
	}

	private boolean boardIsFull() {
		// TODO:
		if(this.board.length == 9) {
			return true;
		}
		else {
			return false;
		}
	}

	// Returns whether 'side' has won in this position
	protected boolean isAWin(int side) {
		// TODO:
		int[][] possibilities = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8},
				{2, 4, 6}};
		for(int[] possibility : possibilities) {
			int pos1 = board[possibility[0] / 3][possibility[0] % 3];
			int pos2 = board[possibility[1] / 3][possibility[1] % 3];
			int pos3 = board[possibility[2] / 3][possibility[2] % 3];
			if(pos1 == side && pos2 == side && pos3 == side) {
				return true;
			}
		}

		return false;
	}

	// Play a move, possibly clearing a square
	private void place(int row, int column, int piece) {
		board[row][column] = piece;
	}

	private boolean squareIsEmpty(int row, int column) {
		return board[row][column] == EMPTY;
	}

	// Compute static value of current position (win, draw, etc.)
	protected int positionValue() {
		// TODO:
		if(boardIsFull()) {
			return DRAW;
		}
		else if(isAWin(HUMAN)) {
			return HUMAN_WIN;
		}
		else if(isAWin(COMPUTER)) {
			return COMPUTER_WIN;
		}
		else {
			return UNCLEAR;
		}
	}

	public String toString() {
		// TODO:
		String returnString = "";

		for(int i = 0; i < (board.length * board.length); i++) {
			int number = board[i / 3][i % 3];
			if(number == EMPTY) {
				returnString += "-";
			}
			else if(number == HUMAN) {
				returnString += humanChar;
			}
			else if(number == COMPUTER) {
				returnString += computerChar;
			}
			if(i % 3 == 2) {
				returnString += "\n";
			}
		}
		return returnString;
		// return "...\n...\n...\n";
	}

	public boolean gameOver() {
		this.position = positionValue();
		return this.position != UNCLEAR;
	}

	public String winner() {
		if(this.position == COMPUTER_WIN) {
			return "computer";
		}
		else if(this.position == HUMAN_WIN) {
			return "human";
		}
		else {
			return "nobody";
		}
	}

	public class Best {
		int row;
		int column;
		int val;

		public Best(int v) {
			this(v, 0, 0);
		}

		public Best(int v, int r, int c) {
			val = v;
			row = r;
			column = c;
		}
	}

}
