import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/CheckServlet")
public class CheckFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String user = request.getParameter("name");
		String pass = request.getParameter("password");
		
		if(user.equals("msu") && pass.equals("java"))
		{
			chain.doFilter(request, response);
		}
		else
		{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}
}