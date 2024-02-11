

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReverseServlet
 */
@WebServlet("/ReverseServlet")
public class ReverseServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("input_string");
		StringBuffer sb = new StringBuffer(s);
		sb.reverse();
		PrintWriter out = response.getWriter();
		out.print(sb);
	}

}
