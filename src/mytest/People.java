/**
 * 
 */
package mytest;

import java.io.Serializable;

public class People implements Serializable{
	String name;
	int society_id;
	String address;
	
	public People(String name, int sid, String address) {
		this.name = name;
		this.society_id = sid;
		this.address = address;
	}
}