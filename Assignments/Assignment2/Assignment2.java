package INFO5100.Assignment2;
import java.util.ArrayList;
public class Assignment2 {
	
   /*  1. Write a java function to calculate the salary of an employee based on the following rules.
	*  i. function takes input of number of hours an employee worked and returns the salary.
	*  ii.  The first 36 hours worked are paid at a rate of 15.0, then the next 5 hours are paid at a rate of 15 * 1.5. 
	*  Hours after that up to a max of 48 are paid at a rate of 15 * 2.
    	*/
	
	public double employeeSalary( double hours ){
		double base = 15.0, salary = 0.0;
		double[] rate = {1.0,1.5,2.0};
		double MAX_HOUR = 48.0;
		if(hours > 0 && hours <= 36.0) {
			salary = base * rate[0] * hours;
		}else if(hours > 36.0 && hours <= 41.0) {
			salary = base * rate[1] * hours;
		}else if( hours >41.0 && hours <=48.0) {
			salary = base * rate[2] * hours;
		}else {
			salary = base * rate[2] * MAX_HOUR;
		}
		return salary;
	}
	
	
	/*  2. Write a java function that adds all the digits of an integer until it is single digit.
	 *  i. function takes an integer as input and returns its sum of digits.
	 *	ii. for example input = 37, sum = 3+7 = 10, sum = 1+0 = 1. result = 1.
	 * */
	public int addDigits( int input ){
		if (input >= 0 && input < 10)
			return input;
		int sum = 0;
		while (input != 0) {
			int tail = input % 10;
			sum = sum + tail;
			input = input / 10;
		}
		return addDigits(sum);
	}
	
	/*  3. Write a java function to print all perfect number between 1 and n.
	 *  i. Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
	 *  ii. For example: 6 is the first perfect number, Proper divisors of 6 are 1, 2, 3. 
	 *	Sum of its proper divisors = 1 + 2 + 3 = 6.
	 * */
	
	public void printPerfectNumbers( int n ){
		ArrayList<Integer> number = new ArrayList<Integer>();
		if (n == 1)  return;
		int sum = 0;
		for (int j = 2; j <= n; j++) {
			sum = 0;//when number is changed, sum must be 0;
			for (int i = 2; i < Math.sqrt(j); i++) {
				if (j % i == 0) {
					sum += j / i + i;
				}
			}
			if (sum + 1 == j)
				number.add(j);
		}
	
		if (number.isEmpty()) {
			System.out.println("Sorry, between 1 and " + n + " cannot find PerfectNumber");
		} else {
			System.out.println("The PerfectNumber between 1 and " + n + " are :" );
			for(Integer m : number) {
				System.out.println(m);
			}
		}
	}

	

	
	/*6. Write a Java program that generates an isosceles right angled triangle made of asterisks. 
	 * i. function should take input of one equal side as integer.
	 *  Other than the edges the inner part of the triangle should be empty.
	 * ii. For example input is 6. the function should print
	*/
	
	public void printIsoscelesTriangle( int n ){
		for(int i= 0 ; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if ( j == 0 || i == n-1 ) { //print the spaces or asterisks
					System.out.print("*");
				}else {
					System.out.print(" ");//use print not println
				}
			}
			System.out.println("*");//print the last asterisks of every line
		}
	}

	

	public static void main(String[] args) {
		Assignment2 assignment = new Assignment2();
		//1. employeeSalary
		System.out.println("1. Test employeeSalary method: ");
		double hours = 50;
		System.out.println("The salary should be 1440: "+ assignment.employeeSalary(hours));
		System.out.println();
		//2. addDigits
		System.out.println("2. Test addDigits method: ");
		int input = 371;
		System.out.println("The sum of every digits should be 2: "+ assignment.addDigits(input));
		System.out.println();
		
		//3. printPerfectNumbers
		System.out.println("3. Test printPerfectNumbers method: ");
		int number = 10000 ;
		assignment.printPerfectNumbers(number);
		System.out.println();
		
		//6. print isosceles right angled triangle
		System.out.println("4. Test print isosceles right angled triangle: ");
		assignment.printIsoscelesTriangle(6);
		
	}

}
