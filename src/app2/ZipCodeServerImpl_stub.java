/**
 * 
 */
package app2;

import exception.MyRemoteException;
import remoteinterface.Remote_Stub;
import rmimessage.RMIInvocationMSG;
import rmimessage.RMIReturnMSG;

/**
 * @author air
 *
 */
public class ZipCodeServerImpl_stub extends Remote_Stub implements ZipCodeServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1068237409475213952L;

	/* (non-Javadoc)
	 * @see app2.ZipCodeServer#initialise(app2.ZipCodeList)
	 */
	@Override
	public void initialise(ZipCodeList newlist) throws MyRemoteException {
		RMIInvocationMSG msg = new RMIInvocationMSG("app2.ZipCodeServerImpl",
				"initialise", new Class[] {ZipCodeList.class},
				new Object[] {newlist});
		clientCM.sendMessage(msg);
		clientCM.receiveMessage();
	}

	/* (non-Javadoc)
	 * @see app2.ZipCodeServer#find(java.lang.String)
	 */
	@Override
	public String find(String city) throws MyRemoteException {
		RMIInvocationMSG msg = new RMIInvocationMSG("app2.ZipCodeServerImpl",
				"find", new Class[] {String.class},
				new Object[] {city});
		clientCM.sendMessage(msg);
		RMIReturnMSG rtmsg = (RMIReturnMSG) clientCM.receiveMessage();
		return (String)rtmsg.getReturnObject();
	}

	/* (non-Javadoc)
	 * @see app2.ZipCodeServer#findAll()
	 */
	@Override
	public ZipCodeList findAll() throws MyRemoteException {
		RMIInvocationMSG msg = new RMIInvocationMSG("app2.ZipCodeServerImpl",
				"findAll", new Class[] { },
				new Object[] { });
		clientCM.sendMessage(msg);
		RMIReturnMSG rtmsg = (RMIReturnMSG) clientCM.receiveMessage();
		return (ZipCodeList)rtmsg.getReturnObject();
	}

	/* (non-Javadoc)
	 * @see app2.ZipCodeServer#printAll()
	 */
	@Override
	public void printAll() throws MyRemoteException {
		RMIInvocationMSG msg = new RMIInvocationMSG("app2.ZipCodeServerImpl",
				"printAll", new Class[] {},
				new Object[] { });
		clientCM.sendMessage(msg);
		clientCM.receiveMessage();

	}

}
