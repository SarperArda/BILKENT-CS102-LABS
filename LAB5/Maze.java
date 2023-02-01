//********************************************************************
//  Maze.java       Author: Lewis/Loftus
//
//  Represents a maze of characters. The goal is to get from the
//  top left corner to the bottom right, following a path of 1s.
//********************************************************************

import java.util.ArrayList;

public class Maze
{


   private int[][] grid = { {1, 1, 1, 1, 1, 1},
                            {0, 1, 1, 1, 1, 1},
                            {0, 1, 0, 0, 0, 0},
                            {1, 0, 0, 1, 0, 1}};


   //-----------------------------------------------------------------
   //  Attempts to recursively traverse the maze. Inserts special
   //  characters indicating locations that have been tried and that
   //  eventually become part of the solution.
   //-----------------------------------------------------------------
   public boolean traverse (int row, int column)
   {
      boolean done = false;

      
      if (valid (row, column))
      {

         if (row == grid.length-1 && column == grid[grid.length-1].length-1)
            done = true;

         if(row + 1 < grid.length && column + 1 < grid[0].length) {

            if (grid[row + 1][column] == 1) {
               done = traverse(row + 1, column);

            } else if (grid[row][column + 1] == 1) {
               done = traverse(row, column + 1);

            }

         }
         if(row == grid.length -1 && column != grid[0].length-1){
            if (row == 4 && column == 5) {
               return true;

            }
               if (grid[row][column + 1] == 1) {
                  done = traverse(row, column + 1);
               }
               else{
                  int m = row;
                  int n = column + 1;
                  while (n < grid[0].length && n != grid[0].length - 1) {
                     if (grid[m][n] == 1) {
                        traverse(m,n);
                     }
                     n++;
               }

            }
         }
         else {
            int x = row;
            int i = column;
            ArrayList<Integer> portal;
            portal = portal(x,i);
            row = portal.get(0);
            column = portal.get(1);
            traverse(row,column);

         }
         }



      
      return done;
   }
   
   //-----------------------------------------------------------------
   //  Determines if a specific location is valid.
   //-----------------------------------------------------------------
   private boolean valid (int row, int column)
   {
      boolean result = false;
 
      // check if cell is in the bounds of the matrix
      if (row >= 0 && row < grid.length &&
          column >= 0 && column < grid[row].length)

         //  check if cell is not blocked and not previously tried
         if (grid[row][column] == 1)
            result = true;

      return result;
   }

   //-----------------------------------------------------------------
   //  Returns the maze as a string.
   //-----------------------------------------------------------------
   public String toString ()
   {
      String result = "\n";

      for (int row=0; row < grid.length; row++)
      {
         for (int column=0; column < grid[row].length; column++)
            result += grid[row][column] + "";
         result += "\n";
      }

      return result;
   }

   public ArrayList<Integer> portal(int row, int column){
         boolean done = false;
         ArrayList<Integer> portal = new ArrayList<>();
         int x = row;
         int i = column + 1;
         while (i < grid[0].length && i != grid[0].length - 1) {
            if (grid[x][i] == 1) {
               column = i;
               done = true;
               portal.add(x);
               portal.add(i);
               return portal;


            }
            i++;
         }

      while(!done) {
         for (x = row + 1; x < grid.length; x++) {
            for (i = 0; i< grid[0].length; i++){
               if (grid[x][i] == 1) {
                  row = x;
                  column = i;
                  done = true;
                  portal.add(x);
                  portal.add(i);
                  return portal;

               }
            }
         }
      }
      portal.add(x);
      portal.add(i);
      return portal;
   }

}
