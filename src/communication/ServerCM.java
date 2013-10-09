/**
 * 
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Shiwei Dong
 * 
 */
public class ServerCM extends CommunicationModel {

	private ServerSocket serverSideSocket;
	private int port;

	public ServerCM(int port) {
		this.port = port;
		this.started = false;
	}
	
	public void startServer() {
		try {
			serverSideSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void endServer() {
		try {
			serverSideSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see communication.CommunicationModel#startSocket()
	 */
	protected void startSocket() {
		try {
			this.scSocket = serverSideSocket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/* (non-Javadoc)
	 * @see communication.CommunicationModel#closeSocket()
	 */
	@Override
	protected void closeSocket() {
		try {
			scSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
