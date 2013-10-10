/**
 * 
 */
package remoteinterface;

import java.io.Serializable;

import communication.ClientCM;

/**
 * @author air
 *
 */
public class Remote_Stub implements Serializable, Remote {
	protected ClientCM clientCM;
	
	public void setCM(String host, int port) {
		clientCM = new ClientCM(host, port);
	}
	
	public void setServerHost(String host){
		clientCM.setHost(host);
	}
}

