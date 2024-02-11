<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import ="java.util.* " %>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="header.jsp" %>

<% 
	Date dd = new Date();
	out.print("<h1 align='center'> CURRENT DATE : " + dd + "</h1>");
%>

	<form align="center" action="LoginServlet" method="post">
		USER NAME : <input type="text" name="user"> <br>
		PASSWORD : <input type="text" name="pass"> <br><br>
		<input type="checkbox" value="keep me" name="check">Keep Me logged in
		<input type="submit" value="submit">
		<input type="reset" value="reset">
	</form>
	
	<%@ include file="header.jsp" %>
	
</body>
</html>