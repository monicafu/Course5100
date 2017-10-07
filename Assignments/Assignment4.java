package INFO5100.Assignment4;

public class Assignment4 {
	
	
	
	/* Question 1:
	 * input a string and format it in a group, which each group be length of K;
	 * the string should be split into X part with dash, each part have K characters;
	 * output is the formatted string;
	 * lower cases must be converted to upper case.
	 * */
	
     // input = "2-4A0r7-4k"   K=4   
	//  output= "24A0-R74K"    
	
	// input ="2-4A0r7-4k"   K=3
	// output ="24-A0R-74K"
	public String formatString(String str, int k) {
		
		if (str.isEmpty() || k < 0)  return "";
		StringBuilder result;// store the result String
		//to upperCase
		//upperCase:65--90; lowCase: 97--122   
		char[] ch = str.toCharArray();
		for (int i = 0; i<str.length(); i++) {
			if( ((int)ch[i] > 96 ) && ((int)ch[i]< 123 ) ) {
				ch[i] = (char) ((int)ch[i]- 32);
			}
		}
		//System.out.println(new String(ch));
				
		//Get a new String without dashes
		result = new StringBuilder();
		for ( int i = 0; i< ch.length; i++) {
			if( ch[i] !='-')
				result.append(ch[i]);	
		}
		//System.out.println("the length of new no-dash String is :"+result.length());
			
		int len = result.toString().length();
		//Split the new String, accroding to the K
		// insert '-' from back at every K position
		for( int i = k; i<len; i = i+k) {
			result.insert(len-i, '-');			
		}		
		return new String(result);
	}
	
	/* Question 5:Given an integer, convert it to a roman numeral. 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 * */
	public String intToRoman(int num) {
		//this two arrays's value are related to each other
		String[] roman= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int[] intValue= {1000,900, 500,400,100, 90,  50, 40,  10, 9,   5,   4,  1};
		StringBuilder sb = new StringBuilder();
		
		if( num < 1 || num > 3999 ) return null;
		int i = 0;
		while(num > 0) {
			if ( num-intValue[i] >= 0) {
				sb.append(roman[i]);
				num = num- intValue[i];
			}else
				i++;
		}
		return sb.toString();
		
	}
	/* Extra:
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
	 * Find the median of the  two sorted arrays
	 * */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int i = 0, j = 0, k = 0;
		int[] temp = new int[nums1.length+nums2.length];
		//The null situations
		if(nums1.length == 0 && nums2.length ==0) return 0;
		
		//One of them are null
		if( nums1.length ==1 && nums2.length !=0 ) {
			if (nums2.length % 2 == 0)
				return medianOfevenArrays(nums2);
			else 
				return medianOfOddArrays(nums2);
		}
		
		if(nums2.length==0 && nums1.length !=0) {
			if( nums1.length % 2 == 0) 
				return medianOfevenArrays(nums1);
			else
				return medianOfOddArrays(nums1);
		}
		
		//Both are not null, merge the two arrays
		while ( i <= nums1.length-1 && j <= nums2.length-1) {
			if( nums1[i] < nums2[j]) {
				temp[k++] = nums1[i++];
			}else {
				temp[k++] = nums2[j++];
			}
		}
		
		while( i <= nums1.length-1) {
			temp[k++] = nums1[i++];
		}
		while( j <= nums2.length-1) {
			temp[k++] = nums2[j++];
		}
		//Find median of the merged array--temp
		if(temp.length % 2 ==0)
			return medianOfevenArrays(temp);
		else 
			return medianOfOddArrays(temp);
		
		
	}
	
	public static double medianOfOddArrays(int[] arr) {
		return (double) arr[arr.length/2]; 
				
	}
	public static double medianOfevenArrays(int[] arr) {
		return (double) (arr[arr.length/2-1]+arr[arr.length/2])/2;
	}
	

	public static void main(String[] args) {
		Assignment4 a4 = new Assignment4();
		//Q1.Test cases  of the formatString
		String test1= "2-4A0r7-4k" ,test2="26-5gba-7fjnb";
		String res1 = a4.formatString(test1,4);
		String res2 = a4.formatString(test1,3);
		String res3 = a4.formatString(test2,3);
		System.out.println("When K =4, the formatted "+test1+" String should be 24A0-R74K: "+res1);		
		System.out.println("When K =3, the formatted "+test1+" String should be 24-A0R-74K: "+res2);
		System.out.println("When K =3, the formatted "+test2+" String should be 26-5GB-A7F-JNB: "+res3);
		System.out.println();
		
		//Q5.Test case of intToRoman
		int testInt = 500;
		System.out.println("The number "+testInt+" transfer to Roman is "+"D: "+a4.intToRoman(testInt));	
		int testInt2 = 143;
		System.out.println("The number "+testInt2+" transfer to Roman is CXLIII"+": "+a4.intToRoman(testInt2));	
		System.out.println();
		
		//Extra: Test find Median of Sorted Arrays
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		System.out.println("The median should be 2.0: " + a4.findMedianSortedArrays(nums1, nums2));
		int[] nums3 = {1,2};
		int[] nums4 = {3,4};
		System.out.println("The median should be 2.5: " + a4.findMedianSortedArrays(nums3, nums4));
		
	}

}
