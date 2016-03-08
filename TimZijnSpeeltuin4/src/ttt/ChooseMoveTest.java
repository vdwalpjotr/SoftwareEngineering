package ttt;


import org.junit.*;
import junit.framework.TestCase;

import ttt.Tui;

public class ChooseMoveTest extends TestCase {

 public ChooseMoveTest(String arg0) {
  super(arg0);
 }
 
 public void testPositionValue() {
  TicTacToe game = new TicTacToe();
  
  // Start board
  System.out.println(game.toString());
  
  // Player X plays move in grid 2
  game.playMove(2);
  System.out.println(game.toString());
  
  // Player O plays move in grid 6
  game.playMove(6);
  System.out.println(game.toString());
  
  // Player X plays move in grid 5
  game.playMove(5);
  System.out.println(game.toString());
  
  // Player O plays move in grid 4
  game.playMove(4);
  System.out.println(game.toString());
  
  // Player X plays move in grid 8
  game.playMove(8);
  System.out.println(game.toString());
  
  // Check out if player X has one. value must be true
  System.out.println("Has player 0 won the game?: " + game.isAWin(0));
  
  
  
  game.clearBoard();
  System.out.println("---------------NEW GAME--------------");
  System.out.println(game.toString());
  
 }
 
}