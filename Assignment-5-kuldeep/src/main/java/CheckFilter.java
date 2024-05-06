import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/FilterServlet")
public class CheckFilter extends HttpFilter implements Filter {
       
    public CheckFilter() {
        super();
    }
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1&useConfigs=maxPerformance", "root","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from user where uname='"+username+"' and upass='"+password+"'");
			if(rs.next()) {
				chain.doFilter(request, response);
			}
			else {
				out.print("Unauthorised User!!");
			}
		}
		catch(Exception e) {
			System.out.println("Filter Error : "+e.getMessage());
		}
	}
}
