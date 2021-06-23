import java.util.*;
class PrimsAlgo{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);

      int arr[][] = {{100,4,8,100,100,100,100},{8,9,100,2,100,1,100},{100,8,2,100,7,9,100},{4,100,9,8,10,100,100},{100,100,1,9,5,100,2},{100,10,100,7,100,5,6},{100,100,100,100,6,2,100}};
      prim(arr);
   }
   public static void prim(int[][] arr){
      int r = arr.length;
      int total = 0;
      int[] index = new int[r];
      int[] parent = new int[r];
      parent[0] = 100;
      index[0] = r-1;
      for(int i = 1; i<r ; i++){
         index[i] = r+1;
      }
      for(int l = 0; l<r ; l++){
            arr[l][r-1] = 100;
      }
      int[] a = new int[3];
      int minimum;
      for(int j = 1; j<r ; j++){
         a[0] = 100;
         for(int i : index){

            if(i<r){
               a = min(arr[i],i,a);
               minimum = a[0];  
            }
         }
         index[j] = a[1];
         parent[j] = a[2];
         arr[a[2]][a[1]] = 100;
         arr[a[1]][a[2]] = 100;
         for(int l = 0; l<r ; l++){
            arr[l][a[1]] = 100;
         }
         total = total + a[0];
      }
      
      System.out.println("Vertices     Parent");
      System.out.println((char)(index[0]+97)+"            --");
      for(int i = 1; i<r ; i++){
         System.out.println((char)(97+index[i])+"            "+(char)(parent[i]+97));
      }
      System.out.println("Total Cost :  "+total);
   }
   public static int[] min(int arr1[], int k, int[] a){
      int mini[] = a;
      for(int i =0; i<arr1.length ; i++){
         if(arr1[i]<mini[0]){
            mini[0] = arr1[i];
            mini[1] = i;
            mini[2] = k;
         }
      }
      return mini;
   }
}