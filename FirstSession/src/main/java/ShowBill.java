

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShowBill")
public class ShowBill extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ht = request.getSession(false);
		String pname = (String) ht.getAttribute("product");
		int pprice  = Integer.parseInt((String) ht.getAttribute("price"));
		String epname = (String) ht.getAttribute("eproduct");
		int epprice  = Integer.parseInt((String) ht.getAttribute("eprice"));
		
		PrintWriter out  = response.getWriter();
		out.print("<br> " + pname);
		out.print("<br> " + pprice);
		out.print("<br> " + epname);
		out.print("<br> " + epprice);
	}

}
