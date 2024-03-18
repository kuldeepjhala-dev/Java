

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String product = request.getParameter("pname");
		int price = Integer.parseInt(request.getParameter("pprice")); 
		
		HttpSession ht = request.getSession();
		ht.setAttribute("product", product);
		ht.setAttribute("price", ""+price);
		
		request.getRequestDispatcher("/page2.jsp").forward(request, response);
	}

}
