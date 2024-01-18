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
			iChat ic = (iChat) Naming.lookup("rmi://localhost:1122/myUser");
			for(int i = 0; i < 10; i++) 
			{
				Scanner sc = new Scanner(System.in);
				String clientMessage = sc.nextLine();
				String userMessage = ic.message(clientMessage);
				System.out.println(userMessage);
			}
		}
		catch(Exception e)
		{
			System.out.println("Client : " + e );
		}
	}
}
