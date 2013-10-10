package registry;

import java.io.*;
import java.net.*;

import rmimessage.RegistryMsg;

public class LocateRegistry {
	public static Registry getRegistry(String host, int port) {
		// open socket.
		try {
			Socket sk = new Socket(host, port);

			ObjectOutputStream out=new ObjectOutputStream(
					sk.getOutputStream());
			ObjectInputStream in=new ObjectInputStream(
					sk.getInputStream());
			
			
			RegistryMsg msg=new RegistryMsg();
			
			// ask.
			out.writeObject(msg);

			// gets answer.
			msg=(RegistryMsg)in.readObject();
			
			/*
			 * check response
			 */
			if (true) {
				return new Registry(host, port);
			} else {
				System.out.println("somebody is there but not a  registry!");
				return null;
			}
		} catch (Exception e) {
			System.out.println("nobody is there!" + e);
			return null;
		}
	}
}
