package rmiserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import remoteinterface.Remote_Stub;

/**
 * 
 * @author xi
 * 
 */
public class RemoteObject {
	public static Remote_Stub exportObject(Object obj, int port) throws IOException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		final int p = port;
		final Object o = obj;
		
		final ServerSocket ss = new ServerSocket(p);
		int hport = ss.getLocalPort();

		Class sobj = o.getClass();

		Class stub = Class.forName(sobj.getName() + "_stub");
		Remote_Stub rstub = (Remote_Stub) stub.newInstance();

		/*
		 * didn't setCM here
		 * 
		 * We leave rstub for registry in client-side to further set
		 * hostname than localhost
		 */
		rstub.setCM("localhost", hport);
		
		/*
		 * start server
		 */
		new Thread(new Runnable() {
			public void run() {
				try {					
					// start service
					while (true) {
						Socket test = ss.accept();
						new Thread(new ClientHandler(test, o)).start();
					}
				} catch (Exception e) {
					System.out.println("Server start failed");
				}
			}
		}).start();
		
		return rstub;
	}
}
