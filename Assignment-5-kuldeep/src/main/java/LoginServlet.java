

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String check = request.getParameter("check");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1&useConfigs=maxPerformance", "root","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from user where uname='"+username+"' and upass='"+password+"'");
			if(rs.next()) {
				if(check!=null && check.equals("keep me"))
				{
					Cookie cookie = new Cookie("allow","direct"); //creates cookie
					response.addCookie(cookie); //stores cookie permanently in client's browser
					request.getRequestDispatcher("/product.html").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("/product.html").forward(request, response);
				}
			}
			else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		catch(Exception e) {
			System.out.println("Login Servlet Error : "+e.getMessage());
		}
	}

}
