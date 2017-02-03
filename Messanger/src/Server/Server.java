package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	public static List<MiniServer> clients = new ArrayList<>();
	
	public static String log = "";
	
    public static void main(String[] args) throws IOException {


            int portNumber = 2343;
            boolean listening = true;
            
           
            try (ServerSocket serverSocket = new ServerSocket(portNumber)) { 
                while (listening) {
    	           MiniServer mini = new MiniServer(serverSocket.accept());
    	           mini.start();
    	           clients.add(mini);
    	           for(MiniServer m: clients){
    	        	   if(!m.isAlive()){
    	        		   clients.remove(m);
    	        	   }
    	           }
    	        }
    	    } catch (IOException e) {
                System.err.println("Could not listen on port " + portNumber);
                System.exit(-1);
            }
      }
    
    //TODO: Change from String to Packet
    public static void sendMessage(String message){
    	for(MiniServer m: clients){
    		m.outputStream.sendMessage(message);
    	}
    }

}
