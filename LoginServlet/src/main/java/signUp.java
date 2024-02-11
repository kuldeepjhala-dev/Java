
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signUp
 */
@WebServlet("/signUp")
public class signUp extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sub = request.getParameter("n");
		if (sub.equals("SignUp")) {
			request.getRequestDispatcher("signUp.html").forward(request, response);
		}
		if (sub.equals("Login")) {

			String uname = request.getParameter("userName");
			String upass = request.getParameter("password");

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/db24?characterEncoding=latin1&useConfigs=maxPerformance", "root",
						"");
				Statement st = con.createStatement();
				ResultSet rs = st
						.executeQuery("select * from user where uname='" + uname + "' and upass='" + upass + "'");

				int flag = 0;
				while (rs.next()) {
					flag = 1;
					System.out.println("Uname : " + rs.getString(1));
				}
				if (flag == 0) {
					System.out.println("Doesn't Exist");
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
