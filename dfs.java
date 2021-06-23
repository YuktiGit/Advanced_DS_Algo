import java.util.*;
public class dfs{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      int arr[][]= {{0,1,0,1,0,0,0,0,0,0},{1,0,1,0,1,0,1,1,0,0},{1,0,1,0,0,0,0,0,0,0},
                    {0,1,0,0,0,1,1,1,0,0},{0,1,0,1,0,0,0,0,1,1},{0,1,0,0,1,0,0,1,0,0},
                    {0,1,0,0,1,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0},
                    {0,0,1,0,0,0,0,0,0,0}};
      int len = arr.length;
      System.out.print("1");
      dfs(arr,0);
   }
   
   public static void dfs(int[][] arr,int f){
      int len = arr.length;
         for(int j = 0; j<len; j++){
            if(arr[f][j]==1){
               System.out.print(" "+(j+1));
               arr[j][f]=0;
               for(int k=0; k<len;k++){
                 arr[k][j]=0;
                 arr[k][0]=0;
               }

               dfs(arr,j);
            }
            else
               continue;
         }
      
   }
   
}