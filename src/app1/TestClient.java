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

	public static void test_compute(int port) {
		Computation_Stub cs = new Computation_Stub();
		cs.setCM("127.0.1.1", port);
		try {
			System.out.println("Sum from 1 to 100 is "+cs.computeSum(1, 100));
		} catch (MyRemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (true) {
			int a = Integer.parseInt(System.console().readLine("Enter a int to compute factorial\n"));
			try {
				System.out.println(cs.computeFactorial(a));
			} catch (MyRemoteException e) {
				System.out.println("Error!!"+e);
			}
		}
	}

	public static void main(String args[]) {

		TestClient.test_compute(Integer.parseInt(args[0]));
		// try {
		// ClientCM clientcm = new ClientCM("127.0.1.1", 9032);
		// while (true) {
		// int a = Integer.parseInt(System.console().readLine());
		// RMIInvocationMSG msg = new RMIInvocationMSG("app1.Computation",
		// "computeFactorial", new Class[] { Integer.TYPE },
		// new Object[] { a });
		// clientcm.sendMessage(msg);
		// RMIReturnMSG rtmsg = (RMIReturnMSG) clientcm.receiveMessage();
		// System.out.println("The answer is "
		// + rtmsg.getReturnObject().toString());
		// }
		// } catch (MyRemoteException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}
}
