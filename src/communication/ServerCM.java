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

	public ServerCM(Socket scSocket) {
		this.scSocket = scSocket;
		this.started = false;
	}

	/* (non-Javadoc)
	 * @see communication.CommunicationModel#startSocket()
	 */
	protected void startSocket() {}

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
