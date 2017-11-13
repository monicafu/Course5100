package INFO5100.Assignment7;

import java.util.Arrays;

public class ExtraCredit {
	
	  public static boolean findPartition (int arr[]) {
	      int sum = 0;
	      int n = arr.length;
	      if (n < 0) return false;
	      for (int num : arr) {
	    	  sum += num;
	      }
	      
	      if ( sum % 2 == 1) return false;
	      sum /= 2;
	      boolean[][] dp = new boolean[sum+1][n+1];
	      //when sum = 0
	      for(int i = 0; i <= n; i++) {
	    	  	dp[0][i] = true;
	    	}
		  
	      for(int i = 1; i <= sum; i++) {
	    	  for(int j = 1; j <= n; j++) {
	    	  	if( i - arr[j-1] >=0 && i - arr[j-1] <=sum && dp[i-arr[j-1]][j-1]) {
	    	  		dp[i][j] = true;
	    	  	}else {
	    	  		dp[i][j] = dp[i][j-1];
	    	  	}
	    	  }
	      }
	      return dp[sum][n];
	  }

	public static void main(String[] args) {
		int[] test1 = {-1,5,11,5};
		int[] test2 = {3,3,3,4,5};
		int[] test3 = {1,10,21,5,14,9};
		int[] test4 = {1,2,5};
		System.out.print(Arrays.toString(test1));
		System.out.println(" can arr be partition? "+findPartition(test1));
		
		System.out.println("---------------------------------");
		System.out.print(Arrays.toString(test2));
		System.out.println(" can arr be partition? "+findPartition(test2));
		
		System.out.println("---------------------------------");
		System.out.print(Arrays.toString(test3));
		System.out.println(" can arr be partition? "+findPartition(test3));
		
		System.out.println("---------------------------------");
		System.out.print(Arrays.toString(test4));
		System.out.println(" can arr be partition? "+findPartition(test4));
	}

}
