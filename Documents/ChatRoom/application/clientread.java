package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javafx.scene.control.TextArea;

public class clientread implements Runnable {
	
	public BufferedReader reader ;
	Map< String,TextArea> rightHereMap ;
	@Override
	public void run() {
		
  		while(true){
  			/*
  			 * 
  			 * int iend = x.indexOf("%;&");
		int iend1 =x.indexOf("%;&", x.indexOf("%;&") + 1);
		int iend2 =x.indexOf("%;&", iend1 + 1);
 		String subString= x.substring(0 , iend);
		System.out.println(subString);
		String subString2= x.substring(iend+3 , iend1);
		String subString3= x.substring(iend1+3 ,iend2); //x.length()
		String subString4= x.substring(iend2+3 ,x.length()); //x.length()
  			 */
  			
  		
  		String message;
  		try {
			if( reader.ready() ){
				message= reader.readLine();
				
				int iend = message.indexOf("%;&");
				int iend1 =message.indexOf("%;&", message.indexOf("%;&") + 1);
				int iend2 =message.indexOf("%;&", iend1 + 1);

		 		String subString= message.substring(0 , iend);
				String subString2= message.substring(iend+3 , iend1);
				String subString3= message.substring(iend1+3 ,iend2);
				String subString4= message.substring(iend2+3 ,message.length());
				System.out.println(message);
				System.out.println(subString2);
				System.out.println("subString3:"+subString3);
			if(subString3.equals("no")){
				TextArea x =rightHereMap.get("no");
				x.appendText("\n" +subString+": "+ subString4+ "\n");
			//	rightHereMap.get("no").appendText("\n" +subString+": "+ message+ "\n");
				
			}
			else{
				

				if(subString.equals("Srikar")){
					
					rightHereMap.get("Srikar").appendText("\n"+subString+ ": " +subString4+ "\n");;

				}
				
				else if(subString.equals("Smith")){
					
					rightHereMap.get("Smith").appendText("\n" +subString+ ": "+subString4+ "\n");

				}
				
				else if(subString.equals("James")){
					
					rightHereMap.get("James").appendText("\n" +subString+ ": "+subString4+ "\n");

				}
			}
				
				
				
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  	}
	
	
	public clientread(TextArea io, ArrayList <String> x, Set <String> identifier  ){
		
	}
	public clientread(BufferedReader reader1,Map<String,TextArea > rightHereMap1 ){
		reader=reader1;
		rightHereMap=rightHereMap1;
	}
}