package registry;

import java.io.*;
import java.net.*;

import remoteinterface.Remote;
import rmimessage.RegistryMsg;

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
		RegistryMsg msg=null;
		/*
		 * set service name
		 */
		
		MsgLib.SendMsg(sk, msg);

		System.out.println("command and service name sent.");

		// branch according to the answer.
		msg=MsgLib.RecvMsg(sk);
		
		RemoteObjectRef ro;

		if (true){//res.equals("found")) {

			System.out.println("it is found!.");

			// receive ROR data, witout check.
//			String ro_IPAdr = in.readLine();
//
//			System.out.println(ro_IPAdr);
//
//			int ro_PortNum = Integer.parseInt(in.readLine());
//
//			System.out.println(ro_PortNum);
//
//			int ro_ObjKey = Integer.parseInt(in.readLine());
//
//			System.out.println(ro_ObjKey);
//
//			String ro_InterfaceName = in.readLine();
//
//			System.out.println(ro_InterfaceName);
//
//			// make ROR.
//			ro = new Remote(ro_IPAdr, ro_PortNum, ro_ObjKey,
//					ro_InterfaceName);
		} else {
			System.out.println("it is not found!.");

			ro = null;
		}

		// close the socket.
		sk.close();

		// return ROR.
		return null;
	}

	// rebind a ROR. ROR can be null. again no check, on this or whatever.
	// I hate this but have no time.
	public void rebind(String serviceName, RemoteObjectRef ror)
			throws IOException {
		// open socket. same as before.
		Socket soc = new Socket(host, port);
		
		
		// it is a rebind request, with a service name and ROR.
//		out.println("rebind");
//		out.println(serviceName);
//		out.println(ror.IP_adr);
//		out.println(ror.Port);
//		out.println(ror.Obj_Key);
//		out.println(ror.Remote_Interface_Name);
//
//		// it also gets an ack, but this is not used.
//		String ack = in.readLine();
//
//		// close the socket.
//		soc.close();
	}
}
