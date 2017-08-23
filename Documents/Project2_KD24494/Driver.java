/*
*Name: Krishna Srikar Dandamuraju
*UT EID : KD2444
*Professor: Nandakumar 
*/
package assignment2;
import java.util.*;

public class Driver {

	public static void main (String []args){
		Scanner keyboard=  new Scanner(System.in);  // scanner object to read input
	  	int length = args.length; 
	  	int a=0; 
	  	if(length !=0)
			{ a = Integer.parseInt(args[0]);} 
		boolean mode=false; 
	  	if(a == 1){
			mode= true; 
		}
	
	// need a for loop 
	
	int flag =0; // specifies when to quit
	System.out.println("Welcome to Mastermind.");
	while(flag ==0){
	System.out.println("Do you want to play a new game? (Y/N):" );  
	String input= 	keyboard.next(); 
	if(input.equals("Y")){
		System.out.println();
		Game x = new Game(mode);
		board.startgame(x,keyboard); 
		 
	}
	else if (input.equals("N")){
		flag=1;
	//exit	
	}
	
	else{
		
		System.out.println("Please enter the right input");
	}
		
	
	}  
	
	
	  	
	}

	
	
}
