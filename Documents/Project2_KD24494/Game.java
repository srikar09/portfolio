package assignment2;

import java.util.ArrayList;

public class Game {

	 String secretcode; 
	 int numberguesses; 
	 boolean mode; 
	ArrayList<String> history;	
	int win;
	
		public Game(boolean mode){
		secretcode=  SecretCodeGenerator.getInstance().getNewSecretCode();
		numberguesses= GameConfiguration.guessNumber; 
		this.mode=mode; 
		history = new ArrayList<String>();
		win =0; 
	}       
	
	// returns the right sequence in terms of colors
	public String sequenceright(String input){
        		// check each position.  Then check any position with other positions not taken up 
		int array[]= new int[secretcode.length()];  
		int array1[]= new int[secretcode.length()]; 
		int numblack=0; 
		int numwhite=0;
		int size= secretcode.length(); 
		for(int i=0; i<size; i++){
		if( input.charAt(i) == secretcode.charAt(i)){
			array[i]=1; 
			array1[i]=1; 
			numblack++; 
		}
		
		}
		
		for(int i =0; i<array.length; i++){	
			if( array[i]==0){
				int flag =0; 
				for(int z =0; z<array.length && flag==0; z++){
					
				if(array1[z]== 0){
					if(secretcode.charAt(i)== input.charAt(z)){
						   array1[z]=1; 
						   array[i]=1;
						   flag =1; 
						   numwhite++; 
						} 
	
				
				}
				
				}
				
			}
			
		}
	if(numblack==4){
	  win =1; 		
	 		
		}
		
		return (input+ " -> "+numblack+"b"+"_"+numwhite+"w" ); 
		
	}  
	  
	//updates the state of the game mainly guesses and history
	// decrement gueses and store in history 
	public void updategame(String input){
		numberguesses--; 
		String input2=this.sequenceright(input); 
		history.add(input2);
		
 		}
	  
	
	
}  
    