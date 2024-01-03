import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) {
		
		try
		{
			ServerSocket ser = new ServerSocket(1234);
			System.out.println("Server Created.");
			Socket client = ser.accept();
			System.out.println("Client Connected.");
			
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			
			
		}
		catch(Exception e)
		{
			System.out.println("Server : " + e.getMessage());
		}

	}

}
