
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyTable")
public class MyTable extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		PrintWriter out = response.getWriter();
		out.print("<table border='1' cellpadding='3' cellspacing='1'>");
		for (int i = 1; i <= 10; i++) {
			out.print("<tr> <td> " + no + "</td>" + "<td>" + "* </td>" + "<td>" + i + "</td>" + "<td>" + "=" + "</td>"
					+ "<td>" + no * i + "</td>");
		}
		out.print("</table>");
	}
}
