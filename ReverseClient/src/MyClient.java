import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) {
		
		try
		{
			Socket soc = new Socket("localhost",1234); 
			
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			
			System.out.println("\n\n Enter the string : ");
			
			Scanner sc = new Scanner(System.in);
			
			String msg = sc.nextLine();
			
			dos.writeUTF(msg);
			
			String reversedString = dis.readUTF();
			
			System.out.println("\n\n Reverse String :  " + reversedString);
			
			soc.close();
		}
		catch(Exception e)
		{
			System.out.println("\n CLIENT ERROR :  " + e.getMessage());
		}

	}

}
