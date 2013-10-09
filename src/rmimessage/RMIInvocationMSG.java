package rmimessage;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Shiwei The RMImessage class encapsulate an invocation including class
 *         name, method name and arguments
 */
public class RMIInvocationMSG extends RMImessage implements Serializable {
	private String class_name;
	private String method_name;
	private Class[] parameterTypes;
	private Object[] arguments;
	private RMIReturnMSG rtnmsg;

	public RMIInvocationMSG(String cn, String method, Class[] paraTypes,
			Object[] objects) {
		class_name = cn;
		method_name = method;
		arguments = objects;
		parameterTypes = paraTypes;
	}

	/**
	 * invoke Oct 9, 2013 
	 * Unmarshall the RMImessage and invoke the real method
	 */
	public void invoke(Object obj) {
		try {
			Class c = Class.forName(class_name);
			Method method = c.getMethod(method_name, parameterTypes);
			Class returntype = method.getReturnType();
			Object returnobject = method.invoke(obj, arguments);
			rtnmsg =  new RMIReturnMSG(returntype, returnobject);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Oct 9, 2013
	 * This method returns a RMIreturnmessage object which encapsulate an
	 * RMIreturnmessage
	 * @return RMIreturnmessage
	 */
	public RMIReturnMSG getReturnMessage() {
		return rtnmsg;
	}
}
