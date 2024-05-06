

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AccessoryServlet")
public class AccessoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accesory = request.getParameter("accessory");
		int a_amount = Integer.parseInt(request.getParameter("amount"));
		
		HttpSession session = request.getSession();  // creates new sesssion
		session.setAttribute("accessory", accesory);
		session.setAttribute("a_amount", a_amount);
		
		request.getRequestDispatcher("/bill.html").forward(request, response);
	}

}
