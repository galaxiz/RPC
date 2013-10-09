/**
 * 
 */
package app1;

import rmimessage.RMIInvocationMSG;
import rmimessage.RMIReturnMSG;
import communication.ClientCM;
import exception.MyRemoteException;

/**
 * @author air
 * 
 */
public class TestClient {

	public static void main(String args[]) {
		try {
			ClientCM clientcm = new ClientCM("127.0.1.1", 9032);
			while (true) {
				int a = Integer.parseInt(System.console().readLine());
				RMIInvocationMSG msg = new RMIInvocationMSG("app1.Computation",
						"computeFactorial", new Class[] { Integer.TYPE },
						new Object[] { a });
				clientcm.sendMessage(msg);
				RMIReturnMSG rtmsg = (RMIReturnMSG) clientcm.receiveMessage();
				System.out.println("The answer is "
						+ rtmsg.getReturnObject().toString());
			}
		} catch (MyRemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
