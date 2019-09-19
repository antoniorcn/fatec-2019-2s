<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestão de Entregas</title>
</head>
<body>
	<h1>Gestão de Entregas</h1>
	<form action="./entregaController" method="post">
		<table>
			<tr>
				<td>Id</td>
				<td>
					<input type="text" name="id" value="0" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>Origem</td>
				<td>
					<input type="text" name="origem"/>
				</td>
			</tr>
			<tr>
				<td>Destino</td>
				<td>
					<input type="text" name="destino"/>
				</td>
			</tr>			
			<tr>
				<td>Status</td>
				<td>
					<input type="text" name="status"/>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit" name="cmd" value="adicionar">Adicionar</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>