<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Data from XML file....</h1>
	<c:import url="mybook.xml" var="myfile"></c:import>
	<x:parse doc="${myfile}" var="data">
	</x:parse>
	<x:forEach select="$data/books/book">
		<x:out select="name" />
		<x:out select="author" />
		<x:out select="price" />
	</x:forEach>
</body>
</html>