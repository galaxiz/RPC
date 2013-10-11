
package testfactorial;

import exception.RemoteException;
import remote.Remote;


/**
 * @author Shiwei Dong
 *
 */
public interface Compute extends Remote{
	public int computeFactorial(int i) throws RemoteException;
	//comput i + i+1, ....+ j
	public int computeSum(int i, int j) throws RemoteException;
}
