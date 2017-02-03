package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import Server.MiniServer;

public class In extends Thread{
	BufferedReader in;
	String fromServer; // TODO: Make this a packet
	
	public In(Socket socket) {
		// TODO Auto-generated constructor stub
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
			while ((fromServer = in.readLine()) != null) {
			    System.out.println("Server: " + fromServer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
