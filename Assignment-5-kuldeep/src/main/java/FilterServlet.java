import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FilterServlet")
public class FilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?characterEncoding=latin1&useConfigs=maxPerformance", "root","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from bookstore");
			while(rs.next()) {
				out.print("Book Id : "+rs.getInt(1)+"\nBook Name : "+rs.getString(2)+"\nAuthor Name : "+rs.getString(3)+"\nPublication : "+rs.getString(4)+"\nDate of publication : "+rs.getString(5)+"\nPrice : Rs."+rs.getInt(6)+"\nTotal Quantity : "+rs.getInt(7)+"\n");
			}
		}
		catch(Exception e) {
			System.out.println("Servlet Error : "+e.getMessage());
		}
	}

}
