import java.net.InetAddress;

public class MyInet {

	public static void main(String[] args) {
		
		try
		{
			InetAddress ip = InetAddress.getByName("www.google.com");
			
			System.out.print("\n DOMAIN NAME : " + ip.getHostName());
			System.out.print("\n Address : " + ip.getHostAddress());
			System.out.print("\n Localhost : " + ip.getLocalHost());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
