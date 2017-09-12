package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class clientserver implements Runnable {
	
	 BufferedReader reader;
	 private BufferedReader inStream = null;
	 private PrintWriter writer= null;
	 private ObjectOutputStream outputStream  = null;

	@Override
	public void run() {
	while(true){
		
		
	
		String currentmessage= null;
			try {
			if(inStream.ready()){
				currentmessage =  inStream.readLine();
				int iend = currentmessage.indexOf("%;&");
				int iend1 =currentmessage.indexOf("%;&", currentmessage.indexOf("%;&") + 1);
				int iend2 =currentmessage.indexOf("%;&", iend1 + 1);
		 		String subString1= currentmessage.substring(0 , iend);  //incoming name
				String subString2= currentmessage.substring(iend+3 , iend1); //outgoing name
				String subString3= currentmessage.substring(iend1+3 ,iend2); // group or not
				String subString4= currentmessage.substring(iend2+3 ,currentmessage.length()); //x.length()

				if(subString3.equals("Yes")){
					int index=	servermain.clinetnames.indexOf(subString2);
					if(index == -1){
						while(index ==-1){
							index=servermain.clinetnames.indexOf(subString2);
						}
						
					}
					
					servermain.writetoclien(index,currentmessage);
				}
				else{  //send to all
					
					for(int i=0; i<servermain.clinetnames.size();i++){
						servermain.writetoclien(i,currentmessage);
					}
				}
	 			
			}
				
		} catch (  IOException e) {
			e.printStackTrace();
		}		
		
			
	
		
	} 
}

	public clientserver(Socket x,BufferedReader input, PrintWriter output){
		writer=output;
		inStream=input;
		
	}



}
