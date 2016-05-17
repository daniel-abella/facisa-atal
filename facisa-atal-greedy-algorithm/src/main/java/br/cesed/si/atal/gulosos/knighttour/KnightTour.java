package br.cesed.si.atal.gulosos.knighttour;

public class KnightTour {

	  public static void main(String[] args)
	   {
	      final int BOARD_SIZE = Integer.parseInt(args[0]);
	      Board myBoard = new Board (BOARD_SIZE);
	      int x = (int) (myBoard.getSize() * Math.random());
	      int y = (int) (myBoard.getSize() * Math.random());
	      Point location = new Point (x, y);
	      Knight myKnight = new Knight (location, myBoard);
	      while (myKnight.canMove (myBoard))
	         myKnight.move (myBoard);
	      System.out.println (myBoard);
	   }// method main
}
