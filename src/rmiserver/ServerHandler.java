package rmiserver;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

import registry.Registry;
import remoteinterface.Remote_Stub;

/**
 * @author Shiwei Dong
 * 
 *         Generate the stub encapsulate a CM in it Bind the stub to the
 *         register.
 * 
 */
public class ServerHandler implements Runnable {

	String serverClassName;
	String serverClassStubName;
	Registry registry;
	String hostIP;

	public ServerHandler(Registry registry, String classname, String stubname, String hostIP){
		this.registry = registry;
		this.serverClassName = classname;
		this.serverClassStubName = stubname;
		this.hostIP = hostIP;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		try {
			ServerSocket ss = new ServerSocket(0);
			int port = ss.getLocalPort();
			Class stub = Class.forName(serverClassStubName);
			Remote_Stub rstub = (Remote_Stub) stub.newInstance();
			rstub.setCM(hostIP, port);

			// Initialize remote server object
			Class sobj = Class.forName(serverClassName);
			Object serverObj = sobj.newInstance();

			// register stub to registry
			registry.rebind(serverClassName, rstub);

			// start service
			while (true) {
				Socket test = ss.accept();
				// start a new thread for each connection args(socket, obj)
				Runnable client_connection = new ClientHandler(test, serverObj);
				Thread t = new Thread(client_connection);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
