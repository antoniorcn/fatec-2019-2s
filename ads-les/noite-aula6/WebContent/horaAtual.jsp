<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="refresh" content="1"/>
	<meta charset="ISO-8859-1">
	<title>Rel�gio Digital</title>
</head>
<body>
	<h1>Rel�gio Digital</h1>
	<hr/>
	<%
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String texto = sdf.format(d);
	%>
	<h2>Hoje �: <%=texto%> </h2>
</body>
</html>