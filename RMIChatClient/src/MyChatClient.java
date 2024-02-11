import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

interface iChat extends Remote {
	String message(String s)throws RemoteException;
}

public class MyChatClient {

	public static void main(String[] args) {
		
		try
		{
//			System.out.println("5");
			iChat ic = (iChat) Naming.lookup("rmi://localhost:1122/myUser");
			Scanner sc = new Scanner(System.in);
//			System.out.println("6");
//			System.out.println("7");
			System.out.println("Client input: ");
			String clientMessage = sc.nextLine();
			String serverMessage = ic.message(clientMessage);
//			System.out.println("8");
			System.out.println("Server : " + serverMessage);
//			System.out.println("9");
			
		}
		catch(Exception e)
		{
			System.out.println("Client : " + e );
		}
	}
}
