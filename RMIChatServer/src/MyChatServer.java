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
	
	public String message(String clientMessage) throws RemoteException
	{
//		System.out.println("4");
//		s = s + s;
		Scanner sc = new Scanner(System.in);
		System.out.println("Client : " + clientMessage);
		System.out.println("Server input : ");
		String serverMessage = sc.nextLine();
		return serverMessage;
	}

	public static void main(String[] args) throws RemoteException{
		
		MyChatServer ms = new MyChatServer();
		
		try
		{
//			System.out.println("1");
			Registry reg = LocateRegistry.createRegistry(1122);
//			System.out.println("2");
			reg.bind("myUser", ms);
//			System.out.println("3");
		}
		catch(Exception e)
		{
			System.out.println("Client : " + e );
		}

	}

}
