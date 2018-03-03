/**
 * Starter code for the Maze path finder problem.
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayDeque;

/*
 * Recursive class to represent a position in a path
 */
class Position{
	public int i;     //row
	public int j;     //column
	public char val;  //1, 0, or 'X'
	
	// reference to the previous position (parent) that leads to this position on a path
	Position parent;
	
	Position(int x, int y, char v){
		i=x; j = y; val=v;
	}
	
	Position(int x, int y, char v, Position p){
		i=x; j = y; val=v;
		parent=p;
	}
	
}


public class PathFinder {
	
	public static void main(String[] args) throws IOException {
		if(args.length<1){
			System.err.println("***Usage: java PathFinder maze_file");
			System.exit(-1);
		}
		
		char [][] maze;
		maze = readMaze(args[0]);
		printMaze(maze);
		Position [] path = stackSearch(maze);
		System.out.println("stackSearch Solution:");
		printPath(path);
		printMaze(maze);
		
		char [][] maze2 = readMaze(args[0]);
		path = queueSearch(maze2);
		System.out.println("queueSearch Solution:");
		printPath(path);
		printMaze(maze2);
	}
	
	
	public static Position [] stackSearch(char [] [] maze){
		// todo: your path finding algorithm here using the stack to manage search list
		// your algorithm should mark the path in the maze, and return array of Position 
		// objects coressponding to path, or null if no path found
				
		return null;
	}
	
	public static Position [] queueSearch(char [] [] maze){
		// todo: your path finding algorithm here using the queue to manage search list
		// your algorithm should mark the path in the maze, and return array of Position 
		// objects coressponding to path, or null if no path found
		
		return null;
	}
	
	public static void printPath(Position [] path){
		// todo: print the path to the stdout
	}
	
	/**
	 * Reads maze file in format:
	 * N  -- size of maze
	 * 0 1 0 1 0 1 -- space-separated 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static char [][] readMaze(String filename) throws IOException{
		char [][] maze;
		Scanner scanner;
		try{
			scanner = new Scanner(new FileInputStream(filename));
		}
		catch(IOException ex){
			System.err.println("*** Invalid filename: " + filename);
			return null;
		}
		
		int N = scanner.nextInt();
		scanner.nextLine();
		maze = new char[N][N];
		int i=0;
		while(i < N && scanner.hasNext()){
			String line =  scanner.nextLine();
			String [] tokens = line.split("\\s+");
			int j = 0;
			for (; j< tokens.length; j++){
				maze[i][j] = tokens[j].charAt(0);
			}
			if(j!=N){
				System.err.println("*** Invalid line: " + i + " has wrong # columns: " + j);
				return null;
			}
			i++;
		}
		if(i!=N){
			System.err.println("*** Invalid file: has wrong number of rows: " + i);
			return null;
		}
		return maze;
	}
	
	public static void printMaze(char[][] maze){
		
		if(maze==null || maze[0] == null){
			System.err.println("*** Invalid maze array");
			return;
		}
		
		for(int i=0; i< maze.length; i++){
			for(int j = 0; j< maze[0].length; j++){
				System.out.print(maze[i][j] + " ");	
			}
			System.out.println();
		}
		
		System.out.println();
	}

}

/////stack method
ArrayDeque<Position> steps = new ArrayDeque<Position>();
		Position current = new Position(0,0,'X',null);
		Position[] p;
		boolean[][] mark = new boolean[maze.length][maze[0].length];
		
	    steps.push(current);
	    int x;
	    int y;
		
		while(!steps.isEmpty()){
		current=steps.pop();
		
		x=current.i;
		y=current.j;
		if(x==maze[0].length-1&& y == maze.length - 1){
			break;
		}
       else{
        int px=current.parent!=null?current.parent.i:0;
		int py=current.parent!=null?current.parent.j:0;
				
				if(px != x-1 && x > 0 && maze[y][x-1] == '0' && mark[y][x-1]==false)
				{
					steps.push(new Position(x-1, y, 'X',current));
				}
				 if(px != x+1 && x < maze[0].length - 1 && maze[y][x+1] == '0'&& mark[y][x+1]==false)
				{
					steps.push(new Position(x+1, y, 'X',current));
				}
				 if(py != y-1 && y > 0 && maze[y-1][x] == '0'&& mark[y-1][x]==false)
				{
					steps.push(new Position(x, y-1 ,'X',current));
				}
				 if(py != y+1 && y < maze.length - 1 && maze[y+1][x]== '0'&& mark[y+1][x]==false)
				{
					steps.push(new Position(x, y+1,'X', current));
				}
				 if(steps.peek().i==current.i&&steps.peek().j==current.j){
					 while(!current.parent.equals(steps.peek.parent){
					 current=steps.pop;	
				 }
				 steps.pop;
				
			}
		
		     if(steps.isEmpty())
		     return null;
		

			}
