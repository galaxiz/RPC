
package rmiserver;

import java.net.Socket;

import rmimessage.InvocationMsg;
import rmimessage.ReturnMSG;
import communication.ServerCM;
import exception.RemoteException;

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
				InvocationMsg in = (InvocationMsg) scm.receiveMessage();
				in.invoke(serverObj);
				ReturnMSG rtnmsg = in.getReturnMessage();
				scm.sendMessage(rtnmsg);
			} catch (RemoteException e) {
				System.out.println("scSocket lost! Connection is Over!");
				break;
			}
		} while (scm.isConnected());
	}

}
