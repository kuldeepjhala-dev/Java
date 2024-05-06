

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FinalBillServlet")
public class FinalBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false); // getting created session
		
		String product = (String) session.getAttribute("product");
		String accessory = (String) session.getAttribute("accessory");
		int p_amount = (Integer)session.getAttribute("p_amount");
		int a_amount = (Integer)session.getAttribute("a_amount");
		
		PrintWriter out = response.getWriter();
		
		out.println("Product Name : "+product);
		out.println("Price : Rs. "+p_amount);
		out.println("\nAccessory Name : "+accessory);
		out.println("Price : Rs. "+a_amount);
		out.println("\nTotal bill amount : Rs. "+(p_amount+a_amount));
	}

}
