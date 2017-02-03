package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Out extends Thread{
    
	MiniServer master;
	PrintWriter out;
	String outputLine;
	
	public Out(Socket socket, MiniServer master) {
		this.master = master;
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.start();
	}

	public void run(){
         outputLine = "Welcome to The Server";
         out.println(outputLine);
         out.println("Enter your desired Name");
	}
	
	//TODO: change from String to Packet
	public void sendMessage(String message){
		out.print(message);
	}
}
