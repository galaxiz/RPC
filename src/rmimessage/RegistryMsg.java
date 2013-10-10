package rmimessage;

/**
 * @author xi
 */
public class RegistryMsg extends RMImessage {
	public enum Type{
		GetReg,GetStub,PutStub
	};
	
	public Type type;
}
