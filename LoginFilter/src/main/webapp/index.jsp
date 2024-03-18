<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="CheckServlet">
	
		UserName : <input type="text" name="name">
		<br><br>
		Password : <input type="text" name="password">
		<br><br>

		<input type="submit" name="btn" value="submit">
		<input type="reset" name="btn" value="reset">
		
	</form>
</body>
</html>