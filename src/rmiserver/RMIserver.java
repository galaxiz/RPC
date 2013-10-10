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

	public RMIserver() {
		try {
			hostServerIP = Inet4Address.getLocalHost().getHostAddress();
			prompt = prompt + "@" + hostServerIP + ">";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

		RMIserver myserver = new RMIserver();

		try {
			Registry registry;
			registry = LocateRegistry.getRegistry(Inet4Address.getLocalHost()
					.getHostAddress(), 1099);

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
							class_stub_name);
					Thread t = new Thread(job);
					t.start();
				} else if (cmdargs[0].equals("exit")) {
					System.out.println("Server Exisiting...");
					break;
				} else {
					myserver.printUsage();
				}
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
