/**
 * 
 */
package testfactorial;

import exception.RemoteException;

/**
 * @author Shiwei Dong
 * 
 */
public class Computation implements Compute {

	public int computeFactorial(int i) throws RemoteException{
		if (i <= 0)
			return 0;
		if (i == 1)
			return i;
		return computeFactorial(i - 1) * i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see app1.Compute#computeSum(int, int)
	 */
	@Override
	public int computeSum(int i, int j) throws RemoteException {
		if (i > j)
			return -1;
		else {
			return (i+j)*(j-i+1)/2;
		}
	}
}
