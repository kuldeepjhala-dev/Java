import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCUpdate {

	JDBCUpdate(int updateId, int id, String name, String author, String pub, String dop, int price, int quantity,
			int cost) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");	
			System.out.println("Driver Activated");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?characterEncoding=latin1&useConfigs=maxPerformance","root","");
			System.out.println("Connection Established");
			Statement st = con.createStatement();
			st.executeUpdate("update bookstore set name = '"+name+"', author='"+author+"', pub='"+pub+"', dop='"+dop+"', price="+price+", quantity="+quantity+", cost="+cost+" where id = "+updateId);
		}
		catch(Exception e)
		{
			System.out.println("FileUpdate.java => " + e.getMessage());
		}	
	}
}
