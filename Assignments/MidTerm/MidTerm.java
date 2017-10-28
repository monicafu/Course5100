package INFO5100.MidTerm;

/* @author: Jing Fu
 * @date : 10/25/2017
 */
public class MidTerm {
	
	/* 1. reverseEvenIndices 
	 * @param nums: input a int[] array 
	 * @return : reversed even index number of the array
	 */
	public int[] reverseEvenIndices(int[] nums){ // score 6
		int low = 0, high = 0;
		if ( nums.length % 2 == 0) {
			high = nums.length -2;
		}else {
			high = nums.length -1;
		}
		while ( low <= high ) {
			if( low % 2 == 0 && high % 2 == 0 ) {
				reverse(nums,low,high);
			}
			low ++;
			high--;
		}
		return nums;
	}
	
	private void reverse(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/* 2.formed full staircase coins  
	 * @param: the number of coins
	 * @return: full staircase rows that can be formed
	 */
	public int arrangeCoins(int n){ // score 7
		return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);		
	}
	
	
	/* 3. find the minimum number of moves required to make all array elements equal
	 * param: input non- empty a int[] array
	 * return: minimum moves to make every elements equal in array
	 */
    public int minMoves(int[] nums) {  // score 7
	    if ( nums.length == 0)  return 0;
	    int minNum = nums[0];
	    int sum = 0;
	    for (int n: nums){
	         minNum =Math.min(minNum,n);
	         sum += n;
	    }
	    return (sum - minNum * nums.length);     
    }
	
	
	/* 4.possible ways to throw a dice in sum to X
	 * @param: n:dices; faces: m; sum of all dices: x
	 * @return: possible ways
	 * time O(m*n*x)
	 */
    public int countNumberOfPossibleWays(int m, int n, int x){ // score 10
    		//when sum is low (< min value) or high( > max value) exit
    		if ( x < m || x > n*m ) return -1;
    		
    		//use a 2D array to store the numbers of ways
    		//row index is number of dice
    		//column index is sum
    		int[][] dp = new int[n+1][x+1];
    		//set the init of dp table 
    		for ( int i = 1; i <= m && i <= x; i++ ) {
    			dp[1][i] = 1;
    		}
    		for ( int d = 2; d <= n ; d++ ) {
    			for ( int s = 1; s <= x; s++ ) {
    				for ( int f = 1; f <= m && f <= s; f++ ) {
    					dp[d][s] += dp[d-1][s-f];
    				}
    			}
    		}
    		return dp[n][x];
    }

	public static void main(String[] args) {
		//The test cases of question1:reverseEvenIndices
		MidTerm mid = new MidTerm();
		int[] input1 = {9, 4, 8, 7, 5, 1, 3};
		int[] input2 = {6, 4, 1, 0, 3, 2};
		int[] input3 = {1,2,3};
		mid.reverseEvenIndices(input2);
		System.out.print("reverseEvenIndices output: {");
		for (int item : input2) {
			System.out.print(item+", ");
		}
		System.out.print("}\n");
		System.out.println("---------------------------------------------------");
		
		//The test cases of question2:
		System.out.println("8 coins can form  "+mid.arrangeCoins(8)+" full stairs");
		System.out.println("5 coins can form  "+mid.arrangeCoins(5)+" full stairs");
		System.out.println("---------------------------------------------------");
		//The test cases of question3:
		int[] arr = {1,2,3};
		System.out.println("The minmum moves is : "+mid.minMoves(arr));
		System.out.println("---------------------------------------------------");
		//The test cases of question4:
		System.out.println("The number of ways is : "+mid.countNumberOfPossibleWays(6,2,8));
		
		
	}

}
