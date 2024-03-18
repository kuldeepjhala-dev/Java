import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ExtraProductServlet")
public class ExtraProductServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String eproduct = request.getParameter("epname");
		int eprice = Integer.parseInt(request.getParameter("epprice")); 
		
		HttpSession ht = request.getSession();
		ht.setAttribute("eproduct", eproduct);
		ht.setAttribute("eprice", ""+eprice);
		
		request.getRequestDispatcher("/page3.jsp").forward(request, response);
	}

}
