/**
 * 
 */
package mytest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import rmimessage.RMIInvocationMSG;
import rmimessage.RMIReturnMSG;
import communication.ServerCM;
import exception.MyRemoteException;

/**
 * @author air
 * 
 */
public class test {

	public void sayhello(String a, String b, String c) {
		System.out.println("Hello, " + a + " I am " + b + ". Go to " + c);
	}

	public String whoareyou(People a, People b) {
		StringBuilder s = new StringBuilder();
		s.append("I am " + a.name + "\n");
		s.append("I live in " + a.address + "\n");
		s.append("My id is " + a.society_id + "\n");
		s.append("Who are you?" + "\n");
		s.append("I am " + b.name + "\n");
		s.append("I live in " + b.address + "\n");
		s.append("My id is " + b.society_id + "\n");
		System.out.println("I am " + a.name);
		System.out.println("I live in " + a.address);
		System.out.println("My id is " + a.society_id);
		System.out.println("Who are you?");
		System.out.println("I am " + b.name);
		System.out.println("I live in " + b.address);
		System.out.println("My id is " + b.society_id);
		return s.toString();
	}

	public static void readandexcute(String filename) {
		try {
			test t = new test();
			FileInputStream i = new FileInputStream(filename);
			ObjectInputStream is = new ObjectInputStream(i);
			RMIInvocationMSG msg = (RMIInvocationMSG) is.readObject();
			msg.invoke(t);
			RMIReturnMSG rtnmsg = msg.getReturnMessage();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void serialize() {
		try {
			FileOutputStream f = new FileOutputStream("test.ser");
			ObjectOutputStream os = new ObjectOutputStream(f);
			String[] s = { "David", "Chales", "Cafe" };
			RMIInvocationMSG rmimsg = new RMIInvocationMSG("mytest.test",
					"sayhello", new Class[] { String.class, String.class,
							String.class }, (Object[]) s);
			os.writeObject(rmimsg);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void serialize2() {
		try {
			FileOutputStream f = new FileOutputStream("test1.ser");
			ObjectOutputStream os = new ObjectOutputStream(f);
			Object[] s = new Object[2];
			s[0] = new People("Ari", 15213, "500 Forbes Street");
			s[1] = new People("Greg", 15640, "Cyert Hall");
			RMIInvocationMSG rmimsg = new RMIInvocationMSG("mytest.test",
					"whoareyou", new Class[] { People.class, People.class },
					(Object[]) s);
			os.writeObject(rmimsg);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static void main(String args[]){
//		ServerCM scm = new ServerCM(1234);
//		scm.startServer();
//		while (true) {
//			RMIInvocationMSG msg;
//			try {
//				msg = (RMIInvocationMSG) scm.receiveMessage();
//				test t = new test();
//				msg.invoke(t);
//				RMIReturnMSG rtnmsg = msg.getReturnMessage();
//				scm.sendMessage(rtnmsg);
//			} catch (MyRemoteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

}
