<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String us = request.getParameter("user");
	String pa = request.getParameter("pass");
	
	if(us.equals("MSU") && pa.equals("JAVA"))
	{
		out.print("<BR> WELCOME - AUTHORISED USER");
	}
	else
	{
		request.getRequestDispatcher("/index.jsp").forward(request,response);
	}
	%>
</body>
</html>