package registryserver;

import java.net.*;

import registry.MsgLib;
import registry.RemoteObjectRef;
import remoteinterface.Remote;
import rmimessage.RegistryMsg;
import rmimessage.RMImessage;
import communication.*;

public class RegistryServer {
	int port;
	StubManager stubmanager;
	
	public RegistryServer(int port){
		this.port=port;
		this.stubmanager=new StubManager();
	}
	
	public void serve(){
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
						clientHandler(cs);
					}
				}).run();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void clientHandler(Socket client){
		/*
		 * get parsed message
		 */
		RegistryMsg msg=MsgLib.RecvMsg(client);
		
		/*
		 * handle
		 */
		msgHandler(client,msg);
	}
	
	void msgHandler(Socket client,RegistryMsg msg){
		switch(msg.type){
		case GetReg:
			msg=new RegistryMsg(RegistryMsg.Type.OK,null,null);
			MsgLib.SendMsg(client, msg);
			break;
			
		case GetStub:
			RemoteObjectRef rof=stubmanager.getStub(msg.info);
			msg=new RegistryMsg(RegistryMsg.Type.OK,null,rof);
			
			MsgLib.SendMsg(client, msg);
			break;
			
		case PutStub:
			String name=msg.info;
			Remote stub=(Remote)msg.object;
			
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
	
	public static void main(String args[]){
		int port=1099;
		
		if(args.length==1){
			port=Integer.parseInt(args[0]);
		}
		/*
		 * starting a RegistryServer object
		 */
		RegistryServer rs=new RegistryServer(port);
		
		rs.serve();
	}
}