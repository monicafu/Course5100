package INFO5100.Assignment5;
import java.util.*;
public class SpiralMatrix {
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	    //space O(n)
        List<Integer> res = new ArrayList<Integer>();
        if( matrix == null ) return res;
        int startRow = 0, startColumn = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        
        //time O(n^2)
        //tranverse the outter edge     
        while( startRow < row && startColumn < column){
             //go right, next square's up start at x+1
            for( int i = startColumn; i <= column-1; i++ ){
                res.add(matrix[startRow][i]);
            }
            startRow++;
            //go down, next square's right edge coordinate y-1
            for( int i = startRow; i <= row-1; i++){
                res.add(matrix[i][column-1]);
            }
            column--;
            //go left,next square's down edge coordinate x-1
            if( startRow < row){
              for( int i = column-1; i >= startColumn; i--){
                  res.add(matrix[row-1][i]);
              }  
            }
            row--;
            //go up, next square's left edge coordinate y+1
            if( startColumn < column){
                for( int i = row-1; i >= startRow; i--){
                    res.add(matrix[i][startColumn]);
                }
            }
            startColumn++;
        }
       return res;        
    }


	public static void main(String[] args) {
		int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[][] b = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		SpiralMatrix sm = new SpiralMatrix();
		System.out.println(sm.spiralOrder(a));
		System.out.println(sm.spiralOrder(b));
	}

}
