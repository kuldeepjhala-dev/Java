

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upassword");
		PrintWriter pw = response.getWriter();
		if(uname.equals("msu") && upass.equals("java"))
		{
			pw.write("authorised");
		}
		else
		{
			pw.write("Not authorised");
		}
	}

}
