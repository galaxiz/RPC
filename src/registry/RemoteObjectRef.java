package registry;

import java.io.Serializable;
import java.net.URL;

import remote.Remote_Stub;

public class RemoteObjectRef implements Serializable{
	String ip;
	int port;
	int objKey;
	String interfaceName;
	URL url;
	Remote_Stub st;

	public RemoteObjectRef(URL u,Remote_Stub stub){
		url=u;
		st=stub;
	}

	Object stub(){
		return st;
	}
	
	public void setServerHost(String host){
		st.setServerHost(host);
	}
}
