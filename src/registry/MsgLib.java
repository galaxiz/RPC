package registry;

import java.io.*;
import java.net.Socket;

import rmimessage.RegistryMsg;

public class MsgLib {
	public static boolean SendMsg(Socket socket,RegistryMsg msg){
		try{
			ObjectOutputStream out=new ObjectOutputStream(
					socket.getOutputStream());
			
			out.writeObject(msg);
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static RegistryMsg RecvMsg(Socket socket){
		try{
			ObjectInputStream in=new ObjectInputStream(
					socket.getInputStream());
			
			RegistryMsg msg=(RegistryMsg)in.readObject();
			
			return msg;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
