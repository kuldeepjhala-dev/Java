import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDelete {
	JDBCDelete(int id) {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");	
			System.out.println("Driver Activated");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?characterEncoding=latin1&useConfigs=maxPerformance","root","");
			System.out.println("Connection Established");
			Statement st = con.createStatement();
			st.executeUpdate("delete from bookstore where id = "+id);
		}
		catch(Exception e)
		{
			System.out.println("FileInsert.java => " + e.getMessage());
		}
	}
}