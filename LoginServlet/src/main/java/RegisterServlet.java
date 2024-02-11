import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String phoneNo = request.getParameter("phoneNo");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db24?characterEncoding=latin1&useConfigs=maxPerformance", "root", "");
			PreparedStatement pst = con.prepareStatement("insert into user values(?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, password);
			pst.setString(3, mail);
			pst.setString(4, phoneNo);

			pst.execute();

			pst.close();
			con.close();
			
			request.getRequestDispatcher("/index.html").forward(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
