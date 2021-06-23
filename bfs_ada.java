import java.util.*;
public class bfs_ada{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      int arr[][]= {{0,1,0,1,0,0,0,0,0,0},{0,1,0,1,0,0,0,0,1,1},{1,0,1,0,1,0,1,1,0,0},
                    {1,0,1,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,0},{0,1,0,0,0,1,1,1,0,0},
                    {0,1,0,0,1,0,0,1,0,0},{0,0,1,0,0,0,0,0,0,0},{0,1,0,0,1,0,1,0,0,0},
                    {0,0,1,0,0,0,0,0,0,0}};
      int len = arr.length;
      System.out.print("1");
      int rep[] = new int[len];
      for(int i=0; i<len;i++){
         for(int j=0; j<len;j++){
            if(arr[i][j]==1){
              System.out.print(" "+(j+1));
              arr[j][i]=0;
              for(int k=i; k<len;k++){
               arr[k][j]=0;
              }
            }
            else{
               continue;
            }
         }
      }
   }
   
}