/**
 * 
 */
package app2;

//a client for ZipCodeServer.
//it uses ZipCodeServer as an interface, and test
//all methods.

//It reads data from a file containing the service name and city-zip 
//pairs in the following way:
//city1
//zip1
//...
//...
//end.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import registry.LocateRegistry;
import registry.Registry;
import registry.RemoteObjectRef;
import remoteinterface.Remote;
import exception.MyRemoteException;

public class ZipCodeClient { 

 // the main takes three arguments:
 // (0) a host. 
 // (1) a port.
 // (2) a service name.
 // (3) a file name as above. 
 public static void main(String[] args) 
	throws IOException
 {
//	String host = args[0];
//	int port = Integer.parseInt(args[1]);
//	String serviceName = args[2];
	BufferedReader in = new BufferedReader(new FileReader(args[0]));

	// locate the registry and get ror.
	Registry registry = 
	    LocateRegistry.getRegistry("127.0.1.1", 1099);
	ZipCodeServer zcs = (ZipCodeServer)registry.lookup("app2.ZipCodeServer");
	
	// get (create) the stub out of ror.
//	ZipCodeServerImpl_stub a = new ZipCodeServerImpl_stub();
	//a.setCM("127.0.1.1", Integer.parseInt(args[0]));
	//ZipCodeServer zcs = (ZipCodeServer) a;

	// reads the data and make a "local" zip code list.
	// later this is sent to the server.
	// again no error check!
	ZipCodeList l = null;
	boolean flag = true;
	while (flag)
	    {
		String city = in.readLine();
		String code = in.readLine();
		if (city == null)
		    flag = false;
		else
		    l = new ZipCodeList(city.trim(), code.trim(), l);
	    }
	// the final value of l should be the initial head of 
	// the list.
	
	// we print out the local zipcodelist.
	System.out.println("This is the original list.");
	ZipCodeList temp = l;
	while (temp !=null)            
	    {
		System.out.println
		    ("city: "+temp.city+", "+
		     "code: "+temp.ZipCode);       
		temp = temp.next;                        
	    }
	
	// test the initialise.
	try {
		zcs.initialise(l);
	} catch (MyRemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("\n Server initalised.");

	// test the find.
	System.out.println("\n This is the remote list given by find.");
	temp = l;
	while (temp !=null)
	    {
		// here is a test.
		String res;
		try {
			res = zcs.find(temp.city);
			System.out.println("city: "+temp.city+", "+
					"code: "+res);
			temp=temp.next;
		} catch (MyRemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }        		
	
	// test the findall.
	System.out.println("\n This is the remote list given by findall.");
	// here is a test.
	try {
		temp = zcs.findAll();
	} catch (MyRemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	while (temp !=null)
	    {
		System.out.println
		    ("city: "+temp.city+", "+
		     "code: "+temp.ZipCode);
		temp=temp.next;
	    }        		
	
	// test the printall.
	System.out.println("\n We test the remote site printing.");
	// here is a test.
	try {
		zcs.printAll();
	} catch (MyRemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
