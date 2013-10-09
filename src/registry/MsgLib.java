package registry;

import java.io.*;
import java.net.Socket;

import rmimessage.RMIRegistryMsg;

public class MsgLib {
	public static boolean SendMsg(Socket socket,RMIRegistryMsg msg){
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
	
	public static RMIRegistryMsg RecvMsg(Socket socket){
		try{
			ObjectInputStream in=new ObjectInputStream(
					socket.getInputStream());
			
			RMIRegistryMsg msg=(RMIRegistryMsg)in.readObject();
			
			return msg;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
