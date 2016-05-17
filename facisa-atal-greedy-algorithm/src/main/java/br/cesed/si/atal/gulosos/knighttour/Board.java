package br.cesed.si.atal.gulosos.knighttour;
class Board
{
   //===========================================================
   // Supports a few actions on the board.
   //===========================================================
   private final int SIZE;
   private int[][] timeOfVisit;
   private int numberOfVisitedPoints;
   
   Board (int BOARD_SIZE)
   {
      SIZE = BOARD_SIZE;
      timeOfVisit = new int [SIZE] [SIZE];
      for (int i=0; i < SIZE; i++)     // superfluous
         for (int j=0; j < SIZE; j++)
            timeOfVisit [i][j] = 0;
      numberOfVisitedPoints = 0;
   }// method Board

   int getSize()
   {return SIZE;}

   int getTimeOfVisit (int x, int y)
   {return timeOfVisit[x][y];}

   void placeKnight (Point P) // change board information as knight moves
   {
      numberOfVisitedPoints++;
      timeOfVisit [P.getX()] [P.getY()] = numberOfVisitedPoints;
   }// method placeKnight

   public String toString()
   {
      String result = "";
      for (int row=SIZE-1; row >= 0; row--)
      {
         for (int col=0; col < SIZE; col++)
         {
            if (timeOfVisit [col][row] < 10)
               result += " ";
            result += timeOfVisit [col][row] + " ";
         }
         result += "\n";
      }
      return result;
   }// method toString
}// class Board
