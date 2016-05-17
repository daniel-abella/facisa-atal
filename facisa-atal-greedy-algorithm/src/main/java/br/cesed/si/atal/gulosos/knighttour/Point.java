package br.cesed.si.atal.gulosos.knighttour;

public class Point
{
   //===========================================================
   // Supports actions on squares in the board.
   //===========================================================
   private int x, y;

   Point ()
   {}

   Point (int x, int y)
   {
      this.x = x;
      this.y = y;
   }// method Point

   Point (Point P)
   {
      x = P.x;
      y = P.y;
   }// method Point

   int getX()
   {return x;}

   int getY()
   {return y;}

   Point translate (int[] by)
   {return new Point (x + by[0], y + by[1]);}

   boolean inBoard (Board myBoard) // checks if point lies within the board
   {return 0 <= x & x < myBoard.getSize() & 0 <= y & y < myBoard.getSize();}

   boolean visited (Board myBoard) // checks if point has been visited earlier
   {return myBoard.getTimeOfVisit(x, y) != 0;}

   // Counts number of moves a knight could make from this point given
   // current board situation.
   int numberOfExits (Knight myKnight, Board myBoard)
   {
      int result = 0;
      for (int i=0; i < myKnight.getSteps().length; i++)
      {
         Point next = translate (myKnight.getSteps()[i]);
         if (next.inBoard (myBoard) && !next.visited (myBoard))
            result++;
      }
      return result;
   }// method numberOfExits
}// class Point