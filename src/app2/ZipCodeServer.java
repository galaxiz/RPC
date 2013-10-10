/**
 * 
 */
package app2;

import exception.MyRemoteException;
import remoteinterface.Remote;

/**
 * @author air
 *
 */
public interface ZipCodeServer extends Remote
{
    public void initialise(ZipCodeList newlist) throws MyRemoteException;
    public String find(String city) throws MyRemoteException;
    public ZipCodeList findAll() throws MyRemoteException;
    public void printAll() throws MyRemoteException;
}