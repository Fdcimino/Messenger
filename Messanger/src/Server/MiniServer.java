package Server;

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
	        inputStream = new In(socket, this);
			outputStream = new Out(socket, this);
	    }

		public void sendMessageToAll(String inputLine) {
			// TODO Auto-generated method stub
			System.out.println(inputLine);
			Server.sendMessage(inputLine);
		}
}
