public class KnapsackoneZero {
	public static void main(String[] args)
	{
		int[] profit = {0,1,2,5,6};
		int[] weight = {0,2,5,6,9};
		int[][] k = new int[5][9];
		int total=8 , n=4;
		for(int i=0;i<=n;i++)
		{
			for(int w=0;w<=total;w++)
			{
				if(i==0||w==0)
					k[i][w]=0;
				else if(weight[i]<=w)
				{
					k[i][w]=Math.max(profit[i]+k[i-1][w-weight[i]],k[i-1][w]);
				}
				else
				{
					k[i][w]=k[i-1][w];
				}
			}
		}
		int i=n,j=total;
		int[] knap = new int[4];
		int lst=3;
		while(i>0 && j>0)
		{
			if(k[i][j]==k[i-1][j])
			{
				knap[lst]=0;
				lst--;
				i--;
			}
			else
			{
				knap[lst]=1;
				lst--;
				j=j-weight[i];
				i--;
				
			}
		}
		int profit1=0;
		int a=65;
		for(int g=0;g<knap.length;g++)
		{
			char c = (char)a;
			profit1=profit1+profit[g+1]*knap[g];
			System.out.println(c+">" + knap[g]);
			a++;
		}
		System.out.println("Total profit = "+profit1);
		
	}

}