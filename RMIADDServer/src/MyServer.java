import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


interface Addition extends Remote
{
	int add(int x, int y) throws RemoteException;
	String rev(String s) throws RemoteException;
	String toUpper(String s) throws RemoteException;
}

public class MyServer extends UnicastRemoteObject implements Addition
{
	
	MyServer() throws RemoteException
	{
		
	}
	
	public int add(int x, int y)throws RemoteException
	{
		int z;
		z = x+y;
		return z;
	}
	
	public String rev(String s)throws RemoteException
	{
		StringBuffer sb = new StringBuffer(s);
		String reversed_string = sb.reverse().toString();
		return reversed_string;
	}
	
	public String toUpper(String s)throws RemoteException
	{
		return s.toUpperCase();
	}

	public static void main(String[] args) throws RemoteException 
	{
		
		MyServer ms = new MyServer();
		
		try
		{
			Registry reg = LocateRegistry.createRegistry(1122);
			reg.bind("myadd", ms);
		}
		catch(Exception e)
		{
			System.out.println("\n Server Error : " + e.getMessage());
		}

	}

}
