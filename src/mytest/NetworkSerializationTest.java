/**
 * 
 */
package mytest;

import rmimessage.RMIInvocationMSG;
import rmimessage.RMIReturnMSG;
import communication.ClientCM;

/**
 * @author air
 *
 */
public class NetworkSerializationTest {
	
	public static void ntwktest() {
		try {
			ClientCM c = new ClientCM("127.0.1.1", 1234);
			Object [] s = new Object[2];
			s[0] = new People("Ari", 15213, "500 Forbes Street");
			s[1] = new People("Greg", 15640, "Cyert Hall");
			RMIInvocationMSG rmimsg = new RMIInvocationMSG("mytest.test", "whoareyou", new Class[] {
					People.class, People.class }, (Object[]) s);
			while (true) {
				if (System.console().readLine("press a button\n").equals("exit")) {
					c.endCM();
					break;
				}
				c.sendMessage(rmimsg);
				RMIReturnMSG rtm = (RMIReturnMSG) c.receiveMessage();
				System.out.print(rtm.getReturnObject().toString());				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ntwktest();
	}

}
