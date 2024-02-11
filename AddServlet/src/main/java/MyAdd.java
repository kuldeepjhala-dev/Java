
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
  Servlet implementation class MyAdd
*/
@WebServlet("/MyAdd")
public class MyAdd extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int n1 = Integer.parseInt(request.getParameter("one"));
		int n2 = Integer.parseInt(request.getParameter("two"));

		int c = n1 + n2;

		PrintWriter out = response.getWriter();
		out.print("\n Web-service is called successfully");
		out.print("\n Addition = " + c);
	}

}
