import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MyReceiverClass {

	public static void main(String[] args) {
		
		try
		{
			DatagramSocket receiver = new DatagramSocket(1234);
			byte b[] = new byte[1024];
			String msg = "";
			DatagramPacket pack = null;
			Scanner scan = new Scanner(System.in);
			System.out.println("**********RECEIVER********");
			
			while(true)
			{
				pack = new DatagramPacket(b,b.length);
				receiver.receive(pack);
				b = pack.getData();
				msg = new String(b);
				if(msg == "0") {
					break;
				}
				System.out.println("From Sender : " + msg.toString());
				
				InetAddress ip = InetAddress.getByName("localhost");
				msg = scan.nextLine();
				b = msg.getBytes();
				pack = new DatagramPacket(b,b.length,ip,4321);
				receiver.send(pack);
			}
			
			System.out.println("Receiver chat close");
			
		}
		catch(Exception e)
		{
			System.out.println("Receiver-Error : " + e.getMessage());
		}

	}

}
