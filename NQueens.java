	/*

      THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING

      CODE WRITTEN BY OTHER STUDENTS. Zihan_Wang (Zahara)

      */
	
import java.util.Stack;
	/*Pseudocode from Dr.Paul Oser at Oxford College: Create empty stack and set current position to 0

	Repeat {

	   loop from current position to the last position until valid position found //current row

	   if there is a valid position {
	      push the position to stack, set current position to 0 // move to next row
	   }

	   if there is no valid position {
	      if stack is empty, break // stop search
	      else pop stack, set current position to next position // backtrack to previous row
	   }

	   if stack has size N { // a solution is found
	      pop stack, set current position to next position // backtrack to find next solution
	   }

	}*/

	public class NQueens {
	
		static int x=0;//row
		static int y=0;//column
	 
	 static Stack<Integer> chess = new Stack<Integer>();
	 static int solutionNum=0;
	
	 
	 public static boolean isValid(Stack<Integer> pchess){
		 for (int i = 0; i < pchess.size(); i++) {
	          if (pchess.get(i) == y){
	              return false;
	          }
	          if (Math.abs((pchess.get(i) - y)) == (pchess.size() - i)){
	              return false;   
	          }
		 }
		 return true;
	 }
	 
 public static int solve(int n) {
	 if(n==1){
		 System.out.println("Q");
		 return 1; 
	 }
		  
	while(x<n&&y<n){
	  if(isValid(chess)){
		 chess.push(y);
		 //stack size=n, one solution, go back to last row; y from y+1;
		 if(chess.size()>=n){
			printSolution(chess);
			solutionNum++;
			x--;
			//pop out the one on the nth row, and then go back to the n-1 row
			chess.pop();
			y=chess.pop();
			//if no valid position in this col, go back to last row;
			if(y==n-1){
				//last index of the first row: no more solutions
			   if(chess.size()==0)
			     break;
			   x--;
               y=chess.pop();
            }
		    y++;
			continue;
	       }
		 //go to next row
		   x++;
	       y=-1;
	      
	   }	    
	  //no available positions for such row
	   else if(y==n-1){
		   //no more available solutions
		     if(chess.size()==0)
			  break;
		     else{
			  y=chess.pop();
			  x--; 
			   if(y==n-1){
				 if(chess.size()==0)
					break;
				y=chess.pop();
				x--;
		      }    
	          y++;
	          continue; 
	      }//else
		     
       } //if else	
	  y++;
	 } //while 
	 return solutionNum;
	    
   }//solve()
	  
	  //this method prints out a solution from the current stack
	  //(you should not need to modify this method)
	  private static void printSolution(Stack<Integer> s) {
	    for (int i = 0; i < s.size(); i ++) {
	      for (int j = 0; j < s.size(); j ++) {
	        if (j == s.get(i))
	          System.out.print("Q ");
	        else
	          System.out.print("* ");
	      }//for
	      System.out.println();
	    }//for
	    System.out.println();  
	  }//printSolution()
	  
	  // ----- the main method -----
	  // (you shouldn't need to change this method)
	  public static void main(String[] args) {
	  
	  int n = 8;
	  
	  // pass in parameter n from command line
	  if (args.length == 1) {
	    n = Integer.parseInt(args[0].trim());
	    if (n < 1) {
	      System.out.println("Incorrect parameter");
	      System.exit(-1);
	    }//if   
	  }//if
	  
	  int number = solve(n);
	  System.out.println("There are " + number + " solutions to the " + n + "-queens problem.");
	 }//main()
	  
	}

	

