package INFO5100.Assignment7;
import java.util.*;
public class PascalTriangle {
	
	  public static void printPascalTriangle(int n){ // score 2
	        if ( n <= 0 ) return;
	        ArrayList<Integer> pre = new ArrayList<>();
	        pre.add(1);
	        System.out.println(pre);
	        for (int i = 2; i <= n; i++) {
	        		ArrayList<Integer> cur = new ArrayList<>();
	        		cur.add(1);
	        		for ( int j = 0; j < pre.size()-1; j++) {
	        			cur.add(pre.get(j)+pre.get(j+1));
	        		}
	        		cur.add(1);
	        		System.out.println(cur);
	        		pre = cur;
	        }
	        
	  }

	public static void main(String[] args) {		
		printPascalTriangle(10);
	}

}
