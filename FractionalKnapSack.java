import java.util.*;
import java.text.*;

public class FractionalKnapSack {
	private static double getMaxValue(float[] w, float[] v,float cap){
      double max = 0;
      int n = w.length;
      float temp;
      float array[] = new float[n];
      for(int i = 0; i<n;i++){
         array[i] = v[i]/w[i];
      }
      for(int i = 0; i<n; i++){
         for(int j =0; j<n-1 ; j++){
            if(array[j]<array[j+1]){
               temp = array[j];
               array[j] = array[j+1];
               array[j+1] = temp;
               temp = w[j];
               w[j] = w[j+1];
               w[j+1] = temp;
               temp = v[j];
               v[j] = v[j+1];
               v[j+1] = temp;
            }
         }
      }
      float arr[] = new float[n];
      int i = 0;
      while(cap>0){
         if(w[i]<=cap){
            cap = cap - w[i];
            arr[i] = w[i];
            max = max + v[i];
         }
         else if(w[i]>cap && cap!=0){
            arr[i] = cap;
            max = max + array[i]*cap;
            cap = 0;
         }
         i++;
      }
      DecimalFormat df = new DecimalFormat("##0.000");
      System.out.println("Value    Weight    vue/weight    xi        Profit");
      for(i=0; i<n ; i++){
         if(array[i] < 10){
            System.out.println(v[i]+"    "+w[i]+"      "+df.format(array[i])+"           "+df.format(arr[i]/w[i])+"     "+(array[i]*arr[i]));
         }
         if(array[i] >= 10){
            System.out.println(v[i]+"    "+w[i]+"      "+df.format(array[i])+"          "+df.format(arr[i]/w[i])+"     "+(array[i]*arr[i]));
         }
      }
		return max;
	}
	public static void main(String[] args)
	{
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the number of values :  ");
      int n = sc.nextInt();
		float[] w = new float[n];
		float[] v = new float[n];
      Random rand = new Random();
      for( int i = 0; i<n ; i++){
         v[i] = rand.nextInt(1000-100) + 100;
      }
      for( int i = 0; i<n ; i++){
         w[i] = rand.nextInt(100-10)+10;
      }
		float cap;
      System.out.print("Enter the capacity :  ");
      cap = sc.nextFloat();
      
		double maxValue = getMaxValue(w, v, cap);
		System.out.println("Maximum value = "+ maxValue);
	}
}