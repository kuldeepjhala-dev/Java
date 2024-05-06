

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product = request.getParameter("product");
		int p_amount = Integer.parseInt(request.getParameter("amount"));
		
		HttpSession session = request.getSession();  // creates new sesssion
		session.setAttribute("product", product);
		session.setAttribute("p_amount", p_amount);
		
		request.getRequestDispatcher("/accessory.html").forward(request, response);
	}

}
