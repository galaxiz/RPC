package rmimessage;

/**
 * @author xi
 */
public class RegistryMsg extends Message {
	public enum Type{
		GetReg,GetStub,PutStub,Error,OK
	};
	
	public Type type;

	public String info;
	
	public Object object;	
	
	public RegistryMsg(Type t,String in,Object obj){
		type=t;
		info=in;
		object=obj;
	}
}
