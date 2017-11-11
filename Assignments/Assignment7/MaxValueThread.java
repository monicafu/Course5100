package INFO5100.Assignment7;

import java.util.Arrays;
import java.util.Random;

public class MaxValueThread extends Thread{
	private int lo;
	private int hi;
	private int[] arr;
	private int max;
	
	private MaxValueThread(int[] arr,int lo, int hi) {
		this.arr = arr;
		this.lo = lo;
		this.hi = hi;
	}
	
	@Override 
	public void run() {
		for (int i = lo; i < hi-1; i++ ) {
			for ( int j = i+1; j < hi; j++) {
				if ( arr[j] > arr[i]) {					
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;				
				}
			}
		}		
		max = arr[lo];
	}
	/*** 
	 * find the maxValue using 4 Threads
	 * @param: input a arr to find the max Value
	 * @return: max value of the arr
	 * */
	public static int findMax(int[] arr) throws InterruptedException{
		int len = arr.length;
		int[] max = new int[4];
		MaxValueThread[] mt = new MaxValueThread[4];
		for (int i = 0; i < 4; i++) {
			mt[i] = new MaxValueThread(arr, (i * len) / 4, ((i + 1) * len / 4));	
			mt[i].start();
		}
		
		for (int i = 0; i < 4; i++ ) {
			mt[i].join();
			max[i] = mt[i].max;
			System.out.println("MaxValueThread ["+i+"]:"+max[i]);
		}
		Arrays.sort(max);
		return max[max.length-1];
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		int[] test = new int[8];
		System.out.print("The test array is: ");
		for (int i = 0; i < test.length; i++) {
			 test[i] = (int) (Math.random() * 100);
			 System.out.print(test[i]+",");
		}
		System.out.println();
		System.out.println("The max value of the test array is: "+findMax(test));
	}
}
