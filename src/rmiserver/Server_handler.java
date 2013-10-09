 
package rmiserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RemoteStub;

import rmimessage.RMIInvocationMSG;
import rmimessage.RMIReturnMSG;
import communication.ServerCM;

/**
 * @author Shiwei Dong
 * 
 * Generate the stub encapsulate a CM in it
 * Bind the stub to the register.
 * 
 */
public class Server_handler implements Runnable {

	String serverClassName;
	String serverClassStubName;
	
	
	public Server_handler(String classname, String stubname){
		this.serverClassName = classname;
		this.serverClassStubName = stubname;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		System.out.println("Haha, you start a new Server_handler");
		
		try {
			//ServerCM scm = new ServerCM(9032);
			//scm.startServer();
			//int port = scm.getscSocketPort();
			ServerSocket ss = new ServerSocket(9032);
			//Class stub = Class.forName(serverClassStubName);
			//RemoteStub rstub = (RemoteStub)stub.newInstance();
			Class sobj = Class.forName(serverClassName);
			Object serverObj = sobj.newInstance();
			//rstub.setCM(host, port);
			//Initialize remote server object
			//register stub to registry
			
			//start service
			while(true) {
				Socket test = ss.accept();
				// start a new thread for each connection args(socket, obj)
				Runnable client_connection = new ClientHandler(test, serverObj);
				Thread t = new Thread(client_connection);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
