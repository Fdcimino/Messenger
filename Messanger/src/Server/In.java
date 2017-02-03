package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class In extends Thread{
	
	MiniServer master;
	BufferedReader in;
	String inputLine;
	
	public In(Socket socket, MiniServer master) {
		// TODO Auto-generated constructor stub
		this.master = master;
		try {
			in = new BufferedReader(
			         new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.start();
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
