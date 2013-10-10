/**
 * 
 */
package app2;

import java.io.Serializable;

/**
 * @author air
 * 
 */
public class ZipCodeList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1851259944776557461L;

	String city;
	String ZipCode;
	ZipCodeList next;

	public ZipCodeList(String c, String z, ZipCodeList n) {
		city = c;
		ZipCode = z;
		next = n;
	}
}