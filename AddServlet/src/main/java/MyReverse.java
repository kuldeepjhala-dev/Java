
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyReverse
 */
@WebServlet("/MyReverse")
public class MyReverse extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rev = request.getParameter(request.getParameter("normalString"));
		StringBuffer sbf = new StringBuffer(rev);
		sbf.reverse();
		PrintWriter out = response.getWriter();
		out.print("\n Web-service is called successfully");
		out.print("\n Reverse = " + sbf);
	}

}
