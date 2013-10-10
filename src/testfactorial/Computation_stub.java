/**
 * 
 */
package testfactorial;

import remoteinterface.Remote_Stub;
import rmimessage.InvocationMsg;
import rmimessage.ReturnMSG;
import communication.ClientCM;
import exception.RemoteException;

/**
 * @author air
 *
 */
public class Computation_stub extends Remote_Stub implements Compute {
	
	/* (non-Javadoc)
	 * @see app1.Compute#computeFactorial(int)
	 */
	@Override
	public int computeFactorial(int i) throws RemoteException {
		InvocationMsg msg = new InvocationMsg("testfactorial.Computation",
				"computeFactorial", new Class[] { Integer.TYPE },
				new Object[] { i });
		clientCM.sendMessage(msg);
		ReturnMSG rtmsg = (ReturnMSG) clientCM.receiveMessage();
		return (Integer)rtmsg.getReturnObject();
	}

	/* (non-Javadoc)
	 * @see app1.Compute#computeSum(int, int)
	 */
	@Override
	public int computeSum(int i, int j) throws RemoteException {
		InvocationMsg msg = new InvocationMsg("testfactorial.Computation",
				"computeSum", new Class[] { Integer.TYPE, Integer.TYPE },
				new Object[] { i, j });
		clientCM.sendMessage(msg);
		ReturnMSG rtmsg = (ReturnMSG) clientCM.receiveMessage();
		return (Integer)rtmsg.getReturnObject();
	}
}
