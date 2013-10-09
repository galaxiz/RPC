package rmimessage;

/**
 * @author xi
 */
public class RMIRegistryMsg extends RMImessage {
	public enum Type{
		GetReg,GetStub,PutStub
	};
	
	public Type type;
}
