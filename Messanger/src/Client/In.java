package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class In extends Thread{
	BufferedReader in;
	String fromServer; // TODO: Make this a packet
	
	public In( BufferedReader in){
		this.in = in;
	}
	
	
	public void run(){
		try {
			while ((fromServer = in.readLine()) != null) {
			    System.out.println("Server: " + fromServer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
