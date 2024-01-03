import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) 
	{
		try
		{	
			Socket soc = new Socket("localhost", 1234);
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter the id : ");
			int id = scan.nextInt();
			
			dos.writeInt(id);
			
			String name = dis.readUTF();
			int age = dis.readInt();
			System.out.print("Id : " + id + " Name : " + name + " Age : " + age);
			
			soc.close();
			dis.close();
			dos.close();
		}
		catch(Exception e)
		{
			System.out.println("Client : " + e.getMessage());
		}
		
	}
}
