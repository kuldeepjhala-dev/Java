import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class myDatabase {

	public static void main(String[] args) {
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); //To activate Driver	
			System.out.println("Driver Activated");
			//ctrl+shift+O => to fetch imports
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1&useConfigs=maxPerformance","root","");
			//above line tells that we have connected driver with database. Thus connection is established.
			System.out.println("Connection Established");
			
			Statement st = con.createStatement();
			
//			------------------------------------------------DELETE
			
//			Scanner scan = new Scanner(System.in);
//			int id;
//			String name;
//			int age;
//			System.out.println("\n Enter id:");
//			id = scan.nextInt();
//			st.executeUpdate("delete from student24 where sid = "+id);
			
//			-------------------------------------------------INSERT
//			Scanner scan = new Scanner(System.in);
//			int id;
//			String name;
//			int age;
//			System.out.println("\n Enter ID - Name - Age : ");
//			id = scan.nextInt();
//			name=scan.next();
//			age=scan.nextInt();
//			st.executeUpdate("insert into student24 values("+id+", '"+name+"', "+age+")");
			
			//-----------------------------------------------iterate
			
//			ResultSet rs = st.executeQuery("select * from student24");
//			ResultSetMetaData rsm = rs.getMetaData();		
//			//it is used to fetch extra info about fetched data
//			System.out.println("\n Table Name : "+rsm.getTableName(1));
//			System.out.print("\n No of Columns: " + rsm.getColumnCount());
//			for(int i = 1; i <= rsm.getColumnCount(); i++) 
//			{
//				System.out.println("\n " + rsm.getColumnName(i)+"   =   "+rsm.getColumnTypeName(i));
//			}
//			while(rs.next()) 
//			{
//				int a = rs.getInt(1);
//				String b = rs.getString(2);
//				int c = rs.getInt(3);
//				System.out.println("\n "+a+" ,  "+b+" ,  "+c);
//			}
//			rs.close();
			
//			-------------------------------------------
			st.close();
			con.close();
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		

	}

}
