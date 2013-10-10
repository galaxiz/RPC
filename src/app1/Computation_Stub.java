/**
 * 
 */
package app1;

import remoteinterface.Remote_Stub;
import rmimessage.RMIInvocationMSG;
import rmimessage.RMIReturnMSG;
import communication.ClientCM;
import exception.MyRemoteException;

/**
 * @author air
 *
 */
public class Computation_Stub extends Remote_Stub implements Compute {
	
	/* (non-Javadoc)
	 * @see app1.Compute#computeFactorial(int)
	 */
	@Override
	public int computeFactorial(int i) throws MyRemoteException {
		RMIInvocationMSG msg = new RMIInvocationMSG("app1.Computation",
				"computeFactorial", new Class[] { Integer.TYPE },
				new Object[] { i });
		clientCM.sendMessage(msg);
		RMIReturnMSG rtmsg = (RMIReturnMSG) clientCM.receiveMessage();
		return (Integer)rtmsg.getReturnObject();
	}

	/* (non-Javadoc)
	 * @see app1.Compute#computeSum(int, int)
	 */
	@Override
	public int computeSum(int i, int j) throws MyRemoteException {
		RMIInvocationMSG msg = new RMIInvocationMSG("app1.Computation",
				"computeSum", new Class[] { Integer.TYPE, Integer.TYPE },
				new Object[] { i, j });
		clientCM.sendMessage(msg);
		RMIReturnMSG rtmsg = (RMIReturnMSG) clientCM.receiveMessage();
		return (Integer)rtmsg.getReturnObject();
	}

}
