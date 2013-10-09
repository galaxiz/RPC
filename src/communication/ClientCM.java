/**
 * 
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Shiwei Dong 
 * 
 * ClientCM handles client side communication issues.
 *  
 */
public class ClientCM extends CommunicationModel {

	private String host;
	private int port;

	public ClientCM(String host, int port) {
		this.host = host;
		this.port = port;
		this.started = false;
	}

	/* (non-Javadoc)
	 * @see communication.CommunicationModel#startSocket()
	 */
	@Override
	protected void startSocket() {
		try {
			this.scSocket = new Socket(host, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
