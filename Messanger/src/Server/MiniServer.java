package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MiniServer extends Thread {

		Server serverHead;
		private Socket socket = null;
		public String clientID = null;
		
		In inputStream;
		Out outputStream;
		
	    public MiniServer(Socket socket){
	        super("KKMultiServerThread");
	        this.socket = socket;
	    }
	     
	    public void run() {
	 
	        try (
	            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(
	                new InputStreamReader(
	                    socket.getInputStream()));
	        ) {
	        	
	        	inputStream = new In(in, this);
	        	outputStream = new Out(out, this);
	        	inputStream.start();
	        	outputStream.start();
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

		public void sendMessageToAll(String inputLine) {
			// TODO Auto-generated method stub
			System.out.println(inputLine);
			Server.sendMessage(inputLine);
		}
}
