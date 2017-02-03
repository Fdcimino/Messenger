package Server;

import java.io.BufferedReader;
import java.io.IOException;

public class In extends Thread{
	
	MiniServer master;
	BufferedReader in;
	String inputLine;
	
	public In(BufferedReader in, MiniServer master) {
		// TODO Auto-generated constructor stub
		this.in = in;
		this.master = master;
	}
	
	public void run(){
		try {
		while ((inputLine = in.readLine()) != null) {
				if(master.clientID == null){
					master.clientID = inputLine;
				}
				
				master.sendMessageToAll(master.clientID + ": " + inputLine);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
