<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
<%
	Cookie c[] = request.getCookies();
	if(c != null)
	{
		for(int i = 0; i < c.length; i++)
		{
			if(c[i].getValue().equals("direct"))
			{
				request.getRequestDispatcher("/product.html").forward(request, response);
			}
		}
	}
%>
<form action="LoginServlet" method="post">
	User name : <input type="text" name="username">
	Password : <input type="password" name="password">
	<input type="checkbox" name="check" value="keep me">Keep me logged in
	<input type="submit" name="submit" value="Login">
	<input type="reset" name="cancel" value="Reset">
</form>
</body>
</html>