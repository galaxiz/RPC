/**
 * 
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

import rmimessage.RMImessage;
import exception.MyRemoteException;

/**
 * @author Shiwei Dong
 * 
 *         This is an abstract class of communication model. CMs are responsible
 *         for setting up connection, send as well as receive RMImessages. CM
 *         can also cache connections
 */
public abstract class CommunicationModel implements Serializable {
	//Object stream for serialization
	protected ObjectOutputStream out;
	protected ObjectInputStream in;
	
	// Started determine if the communication if cached or not
	protected boolean started;
	// Server and Client socket
	protected Socket scSocket;

	protected abstract void startSocket();

	protected abstract void closeSocket();
	
	public boolean isConnected() {
		return started;
	}

	public void startCM() {
		try {
			if (started == false) {
				startSocket();
				this.out = new ObjectOutputStream(scSocket.getOutputStream());
				this.out.flush();
				this.in = new ObjectInputStream(scSocket.getInputStream());
				started = true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void endCM() {
		try {
			in.close();
			out.close();
			closeSocket();
			started = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMessage(RMImessage message) throws MyRemoteException {
		try {
			if (started == false) {
				startCM();
			}
			out.writeObject(message);
			out.flush();
		} catch (IOException e) {
			endCM();
			throw new MyRemoteException();
		}
	}

	public RMImessage receiveMessage() throws MyRemoteException {
		try {
			if (started == false) {
				startCM();
			}
			return (RMImessage) in.readObject();
		} catch (IOException e) {
			endCM();
			throw new MyRemoteException();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
