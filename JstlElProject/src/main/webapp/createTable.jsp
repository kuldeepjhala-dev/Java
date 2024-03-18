<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> DATA FROM DATABASE USING JSTL </h1> 
<BR>

<sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/db23?characterEncoding=latin1&useConfigs=maxPerformance" user="root" password="" 
			var="con" />
			
<sql:query dataSource="${con}" var="result"> select * from  std</sql:query>
	
<c:forEach var="row" items="${result.rows}">

<c:out value="${row.sid}"> </c:out>
<c:out value="${row.sna}"> </c:out>
<c:out value="${row.sag}"> </c:out>
<br>

</c:forEach>


</body>
</html>