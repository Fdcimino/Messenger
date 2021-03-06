package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

class Client {
    public static void main(String args[]) throws Exception {
  
         String hostName = "localhost";
         int portNumber = 2343;
         
         In inputStream;
         Out outputStream;
  
        /* try (
             Socket kkSocket = new Socket(hostName, portNumber);
             PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                 new InputStreamReader(kkSocket.getInputStream()));
         ) {
             BufferedReader stdIn =
                 new BufferedReader(new InputStreamReader(System.in));
             String fromServer;
             String fromUser;
  
             while ((fromServer = in.readLine()) != null) {
                 System.out.println("Server: " + fromServer);
                 if (fromServer.equals("Bye."))
                     break;
                  
                 fromUser = stdIn.readLine();
                     System.out.println("Client: " + fromUser);
                     out.println(fromUser);
                 }
             }
         } catch (UnknownHostException e) {
             System.err.println("Don't know about host " + hostName);
             System.exit(1);
             
         } catch (IOException e) {
             System.err.println("Couldn't get I/O for the connection to " +
                 hostName);
             System.exit(1);
         }*/
         
         try( Socket kkSocket = new Socket(hostName, portNumber);
                 PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(
                     new InputStreamReader(kkSocket.getInputStream()));){
        	 
        	 inputStream = new In(in);
        	 outputStream = new Out(out);
        	 inputStream.start();
        	 outputStream.start();
        	 
         } catch (UnknownHostException e) {
             System.err.println("Don't know about host " + hostName);
             System.exit(1);
             
         } catch (IOException e) {
             System.err.println("Couldn't get I/O for the connection to " +
                 hostName);
             System.exit(1);
         }
    }
}
