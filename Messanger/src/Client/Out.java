package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Out extends Thread{
	PrintWriter out;
	String fromUser;
	BufferedReader stdIn;
	public Out(PrintWriter out){
		this.out = out;
		stdIn = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void run(){
		
		try {
			while (true){
			    fromUser = stdIn.readLine();
			    out.println(fromUser);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
