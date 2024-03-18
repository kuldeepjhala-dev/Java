<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ProductServlet" method="post">
		product : <input type="text" name="pname"> <br> 
		price : <input type="number" name="pprice"> <br> 
		<input type="submit" name="submit" value="Confirm"> 
		<input type="submit" name="cancel" value="Cancel">
	</form>
</body>
</html>