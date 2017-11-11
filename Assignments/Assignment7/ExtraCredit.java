package INFO5100.Assignment7;

import java.util.Arrays;

public class ExtraCredit {
	
	  public static boolean findPartition (int arr[]) {
	      int sum = 0;
	      if (arr.length < 0) return false;
	      for (int num : arr) {
	    	  	 sum += num;
	      }
	      
	      if ( sum % 2 == 1) return false;
	      sum /= 2;
	      boolean[] dp = new boolean[sum+1];
	      Arrays.fill(dp, false);
	      dp[0] = true;
	      
	    	  for( int i = 0; i < arr.length; i++ ) {
	    	  	for (int j = sum; j >= arr[i]; j--) {
	    	  			if(j-arr[i] >= 0)
	    	  				dp[j] = dp[j] || dp[j-arr[i]];
	    	  		}
	    	  }
	      return dp[sum];
	  }

	public static void main(String[] args) {
		int[] test1 = {1,5,11,5};
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
