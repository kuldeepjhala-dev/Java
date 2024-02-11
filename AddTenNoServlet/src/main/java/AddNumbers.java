
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNumbers
 */
@WebServlet("/AddNumbers")
public class AddNumbers extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nInputArr[] = request.getParameterValues("nArr");
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = sum + Integer.parseInt(nInputArr[i]);
		}
		PrintWriter out = response.getWriter();
		
		out.print(sum);

	}

}
