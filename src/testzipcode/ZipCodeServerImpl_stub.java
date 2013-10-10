/**
 * 
 */
package testzipcode;

import exception.RemoteException;
import remoteinterface.Remote_Stub;
import rmimessage.InvocationMsg;
import rmimessage.ReturnMSG;

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
	public void initialise(ZipCodeList newlist) throws RemoteException {
		InvocationMsg msg = new InvocationMsg("testzipcode.ZipCodeServerImpl",
				"initialise", new Class[] {ZipCodeList.class},
				new Object[] {newlist});
		clientCM.sendMessage(msg);
		clientCM.receiveMessage();
	}

	/* (non-Javadoc)
	 * @see app2.ZipCodeServer#find(java.lang.String)
	 */
	@Override
	public String find(String city) throws RemoteException {
		InvocationMsg msg = new InvocationMsg("testzipcode.ZipCodeServerImpl",
				"find", new Class[] {String.class},
				new Object[] {city});
		clientCM.sendMessage(msg);
		ReturnMSG rtmsg = (ReturnMSG) clientCM.receiveMessage();
		return (String)rtmsg.getReturnObject();
	}

	/* (non-Javadoc)
	 * @see app2.ZipCodeServer#findAll()
	 */
	@Override
	public ZipCodeList findAll() throws RemoteException {
		InvocationMsg msg = new InvocationMsg("testzipcode.ZipCodeServerImpl",
				"findAll", new Class[] { },
				new Object[] { });
		clientCM.sendMessage(msg);
		ReturnMSG rtmsg = (ReturnMSG) clientCM.receiveMessage();
		return (ZipCodeList)rtmsg.getReturnObject();
	}

	/* (non-Javadoc)
	 * @see app2.ZipCodeServer#printAll()
	 */
	@Override
	public void printAll() throws RemoteException {
		InvocationMsg msg = new InvocationMsg("testzipcode.ZipCodeServerImpl",
				"printAll", new Class[] {},
				new Object[] { });
		clientCM.sendMessage(msg);
		clientCM.receiveMessage();

	}

}
