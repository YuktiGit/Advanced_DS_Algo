import java.util.*;

public class QueenProb {
   class Position{
      int row, col;
      Position(int row, int col){
      this.row = row;
      this.col = col;
      }
   }
   
   public Position[] solvedProb(int n){
      Position[] position = new Position[n];
      boolean s = recSolvedProb(n,0,position);
      if(s){
         return position;
      }
      else{
         return new Position[0];
      }
   }
   
   boolean recSolvedProb(int n, int row, Position[] position){
      if(n == row){
         return true;
      }
      int col;
      for(col=0; col<n;col++){
         boolean c = true;
         
         for(int q=0; q<row; q++){
            if(position[q].col == col || position[q].row-position[q].col == row-col || position[q].row + position[q].col == row+col){
               c = false;
               break;
            }
         }
         
          if (c) {
                position[row] = new Position(row, col);
                if (recSolvedProb(n, row + 1, position)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String args[]) {
        QueenProb s = new QueenProb();
        Position[] positions = s.solvedProb(4);
        Arrays.stream(positions).forEach(position -> System.out.println("Q"+position.row + " --> " + position.col));
    }
}