import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyReceiver {

	public static void main(String[] args) {
		
		try
		{
			DatagramSocket reciever = new DatagramSocket(1234);
			byte b[] = new byte[1024];
			String msg = "";
			DatagramPacket pack = null;
			
			pack = new DatagramPacket(b, b.length);
			reciever.receive(pack);
			b = pack.getData();
			msg = new String(b);
			
			msg = msg.toUpperCase();
			
			b = msg.getBytes();
			InetAddress ip  = InetAddress.getByName("localhost");
			
			pack = new DatagramPacket(b, b.length,ip,4321);
			reciever.send(pack);
			
		}
		catch(Exception e)
		{
			System.out.println("MyReceiver : " + e.getMessage());
		}	
	}
}