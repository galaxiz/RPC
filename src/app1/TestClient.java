/**
 * 
 */
package app1;

import java.io.IOException;

import app2.ZipCodeServer;
import registry.LocateRegistry;
import registry.Registry;
import rmimessage.RMIInvocationMSG;
import rmimessage.RMIReturnMSG;
import communication.ClientCM;
import exception.MyRemoteException;

/**
 * @author air
 * 
 */
public class TestClient {

	public static void test_compute() {

		try {
			Registry registry = LocateRegistry.getRegistry("127.0.1.1", 1099);
			Computation cs = (Computation) registry.lookup("app1.Computation");
			System.out.println("Sum from 1 to 100 is " + cs.computeSum(1, 100));
			while (true) {
				int a = Integer.parseInt(System.console().readLine(
						"Enter a int to compute factorial\n"));
				System.out.println(cs.computeFactorial(a));
			}
		} catch (MyRemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {

		TestClient.test_compute();

	}
}
