/**
 * 
 */
package rmimessage;

import java.io.Serializable;

/**
 * @author Shiwei Dong 
 * RMIreturnmessage is a message type which encapsulate the
 * return value, return type of a RMI call
 */
public class RMIReturnMSG extends RMImessage implements Serializable {
	private Class returnType;
	private Object returnObject;

	public RMIReturnMSG(Class returnType, Object returnObject) {
		this.returnType = returnType;
		this.returnObject = returnObject;
	}
	
	/**
	 * @return the returnType
	 */
	public Class getReturnType() {
		return returnType;
	}
	
	/**
	 * @return the returnObject
	 */
	public Object getReturnObject() {
		return returnObject;
	}
	
}
