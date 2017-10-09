// score 4 + extra credit 1
package INFO5100.Assignment3;

public class Calculator {
	
	/* 5.Create a calculator that can perform the following features. (Total Score 4) 
	 * i. The calculator should be able to perform Addition, subtraction, multiplication, division. (Score 2)
	   ii. Should be able to perform squareRoot, square, cube. (Score 1)
       iii. Should be able to convert ¡®Fahrenheit-Celsius¡¯ , ¡®Feet-Inches¡¯. (Score 1)
	   The calculator should be able to solve a quadratic equation and return the solution as array.
		i. This function should take three arguments.
		ii. For example, if quadratic equation is Ax2 + Bx + C. The function should take A,B,C as arguments
		and return a solution as array.
	 */
	double addition( double a, double b) {
		return a + b;
	}

	double subtraction( double a, double b) {
		return a - b;
	}
	
	double multiplication(double a, double b) {
		return a * b;
	}	
	
	double division(double a, double b) {
		if ( b == 0 ) System.out.println("The dividend should not be zero.");;
		return a / b;
	}
	
	double squareRoot(double x) {
		return Math.sqrt(x);
		
	}
	
	double square(double x) {
		return x * x;
	}
	
	double cube(double x) {
		return x * x * x;
	}

	String FahrenheitToCelsius(double fanhrenheit) {
		return String.format("%.2f", (fanhrenheit - 32) * 5 / 9);
		
	}
	
	String CelsiusToFahrenheit(double celsius) {
		return String.format("%.2f", celsius * 9 / 5 + 32 );
		
	}
	
	double FeetToInches(double feet) {
		return feet * 12;
		
	}
	
	String InchesToFeet(double inch) {
		return String.format("%.2f",inch / 12);
	}
	
	double[] quadratic(double a,double b, double c) { // extra credit 1
		
		if( a == 0 ) { // u should return 1 root if a == 0
			System.out.println("This is a quadratic equation, so the A is not to be zero.");
		}
		
		double e = Math.sqrt(b * b - 4*a*c);
		double[] result= new double[2];
		if(e >= 0) {
			double x1 = ((0-b) + e)/(2*a);
			double x2 = ((0-b) - e)/(2*a);
			result[0] = x1;
			result[1] = x2;
		}else {
			System.out.println("Sorry, there is no solution to this equation.");
			return result; 
			// u have to return null/ empty array. in this case u are returning array that has 0.0 as values
		}

		return result;
	}
	
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		//test add, sub, multi, divi method; 
		double add = cal.addition(5.2,3.2);
		double sub = cal.subtraction(5.2,3.2);
		double multi = cal.multiplication(5.2, 3.2);
		double divi = cal.division(5.2, 3.2);
		System.out.println("Test the method i : " );	
		System.out.println("5.2+3.2 = "+ add+"\n"+ "5.2-3.2 = " +sub +"\n"+ "5.2*3.2 = "+ multi+"\n"+ "5.2/3.2 = "+divi+"\n");
		
		
		//test squareRoot, square, cube  method
		double sroot = cal.squareRoot(9);
		double squre = cal.square(9);
		double cube = cal.cube(9);
		System.out.println("Test the method ii : " );
		System.out.println("squareRoot of 9 = "+ sroot+"\n"+ "square 9 = " +squre+"\n"+ "cube 9 = "+ cube+"\n");		
				
		System.out.println("Test the method iii : " );
		System.out.println("Test the FahrenheitToCelsius method : " );
		double f = 75;
		System.out.println("Fanhrenheit "+f+" to Celsius is: "+cal.FahrenheitToCelsius(f)+"\n");
		System.out.println("Test the CelsiusToFahrenheit method : " );
		double c = 32;
		System.out.println("Celsius "+c+" to Fahrenheit is: "+cal.CelsiusToFahrenheit(c)+"\n");
		
		System.out.println("Test the FeetToInches method : " );
		double feet  = 5;
		System.out.println("Feet "+feet+" to inch is: "+cal.FeetToInches(feet)+"\n");
		
		System.out.println("Test the InchesToFeet method : " );
		double inch  = 13;
		System.out.println("Inch "+inch+" to Feet is: "+cal.InchesToFeet(inch)+"\n");
		
		
		
		//test quadratic equation 
		System.out.print("Test the quadratic method : [" );
		double[] result = cal.quadratic(2, 4, -6);
		for ( double d : result) {
			System.out.print(d +" ");
		}
		System.out.print("]" );
		

	}

}
