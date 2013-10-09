
package rmiserver;

import java.net.Socket;

import rmimessage.RMIInvocationMSG;
import rmimessage.RMIReturnMSG;
import communication.ServerCM;
import exception.MyRemoteException;

/**
 * @author Shiwei Dong
 * 
 * This class handles message invocation and return value for Remote
 * Objects.
 */
public class ClientHandler implements Runnable {

	private Socket scSocket;
	private Object serverObj;

	/** 
	 * @param s
	 * @param obj
	 */
	public ClientHandler(Socket s, Object obj) {
		this.scSocket = s;
		this.serverObj = obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		ServerCM scm = new ServerCM(scSocket);
		do {
			try {
				RMIInvocationMSG in = (RMIInvocationMSG) scm.receiveMessage();
				in.invoke(serverObj);
				RMIReturnMSG rtnmsg = in.getReturnMessage();
				scm.sendMessage(rtnmsg);
			} catch (MyRemoteException e) {
				System.out.println("scSocket lost! Connection is Over!");
				break;
			}
		} while (scm.isConnected());
	}

}
