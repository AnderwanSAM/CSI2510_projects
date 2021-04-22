/*import java.io.IOException;
import java.util.Scanner;

import client.ChatClient;
import common.ChatIF;
import ocsf.server.AbstractServer;*/

import java.io.*;
import java.util.Scanner;

import client.*;
import common.*;

public class ServerConsole  implements ChatIF{

	/**
	   * The default port to connect on.
	   */
	  final public static int DEFAULT_PORT = 5555;
	  
	  //Instance variables **********************************************
	  
	  /**
	   * The instance of the client that created this ConsoleChat.
	   */
	  ChatClient client;
	  
	  
	  
	  /**
	   * Scanner to read from the console
	   */
	  Scanner fromConsole; 

	  
	  //Constructors ****************************************************

	  /**
	   * Constructs an instance of the ClientConsole UI.
	   *
	   * @param host The host to connect to.
	   * @param port The port to connect on.
	   */
	  public ServerConsole(String host, int port,String id) 
	  {
	    try 
	    {
	      client= new ChatClient(host, port, this,id);
	      
	      
	    } 
	    catch(IOException exception) 
	    {
	      System.out.println("Error: Can't setup connection!"
	                + " Terminating client.");
	      System.exit(1);
	    }
	    
	    // Create scanner object to read from console
	    fromConsole = new Scanner(System.in); 
	  }

	  
	  //Instance methods ************************************************
	  
	  /**
	   * This method waits for input from the console.  Once it is 
	   * received, it sends it to the client's message handler.
	   */
	  public void accept() 
	  {
	    try
	    {

	      String message;

	      while (true) 
	      {
	    	  message = fromConsole.nextLine();
		        client.handleMessageFromClientUI("SERVER MSG > " + message);
	    	
	       
	      }
	    } 
	    catch (Exception ex) 
	    {
	      System.out.println
	        ("Unexpected error while reading from console!");
	    }
	  }

	  /**
	   * This method overrides the method in the ChatIF interface.  It
	   * displays a message onto the screen.
	   *
	   * @param message The string to be displayed.
	   */
	  public void display(String message) 
	  {
	    System.out.println("" + message);
	  }

	  
	  //Class methods ***************************************************
	  
	  /**
	   * This method is responsible for the creation of the Client UI.
	   *
	   * @param args[0] The host to connect to.
	   */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String host = "";
		    int current_port; // une variable pour stocker le numero de port qui sera utilisé
		    
		    //recuperer l'ID //Pour le serveur console nous allons attribuer une valeur par defaut 


		    try
		    {
		      host = args[1];
		     current_port = Integer.parseInt(args[2]); // lire l'argument suivant de la ligne de commande
		      
		    }
		    catch(ArrayIndexOutOfBoundsException e)
		    {
		      host = "localhost";
		      current_port = DEFAULT_PORT; // au cas ou aucun argument n'est specifié, utiliser le port par défaut
		    }
		    
		    
		    ServerConsole chat= new ServerConsole(host,current_port,"#login<SEG>");
		    
		    chat.accept();  //Wait for console data
		    
		    
		    
		
	}

	

}
