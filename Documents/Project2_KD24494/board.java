package assignment2;
import java.util.*;
import java.lang.*;
public class board {
	
	
			// prints out the board for each turn
		
	public static void display(Game x, int y, String input){
		if(y==1 && x.numberguesses !=0){
			System.out.println(x.sequenceright(input));	
			System.out.println(); 
		}
		else if ( y==1 && x.numberguesses ==0 ){  // print history 
			System.out.println(x.sequenceright(input));	
		}
		
		else{
			int length = x.history.size(); 
			for(int i =0 ; i < length; i++){
				System.out.println(x.history.get(i)); 
			 }
			System.out.println(); 
			
		}
		
			
	}
	
	
	// checks whether the input is in right format
	public static int isright(String input, Game y){
		
		if(input.equals("HISTORY")){
			
			return 2; 
			
		}
		 else if(input.length()== y.secretcode.length()){
			
			for(int i =0;i<input.length(); i++){
				//blue,
				//green,
				//orange,
				//purple,
				//red,
				//yellow
				switch(input.charAt(i)){
					case 'B':
					break;
					case 'G':
					break;
					case 'O':
					break;
					case 'P':
					break;
					case 'R':
					break;
					case 'Y':
					break;	
					default:
						return 3; 
				}
			 
			}
	return 1; 	
		}
		
		return 3; 
		
		 
		
		
		
	
		
		//needs to be changed 
	}
	
	
	// starts the game 
	// takes in inputs 
	//updates state of the game too
	//ends the game
	// calls all the functions in between
	public static void startgame(Game x, Scanner y){
		
		boolean code= x.mode; 
		if(code == true){
			System.out.println("Secret code:"+" "+ x.secretcode); 
			System.out.println();
		}
		
		// need while loop
		while((x.numberguesses>0) && (x.win==0)){
		
			System.out.println("You have "+x.numberguesses+" guess(es) left.");
			System.out.println("Enter guess:");
			String input = y.next(); 
			if(board.isright(input,x) == 1){ // right input 
				x.updategame(input);
				board.display(x,1,input);
			}
			else if (board.isright(input,x) == 2){ 		// history 
				board.display(x,2,input); 	
			}
			else{
				System.out.println("INVALID_GUESS");
				System.out.println();
			}
			
			
		}
		
		if(x.win==1  ){
			System.out.println("You win!");
			System.out.println();

		}
		
		else if (x.win==0 && code== true){
			System.out.println("You lose! The pattern was "+ x.secretcode);
			System.out.println(); 
		}
		else{
			System.out.println("You lose!");
			System.out.println();
		}
		
 		
	}
	
	

	
}
