import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
public static void main(String[] args) {
		
		try
		{
			ServerSocket ser = new ServerSocket(1234); //Server created
			
			System.out.println("\n\n Server is waiting.....");
			
			Socket client = ser.accept();
			
			InetAddress ip = client.getInetAddress();
			System.out.println("CLIENT NAME : " + ip.getHostName());
			System.out.println("CLIENT ADDRESS : " + ip.getHostAddress());
			
			System.out.println("\n\n Client Connected.....");
			
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			
			String msg = dis.readUTF();
			
			StringBuffer sb = new StringBuffer(msg);
			msg = sb.reverse().toString();
			
			dos.writeUTF(msg);
			
			ser.close();
		}
		catch(Exception e)
		{
			System.out.println("\n CLIENT ERROR : " + e.getMessage());
		}

	}
}
