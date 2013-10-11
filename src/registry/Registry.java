package registry;

import java.io.*;
import java.net.*;

import remote.Remote;
import remote.Remote_Stub;
import rmimessage.RegistryMsg;

/**
 * 
 * @author xi
 *
 * Registry facility used by both client and server, same function as java.rmi.registry
 */
public class Registry {
	String host;
	int port;	

	// ultra simple constructor.
	public Registry(String ipAddr, int portNum) {
		host = ipAddr;
		port = portNum;		
	}

	// returns the ROR (if found) or null (if else)
	public Remote lookup(String serviceName) throws IOException {
		// open socket.
		// it assumes registry is already located by locate registry.
		// you should usually do try-catch here (and later).
		Socket sk = new Socket(host, port);

		System.out.println("socket made.");

		// get TCP streams and wrap them.
		RegistryMsg msg=new RegistryMsg(RegistryMsg.Type.GetStub,serviceName,null);
		
		MsgLib.SendMsg(sk, msg);

		System.out.println("command and service name sent.");

		// branch according to the answer.
		msg=MsgLib.RecvMsg(sk);		

		RemoteObjectRef rof=null;
		Remote ro=null;
		
		if (msg.type==RegistryMsg.Type.OK){
			System.out.println("it is found!.");

			rof=(RemoteObjectRef)msg.object;
			
			/*
			 * need more consideration
			 */			
			rof.setServerHost(host);
			
			ro=(Remote)rof.stub();
		} else {
			System.out.println("it is not found!.");
		}

		// close the socket.
		sk.close();

		// return ROR.
		return ro;
	}

	// rebind a ROR. ROR can be null. again no check, on this or whatever.
	// I hate this but have no time.
	public boolean rebind(String serviceName, Remote ro)
			throws IOException {
		// open socket. same as before.
		Socket sk = new Socket(host, port);
		
		RegistryMsg msg=new RegistryMsg(RegistryMsg.Type.PutStub, serviceName, ro);
		MsgLib.SendMsg(sk, msg);
		
		msg=MsgLib.RecvMsg(sk);
		
		sk.close();
		
		if(msg.type!=RegistryMsg.Type.OK){
			System.out.println("Rebind failed.");
			return false;
		}
		
		return true;
	}
}
