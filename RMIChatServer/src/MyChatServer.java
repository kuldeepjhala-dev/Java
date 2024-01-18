import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

interface iChat extends Remote {
	String message(String s)throws RemoteException;
}

public class MyChatServer extends UnicastRemoteObject implements iChat {
	
	MyChatServer() throws RemoteException
	{
		
	}
	
	public String message(String s) throws RemoteException
	{
		Scanner sc = new Scanner(System.in);
		String userMessage = s;
		String serverMessage = sc.nextLine();
		return serverMessage;
	}

	public static void main(String[] args) throws RemoteException{
		
		MyChatServer ms = new MyChatServer();
		
		try
		{
			Registry reg = LocateRegistry.createRegistry(1122);
			reg.bind("myUser", ms);
		}
		catch(Exception e)
		{
			System.out.println("Client : " + e );
		}

	}

}
