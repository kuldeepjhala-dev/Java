import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.util.Enumeration;
import java.util.Scanner;

class DatabaseOperation
{
	Connection con ;
	Statement st;
	int id = 1, age;
	String name;
	
	DatabaseOperation()
	{
		try 
		{
			//TO Activate Driver
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1&useConfigs=maxPerformance","root","");
			st = con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void insert() 
	{
		try 
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter id - name - age");
			id = scan.nextInt();
			name = scan.next();
			age = scan.nextInt();
			st.executeUpdate("insert into student24 values("+id+",'"+name+"',"+age+")");
		}
		catch(Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void delete()
	{
		try 
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter id to delete : ");
			id = scan.nextInt();
			st.executeUpdate("delete from student24 where sid = "+id);
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void update()
	{
		try 
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter id which you want to update : ");
			id = scan.nextInt();
			System.out.println("Enter Name - age");
			name = scan.next();
			age = scan.nextInt();
			st.executeUpdate("update student24 set sna = '"+name+"',sage="+age+" where sid = "+id);
		}
		catch(Exception e) 
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void show() 
	{
		try
		{
			ResultSet rs =  st.executeQuery("select * from student24");
			ResultSetMetaData rsm = rs.getMetaData();
			System.out.println("Table Name : " + rsm.getTableName(1));
			System.out.println("Column Count : " + rsm.getColumnCount());
			for(int i = 1; i <= rsm.getColumnCount(); i++) 
			{
				System.out.print(rsm.getColumnName(i)+"         ");
			}
			while(rs.next()) {
				int a = rs.getInt(1);
				String b = rs.getString(2);
				int c = rs.getInt(3);
				System.out.println(a+" ,  "+b+" ,  "+c);
			}
			rs.close();
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void insertPreparedStatement()
	{
		try 
		{
			PreparedStatement pst = con.prepareStatement("insert into student24 values(?,?,?)");
			
			while(id!=0)
			{
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter id - name - age");
				id = scan.nextInt();
				if(id!=0) 
				{
					name = scan.next();
					age = scan.nextInt();
					
					pst.setInt(1, id);
					pst.setString(2, name);
					pst.setInt(3, age);
					
					pst.execute();
				}
				
			}
			pst.close();
		}
		catch(Exception e)
		{
			
			System.out.println("Error : " + e.getMessage());
		}
		
	}
	
	void updatePreparedStatement()
	{
		try 
		{
			PreparedStatement pst = con.prepareStatement("update student24 set sna = ?,sage=? where sid = ?");
			
			while(id!=0) 
			{
				Scanner scan = new Scanner(System.in);
				System.out.println("Please Enter Id which you want to update.");
				id = scan.nextInt();
				if(id!=0) 
				{
					pst.setInt(3,id);
					name = scan.next();
					age = scan.nextInt();
					
					pst.setString(1, name);
					pst.setInt(2, age);
					
					pst.execute();
				}
				
			}
			pst.close();
				
		}
		catch(Exception e) 
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void deletePreparedStatement()
	{
		try
		{
			PreparedStatement pst = con.prepareStatement("delete from student24 where sid = ?");
			
			while(id!=0) 
			{
				Scanner scan = new Scanner(System.in);
				System.out.println("Please Enter Id which you want to delete.");
				id = scan.nextInt();
				if(id!=0) 
				{
					pst.setInt(1,id);
					pst.execute();
				}
				
			}
			pst.close();
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void updatableResultSet() 
	{
		try
		{
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select * from student1");
			
			rs.absolute(3);
			rs.updateString("sna", "jk");
			rs.updateInt("sag", 56);
			rs.updateRow();
			
			rs.absolute(5);
			rs.updateString("sna", "Naughty_Cutie");
			rs.updateRow();
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void insertInProcedure() 
	{
		try 
		{
			CallableStatement cst  = con.prepareCall("{ call insQ(?,?,?)}");
			cst.setInt(1,15);
			cst.setString(2, "Dunki");
			cst.setInt(3, 30);
			cst.execute();
			cst.close();
		}
		catch(Exception e) 
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void UpdateInProcedure()
	{
		try
		{
			CallableStatement cst = con.prepareCall("{call updQ(?,?,?)}");
			Scanner scan = new Scanner(System.in);
			System.out.println("Please Enter Id which you want to Update.");
			int id = scan.nextInt();
			System.out.println("Enter Name to update.");
			String name = scan.next();
			System.out.println("Enter Age to update");
			int age = scan.nextInt();
			cst.setInt(1,id);
			cst.setString(2, name);
			cst.setInt(3, age);
			cst.execute();
			cst.close();
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void outParameterProcedure() 
	{
		try
		{
			CallableStatement cst = con.prepareCall("{call with_out_para(?,?)}");
			int id;
			Scanner scan = new Scanner(System.in);
			System.out.println("\n Enter id : ");
			id = scan.nextInt();

			cst.setInt(1, id);
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.execute();
			
			System.out.println("\n\n NAME : " + cst.getString(2));
			
			cst.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void insertImage() {
		try 
		{
			FileInputStream fis = new FileInputStream("src//i1.png");
			PreparedStatement pst = con.prepareStatement("insert into imgtab values(?,?);");
			pst.setInt(1, 10);
			pst.setBinaryStream(2, fis);
			pst.execute();
			pst.close();
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void performUsingBatch() {
		try 
		{
			st.addBatch("delete from student24 where sid = 15");
			st.addBatch("insert  into student24 values(10,'apurvaa',404)");
			st.addBatch("update student24 set sna ='kuldeep' where sid = 5");
			st.executeBatch();
			st.close();
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void showDrivers()
	{
		try 
		{
			Enumeration<java.sql.Driver> drivers = DriverManager.getDrivers();
			System.out.print("\n Drivers = " + drivers.hasMoreElements());
			while(drivers.hasMoreElements())
			{
				Driver d = (Driver) drivers.nextElement();
				System.out.println("\n Name : " + d.toString());
				System.out.println("\n Major Version : " + d.getMajorVersion());
				System.out.println("\n Minor Version : " + d.getMinorVersion());
			}
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	void exit() 
	{
		try 
		{
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e.getMessage());
		}	
	}
}

public class DatabaseMain {

	public static void main(String[] args) {
		
		DatabaseOperation op = new DatabaseOperation();
		int i = 0;
		Scanner sc = new Scanner(System.in);
		
		 op.showDrivers();
		while(i!=-1) 
		{
			System.out.println("\n1.Insert:\n2.Update\n3.Delete\n4.show\n5.insert-Prepared\n6.update-Prepared\n7.delete-Prepared\n8.update-Resultset\n9.insert-Procedure\n10.update-Procedure\n11.Procedure-with-output-parameter\n12.Insert-Image\n13.Execute-using-batch\n14.Exit");
			i = sc.nextInt();
			switch (i) 
			{
				case 1: op.insert();
				break;
				case 2: op.update();
				break;
				case 3: op.delete();
				break;
				case 4: op.show();
				break;
				case 5: op.insertPreparedStatement();
				break;
				case 6: op.updatePreparedStatement();
				break;
				case 7: op.deletePreparedStatement();
				break;
				case 8: op.updatableResultSet();
				break;
				case 9: op.insertInProcedure();
				break;
				case 10: op.UpdateInProcedure();
				break;
				case 11: op.outParameterProcedure();
				break;
				case 12: op.insertImage();
				break;
				case 13: op.performUsingBatch();
				break;
				case 14: op.exit();
				i = -1;
				break;
			}
		}
	}
}
