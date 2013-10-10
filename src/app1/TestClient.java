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

	public static void test_compute(String[] args) {

		try {
			String hostIP = null;
			int hostPort = 0;
			 
			if(args.length != 2) {
				System.out.println("Usage: TestClient <RegistryIP> <RegistryPort>");
				return;
			}
			
			hostIP = args[0];
			hostPort = Integer.parseInt(args[1]);
			
			Registry registry = LocateRegistry.getRegistry(hostIP, hostPort);
			Compute cs = (Compute) registry.lookup("app1.Computation");
			while (true) {
				int i = Integer.parseInt(System.console().readLine(
						"Enter an int i\n"));
				int j = Integer.parseInt(System.console().readLine(
						"Enter an int j > i\n"));
				System.out.println("Sum from "+i+" to "+j+" is " + cs.computeSum(i, j));
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

		TestClient.test_compute(args);

	}
}
