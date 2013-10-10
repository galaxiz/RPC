package registryserver;

import java.util.*;

import registry.RemoteObjectRef;

public class StubManager {
	Map<String,RemoteObjectRef> mg=null;
	
	public StubManager(){
		mg=new HashMap<String,RemoteObjectRef>();
	}
	
	public void init(){
		mg.clear();
	}
	
	public void rebindStub(String name, RemoteObjectRef object){
		mg.put(name, object);
	}
	
	public void delStub(String name){
		mg.remove(name);
	}
	
	public RemoteObjectRef getStub(String name){
		return mg.get(name);		
	}
}
