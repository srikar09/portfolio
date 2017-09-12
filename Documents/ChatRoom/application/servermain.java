package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class servermain {  // This has to 

	
	
	protected static ArrayList<PrintWriter> clientOutputStreams;
	protected static ArrayList<String> clinetnames;
	
	public static void setup(){
		clinetnames= new ArrayList<String>();
		clientOutputStreams = new ArrayList<PrintWriter>();
 		try {
			ServerSocket server = new ServerSocket(4199);
		while(true){
			Socket clientSocket= server.accept();			
			InputStreamReader stream = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader reader = new BufferedReader(stream);
			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
			String x= reader.readLine();   //Have to parse x  . we will use %, semicolon &
			int iend = x.indexOf("%;&");
			String subString= x.substring(0 , iend);
			subString.trim();
			clientOutputStreams.add(writer); // same indices
			clinetnames.add(subString);  // should have the same indices 
			Thread t = new Thread(new clientserver(clientSocket,reader,writer));
			t.start();

		}
	
		
		} catch (IOException e) {
 			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	public static synchronized void writetoclien(int i, String currentmessage){  // i is the index
		clientOutputStreams.get(i).println(currentmessage);
		clientOutputStreams.get(i).flush();

	}
	
	public static void main(String [] args){
		
	servermain.setup() ;

	}
}
