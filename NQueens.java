
import java.util.Stack;

public class NQueens {
 
 
  //finds and prints out all solutions to the n-queens problem
	static int x=0;//row
	static int y=0;//column
 
   static Stack<Integer> chess = new Stack<Integer>();
   static int solutionNum=0;
   
  
  public static int solve(int n) {
	
	  /*if(isValid(chess)){
		  chess.push(y);
		  if(chess.size()==n){
			  printSolution(chess);
			  solutionNum++;
			  x--;
			  chess.pop();
			  y=chess.pop()+1;
			  solve(n);
		  }
		  y=0;
		  x++;
		  solve(n);
	  }
	  if(y==n-1){
		  if(chess.size()==0)
			return solutionNum; 
		  
		 y=chess.pop()+1;
		 x--;
		 solve(n);
	  }
	  
		  
	  return solutionNum;
	  */
		  if(isValid(chess)){
			 chess.push(y);
			 //stack size=n, one solution, go back to last row; y from y+1;
			 if(chess.size()==n){
				printSolution(chess);
				solutionNum++;
				System.out.println(solutionNum);
				x--;
				//pop out the one on the nth row, and then go back to the n-1 row
				chess.pop();
				y=chess.pop();
				//if no valid position in this col, go back to last row;
				if(y==n-1){
					//last index of the first row: no more solutions
					if(chess.size()==0)
				     return solutionNum;
				   x--;
	               y=chess.pop();
	            }
			    y++;
				solve(n);
		       }
			 //go to next row
			   x++;
		       y=-1;
		      
		   }	    
		  //no available positions for such row
		   else if(y==n-1){
			   //no more available solutions
			     if(chess.size()==0)
				  return solutionNum;
			     else{
				  y=chess.pop();
				  x--; 
				   if(y==n-1){
					 if(chess.size()==0)
						return solutionNum;
					y=chess.pop();
					x--;
			      }    
		          y++;
		          solve(n); 
		      }//else
			     
	       } //if else	
		  y++;
		  if(y<n&&x<n)
		    solve(n);
		  return solutionNum;
		 } 
  //solve()
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
