package registryserver;

import java.net.*;

import registry.MsgLib;
import registry.RemoteObjectRef;
import remoteinterface.Remote;
import remoteinterface.Remote_Stub;
import rmimessage.RegistryMsg;
import rmimessage.Message;
import communication.*;

/**
 * 
 * @author xi
 *
 * RMI Registry server, contacted by client first.
 * 
 * Client will use registry object to contact this server.
 */
public class RegistryServer {
	int port;
	StubManager stubmanager;

	public RegistryServer(int port) {
		this.port = port;
		this.stubmanager = new StubManager();
	}

	public void serve() {
		/*
		 * init stub registry table
		 */
		stubmanager.init();

		try {
			/*
			 * start serving
			 */
			ServerSocket sk = new ServerSocket(port);

			while (true) {
				final Socket cs = sk.accept();

				new Thread(new Runnable() {
					public void run() {
						try {
							clientHandler(cs);
						}
						catch(Exception e){
							System.out.println("Message handle failed");
						}
					}
				}).run();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void clientHandler(Socket client) throws Exception {
		/*
		 * get parsed message
		 */
		RegistryMsg msg = MsgLib.RecvMsg(client);

		/*
		 * handle
		 */
		msgHandler(client, msg);
	}

	void msgHandler(Socket client,RegistryMsg msg) throws Exception{
		switch(msg.type){
		case GetReg:
			msg=new RegistryMsg(RegistryMsg.Type.OK,null,null);
			MsgLib.SendMsg(client, msg);
			break;
			
		case GetStub:			
			System.out.println("Get stub:"+msg.info);
			RemoteObjectRef rof=stubmanager.getStub(msg.info);
			msg=new RegistryMsg(RegistryMsg.Type.OK,null,rof);
			
			/*
			 * if null, handled by client registry part.
			 */
			MsgLib.SendMsg(client, msg); 
			
			break;
			
		case PutStub:
			System.out.println("Put stub:"+msg.info);
			System.out.println("New get op");
			String name=msg.info;
			boolean correctInterface=true;
			
			Remote_Stub stub=null;
			try {
				stub = (Remote_Stub) msg.object;
			}
			catch(Exception e){
				System.out.println("Remote interface not implemented.");
				correctInterface=false;
			}
			
			if(!correctInterface){
				msg=new RegistryMsg(RegistryMsg.Type.Error,null,null);			
				MsgLib.SendMsg(client, msg);
			}
			
			//TODO
			RemoteObjectRef rof1=new RemoteObjectRef(null,stub);
			
			stubmanager.rebindStub(name, rof1);
			
			msg=new RegistryMsg(RegistryMsg.Type.OK,null,null);			
			MsgLib.SendMsg(client, msg);
			
			break;
		default:
			break;
		}
	}

	public static void main(String args[]) {
		int port = 1099;

		if (args.length == 1) {
			port = Integer.parseInt(args[0]);
		}
		/*
		 * starting a RegistryServer object
		 */
		RegistryServer rs = new RegistryServer(port);

		rs.serve();
	}
}