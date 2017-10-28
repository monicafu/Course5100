package INFO5100.MidTerm;
import java.util.*;

/* @author: Jing Fu
 * @date : 10/25/2017
 */

public class Extra { // extra credit 10
		
	public ArrayList<Cell> findPath(int[][] maze){
		
		ArrayList<Cell> path = new ArrayList<>();
		Cell cell = new Cell(0, 0);
		//use 2d array to store the available points in the maze
		int[][] solution = new int[maze.length][maze[0].length];
		isPathExist(maze,solution,0,0); 		
		for ( int i = 0; i < solution.length; i++ ) {
			for ( int j = 0; j < solution[0].length; j++ ) {
				if ( solution[i][j] == 1) {
					cell = new Cell(i,j);
					path.add(cell);
				}
			}
		}	
		return path;	
	}
	
	/* 
	 * @param:  maze: the original 2d maze
	 * @param:  solution: the same 2d array to store available points
	 * @param:  current x,y points  
	 * @return : if have a path in the maze
	 */
	private static boolean isPathExist(int[][] maze, int[][] solution,int pointX, int pointY) {
		
		if ( pointX < 0 || pointX >= maze.length || pointY < 0 || pointY >= maze[0].length) {
			return false;
		}
		//the end/exit of the maze
		if ( pointX == maze.length -1 && pointY == maze[0].length -1 ){
			solution[pointX][pointY] = 1;
			return true;
		}
		if ( maze[pointX][pointY] == 1) {
			solution[pointX][pointY] = 1;
			//recursive call: find the forward and down point
			if ( isPathExist(maze, solution, pointX+1, pointY) || isPathExist(maze, solution, pointX, pointY+1)) {
				return true;
			}else {
				solution[pointX][pointY] = 0;
			}
		}else {
			solution[pointX][pointY] = 0;
		}
		return false;
	}
	public static void main(String[] args) {
		
		Extra ex = new Extra();
		int[][] maze = {
				{1, 0, 0, 0},
				{1, 1, 1, 1},
				{0, 1, 0, 0},
				{1, 1, 1, 1}
			  };
		ArrayList<Cell> res = ex.findPath(maze);
		System.out.print("[ ");
		for ( Cell cell : res) {
			System.out.print(cell+",");
		}
		System.out.println(" ]");
	}

}
