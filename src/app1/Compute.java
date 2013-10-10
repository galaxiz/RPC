
package app1;

import exception.MyRemoteException;
import remoteinterface.Remote;


/**
 * @author Shiwei Dong
 *
 */
public interface Compute extends Remote{
	public int computeFactorial(int i) throws MyRemoteException;
	//comput i + i+1, ....+ j
	public int computeSum(int i, int j) throws MyRemoteException;
}
