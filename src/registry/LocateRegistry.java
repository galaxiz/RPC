package registry;

import java.io.*;
import java.net.*;

import rmimessage.RegistryMsg;

/**
 * 
 * @author xi
 *
 * Used by both object server and client to contact registry server,
 * register stubs, and lookup stubs.
 */
public class LocateRegistry {
	public static Registry getRegistry() {
		return getRegistry("localhost",1099);
	}
	
	public static Registry getRegistry(String host) {
		return getRegistry(host,1099);
	}
	
	public static Registry getRegistry(String host, int port) {
		// open socket.
		try {			
			Socket sk = new Socket(host, port);
			
			ObjectOutputStream out=new ObjectOutputStream(
					sk.getOutputStream());
									
			RegistryMsg msg=new RegistryMsg(RegistryMsg.Type.GetReg,null,null);
			
			// ask.
			out.writeObject(msg);

			ObjectInputStream in=new ObjectInputStream(
					sk.getInputStream());			
			// gets answer.
			msg=(RegistryMsg)in.readObject();
			
			/*
			 * check response
			 */
			if (msg.type==RegistryMsg.Type.OK) {
				return new Registry(host, port);
			} else {				
				return null;
			}
		} catch (Exception e) {
			System.out.println("No registry server found.");
			e.printStackTrace();
			return null;
		}
	}
}
