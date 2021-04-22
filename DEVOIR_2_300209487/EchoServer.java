// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import ocsf.server.*;


/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public EchoServer(int port) 
  {
    super(port);
  }

  
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient
    (Object msg, ConnectionToClient client)
  {
    System.out.println("Message received: " + msg + " from " + client);
    //tester pour savoir si ca vient du serveur 
  
    try 
    {
    	String current = (String) msg.toString().subSequence(6,16);
    	if(current.equals("SERVER MSG")) 
    	{
    		 //determiner s'il s'agit d'une commande 
    		char  from_server_console = msg.toString().substring(19).charAt(0);
    		String t =  msg.toString().substring(20);
    		System.out.println(t);
    		if(from_server_console != '#') // il ne s'agit pas d'une commande ; envoyer le message a tous 
    		{
    			this.sendToAllClients(msg);
    		}
    		else 
    		{
    			
    			String commande = ((String) msg).substring(20);
        		//S'il s'agit d'une commande , determiner laquelle et l'executer 
        		switch(commande) 
        		{
        		case "login":
        			this.sendToAllClients("Command not allowed");
        			break ;
        		case "start":
        			listen();
        			break ;
        		case "quit":
        			close();
        			break ;
        		case "stop":
        			stopListening();
        			break ; 
        		case "close" : 
        			stopListening();
        			close();
        			serverClosed();
        			break ;
        		case "getport" : 
        			this.sendToAllClients("Port Actuel du serveur = " + getPort());
        			break ;
        		default :  // Au cas ou il s'agit d'une commande contenant des arguments comme setPort ou setHost
        			String subcommande = (String) commande.subSequence(0,7);
        			switch(subcommande) 
        			{
        			case "setport":
        				if(isListening()) 
        				{
        					sendToAllClients("Already listening on a port");
        				
        				}
        				else 
        				{
        					//recuperer la nouvelle du port 
            				String nouveau_port = (String) commande.subSequence(7,commande.length());
            				setPort(Integer.parseInt(nouveau_port));// l'attribuer 	
        				}
        				
        				break ;
        			default : 
        				this.sendToAllClients("-----------------.SERVER-Commande inconnue ");
        				break ;
        			
        			}
        		}
    		}
    	}
    	else 
    	{
    		sendToAllClients(msg);
    		/*char[] temp = msg.toString().toCharArray();
        	if(temp[0] == '#') //verifier si il s'agit du login
        	{
        		try 
        		{
        			if(msg.toString().subSequence(0, 7).equals("#login<")) 
        			{
        				sendToAllClients("OK id recuperee");
        			}
        			else 
        			{
        				sendToAllClients("erreur au niveau de la ligne  127 echo-server" + msg.toString().subSequence(0,7));
        			}
        		}
        		catch (Exception e1) 
        		{
        			this.sendToAllClients(msg);
        		}
        		*/
        	}
        	/*else 
        	{
        		this.sendToAllClients(msg);
        	}*/
    		
    	//}
    }
    catch(Exception e) 
    {
    	this.sendToAllClients(msg);
    	 
    }
    
    
   // this.sendToAllClients(msg);
  }
    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  public static void main(String[] args) 
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port =  DEFAULT_PORT; //Set port to 5555
    }
	
    EchoServer sv = new EchoServer(port);
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
  }
  
  // methodes implementees 
  
  protected void clientConnected(ConnectionToClient client) 
  {
	  System.out.println("A new client is attempting to connect to the server"); // afficher un message informant de la connectioon d'un client 
	  
  }
  
  synchronized protected void clientException(ConnectionToClient client, Throwable exception) 
  {
	  clientDisconnected(client);
	  
	  
  }

  synchronized protected void clientDisconnected(ConnectionToClient client) 
  {
	  System.out.println("A client is disconnected");
	  //afficher un message informant de la deconnexion du client   
  }
  
  protected void serverClosed() 
  {
	  System.out.println("Server closed  ");
  }
  
  
}
//End of EchoServer class
