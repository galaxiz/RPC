package rmiregistryserver;

import java.net.*;

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
		RegistryMsg msg=null;
		
		/*
		 * handle
		 */
		msgHandler(client,msg);
	}
	
	void msgHandler(Socket client,RegistryMsg msg){
		switch(msg.type){
		case GetReg:
			break;
		case GetStub:
			break;
		case PutStub:
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