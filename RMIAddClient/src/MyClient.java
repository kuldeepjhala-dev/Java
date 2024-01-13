import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

interface Addition extends Remote {
	int add(int x, int y) throws RemoteException;
	String rev(String s) throws RemoteException;
	String toUpper(String s) throws RemoteException;
}
public class MyClient {

	public static void main(String[] args) {
		
		try
		{
			Addition ad = (Addition) Naming.lookup("rmi://localhost:1122/myadd");
			int c = ad.add(10, 20);
			System.out.println("Additon = " + c);
			String reversed = ad.rev("Kuldeep");
			System.out.println(reversed);
			String lower = "kuldeep";
			String upper = ad.toUpper(lower);
			System.out.println(upper);
		}
		catch(Exception e)
		{
			System.out.println("Client Error : " + e.getMessage());
		}

	}

}
