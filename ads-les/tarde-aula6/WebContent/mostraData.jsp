<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta http-equiv="refresh" content="2">
	<title>Mostra Data e Hora atual</title>
</head>
<body>
	<h1>Mostra data e hora atuais</h1>
	<%
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String texto = sdf.format(d);
	%>
	<hr/>
	<h2> A data e hora atuais são: <%=texto%> </h2>
</body>
</html>