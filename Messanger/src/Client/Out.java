package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Out extends Thread{
	PrintWriter out;
	String fromUser;
	Scanner stdIn;
	
	public Out(Socket socket) {
		stdIn = new Scanner(System.in);
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.start();
	}
	
	public void run(){
		
		while (true){
		    fromUser = stdIn.nextLine();
		    out.println(fromUser);
		}
	}
}
