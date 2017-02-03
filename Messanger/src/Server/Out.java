package Server;

import java.io.PrintWriter;

public class Out extends Thread{
    
	MiniServer master;
	PrintWriter out;
	String outputLine;
	
	public Out(PrintWriter out, MiniServer master) {
		this.out = out;
		this.master = master;
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
