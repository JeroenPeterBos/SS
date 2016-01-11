package ss.week7.cmdline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Peer for a simple client-server application
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
    public static final String EXIT = "exit";

    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected BufferedWriter out;


    /*@
       requires (nameArg != null) && (sockArg != null);
     */
    /**
     * Constructor. creates a peer object based in the given parameters.
     * @param   nameArg name of the Peer-proces
     * @param   sockArg Socket of the Peer-proces
     */
    public Peer(String nameArg, Socket sockArg) throws IOException
    {
    	this.name = nameArg;
    	this.sock = sockArg;
    	this.in = new BufferedReader(new InputStreamReader(sockArg.getInputStream()));
    	this.out = new BufferedWriter(new OutputStreamWriter(sockArg.getOutputStream()));
    	
    	this.out.write(getName());
    	this.out.newLine();
    	this.out.flush();
    	
    	String response = null;
    	while(response == null){
    		response = this.in.readLine();
    	}
    	System.out.println("name : " + response);
    	System.out.println();
    }

    /**
     * Reads strings of the stream of the socket-connection and
     * writes the characters to the default output.
     */
    public void run() {
    	boolean running = true;
    	while(running){
    		try {
    			String string = in.readLine();
				if(string != null){
					System.out.println(string);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
				running = false;
			}
    	}
    	System.out.println("stopped reading");
    }


    /**
     * Reads a string from the console and sends this string over
     * the socket-connection to the Peer process.
     * On Peer.EXIT the method ends
     */
    public void handleTerminalInput() {
    	while(true){
    		String string = readString("");
    		if(string.equals(EXIT)){
    			return;
    		} 
    		try {
				out.write(getName() + ": " + string);
				out.newLine();
				out.flush();
			} catch (IOException e) {
				System.out.println("Couldn't send " + string + " over the socket");
			}
    	}
    }

    /**
     * Closes the connection, the sockets will be terminated
     */
    public void shutDown() {
    	try {
			in.close();
			out.close();
	    	sock.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
    }

    /**  returns name of the peer object*/
    public String getName() {
        return name;
    }

    /** read a line from the default input (Terminal)*/
    static public String readString(String tekst) {
        System.out.print(tekst);
        String antw = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            antw = in.readLine();
        } catch (IOException e) {
        }

        return (antw == null) ? "" : antw;
    }
}
