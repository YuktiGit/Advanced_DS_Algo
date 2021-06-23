import java.util.*;
import java.time.*;
import java.util.Arrays;
class QuickSorts{
    static int count = 0;
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);

         int[] a = new int[10000];
         Random rand = new Random();
         
         for( int i = 0; i<10000 ; i++){
            a[i] = rand.nextInt(10000);
         }
         
         int[] a1 = new int[10000];
         
         for(int i = 0; i<a.length ; i++){
            a1[i] = a[i];
         };
         
         Arrays.sort(a1);
         
         int[] a3 = new int[10000];
         
         for(int i = 0; i<a.length ; i++){
            a3[i] = 67;
         }
         
         for(int i = 0; i<a.length ; i++){
            System.out.print(a3[i]+" ");
         }
         
         System.out.println();
         count = 0;
         
         Instant start3 = Instant.now();
         quickSort(a3,0,a3.length-1);
         Instant end3 = Instant.now();
         
         System.out.println(Duration.between(start3, end3));
         System.out.println(count);
         
         for(int i = 0; i<a.length ; i++){
            System.out.print(a[i]+" ");
         }
         
         System.out.println();
         
         Instant start = Instant.now();
         quickSort(a,0,a.length-1);
         Instant end = Instant.now();
         
         System.out.println(Duration.between(start, end));
         System.out.println(count);
         
         int[] a2 = new int[10000];
         System.out.println(count);
         
         for(int i = 0; i<a.length ; i++){
            a2[i] = a[10000-i-1];
         }
         
         for(int i = 0; i<a.length ; i++){
            System.out.print(a2[i]+" ");
         }
         
         System.out.println();
         count = 0;
         
         Instant start2 = Instant.now();
         quickSort(a2,0,a2.length-1);
         Instant end2 = Instant.now();
         
         System.out.println(Duration.between(start2, end2));
         System.out.println(count);
         
         for(int i = 0; i<a.length ; i++){
            System.out.print(a1[i]+" ");
         }
         
         System.out.println();
         count = 0;
         
         Instant start1 = Instant.now();
         quickSort(a1,0,a1.length-1);
         Instant end1 = Instant.now();
         
         System.out.println(Duration.between(start1, end1));

   } 
   
    public static void quickSort(int []a,int bg,int end){
       if(bg<end){
           int n = partition(a,bg,end);
           quickSort(a,bg,n-1);
           quickSort(a,n+1,end);  
       } 
       count++;  
    }
    
    public static int partition(int a[], int bg, int end){
       int l = bg;
       int r = end;
       int flag = 0;
       while(flag==0){
           while(a[l]<=a[r] && l!=r){
               r=r-1;
           }
           if(l==r){ 
               flag=1;
           }
           else if(a[l]>a[r]){
               int temp = a[l];
               a[l] = a[r];
               a[r] = temp;
               l=r;
           }
           if(flag == 0){
               while(a[l] >= a[bg] && l != bg){
                   bg = bg +1;
               }
               if(l == 1){
                   flag = 1;
               }
               else if(a[l]<a[bg]){
                   int temp = a[l];
                   a[l] = a[bg];
                   a[bg] = temp;
                   l=bg;
               }
           }
       }
       return l;
    }
}