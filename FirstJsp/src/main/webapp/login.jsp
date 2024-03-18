<%@page import="javax.swing.JScrollPane"%>
<%@page import="javax.swing.JTable"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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

	if (us.equals("MSU") && pa.equals("JAVA")) {
		out.print("<BR> WELCOME - AUTHORISED USER");
		
	%>
	
	<table BORDER="1">

		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
		</tr>

		<%
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/db24?characterEncoding=latin1&useConfigs=maxPerformance", "root", "");
			Statement st = con.createStatement();
			String query = "select sid, sna, sage from student24";
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
		%>

		<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
		</tr>

		<%
		}
		} catch (Exception e) {
		System.out.println(e.getMessage());
		}
		%>

	</table>
	
	<%
	} else {
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	%>

	

</body>
</html>