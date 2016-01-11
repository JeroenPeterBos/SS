
package ss.week7.cmdline;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";

    /** Starts a Server-application. */
    public static void main(String[] args) {
    	
    	if (args.length != 2){
    		System.out.println(USAGE + args.length);
    		System.exit(0);
    	}
    	
    	String name = args[0];
    	int port = 0;
    	try {
    		port = Integer.parseInt(args[1]);
    	} catch (NumberFormatException e) {
    		System.out.println(USAGE);
    		System.out.println("ERROR: port " + args[1] + " is not an integer");
    		System.exit(0);
    	}
    	
    	
    	ServerSocket ss = null;
    	try {
			ss = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
    		Socket clientSocket = ss.accept();
			System.out.println("Client connected");
    		Peer client = new Peer(name, clientSocket);
    		Thread streamInputHandler = new Thread(client);
    		streamInputHandler.start();
    		client.handleTerminalInput();
    		client.shutDown();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

} // end of class Server
