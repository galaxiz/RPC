/**
 * 
 */
package rmiserver;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import registry.LocateRegistry;
import registry.Registry;

/**
 * @author Shiwei Dong
 * 
 *         RMI server responsible for register objects to registry and assign
 *         ports to remote objects
 * 
 */
public class RMIserver {

	private String prompt = "Server";
	private String hostServerIP;

	public RMIserver(String ip) {
			hostServerIP = ip;
			prompt = prompt + "@" + hostServerIP + ">";
	}

	public void printUsage() {
		StringBuilder usage = new StringBuilder();
		usage.append("Usage:\n");
		usage.append("register <server_class_name(without.class)> ... Register a server class\n");
		usage.append("exit ... Exit the server\n");
		System.out.print(usage);
	}

	/**
	 * @return the prompt
	 */
	public String getPrompt() {
		return prompt;
	}

	/**
	 * Oct 9, 2013
	 * 
	 * Arguments are Registry port and Registry host Connect to the Registry use
	 * LocateRegistry.getRegistry(host,port) Every time a new user server
	 * program register, Initialize a stub Rebind the service name and the stub,
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {

		String registryHost;
		int registryPort;
		String localIP = "127.0.1.1";
		try {
			localIP = Inet4Address.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(args.length == 2) {
			registryHost = args[0];
			registryPort = Integer.parseInt(args[1]);
		} else if (args.length == 3) {
			registryHost = args[0];
			registryPort = Integer.parseInt(args[1]);
			localIP = args[2];
		} else {
			System.out.print("Usage: java RMIserver <Registry host> <Registry port> [ServerIP]");
			return;			
		}
		RMIserver myserver = new RMIserver(localIP);

		Registry registry;
		registry = LocateRegistry.getRegistry(registryHost, registryPort);

		while (true) {
			System.out.print(myserver.getPrompt());
			String cmdl = System.console().readLine();
			String cmdargs[] = cmdl.split(" ");
			if (cmdargs[0].equals("register")) {
				String class_name = cmdargs[1];
				String class_stub_name = cmdargs[1] + "_stub";
				// start a new thread to handle this particular server
				// object
				Runnable job = new Server_handler(registry, class_name,
						class_stub_name, localIP);
				Thread t = new Thread(job);
				t.start();
			} else if (cmdargs[0].equals("exit")) {
				System.out.println("Server Exisiting...");
				break;
			} else {
				myserver.printUsage();
			}
		}
	}

}