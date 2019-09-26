<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, edu.tartaruga.entidade.Entrega" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestão de Entregas</title>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h1>Gestão de Entregas</h1>
	
	<%
		String msg = (String)session.getAttribute("MENSAGEM");
		List<Entrega> lista = (List<Entrega>)session.getAttribute("LISTA");
		if (msg != null) { 
	%>
		<h3><%=msg%></h3>
	<%
			session.setAttribute("MENSAGEM", null);
		}%>
	
	<form action="./entregaController" method="post" id="frm">
		<div class="container">
			<div class="form-group">
				<label>Id</label>
				<input class="form-control" type="text" name="id" value="0" readonly="readonly"/>
			</div>
			<div class="form-group">
				<label>Origem</label>
				<input class="form-control" type="text" name="origem" placeholder="Informe a origem"/>
			</div>
			<div class="form-group">
				<label>Destino</label>
				<input class="form-control" type="text" name="destino" placeholder="Informe o destino"/>
			</div>		
			<div class="form-group">
				<label>Status</label>
				<select class="form-control" name="status" required="required">
					<option value="" selected="selected" disabled="disabled">Informe o Status da Entrega</option>
					<option value="aguardando">Aguardando Entrega</option>
					<option value="cancelado">Cancelada</option>
					<option value="entregue">Entregue</option>
					<option value="finalizado">Finalizado</option>
				</select>
			</div>
			<div class="form-group">
				<label>Frete</label>
				<input class="form-control" type="text" name="frete" placeholder="Informe o frete"/>
			</div>	
			<div class="form-group">
				<button class="btn btn-primary" type="submit" name="cmd" value="adicionar">Adicionar</button>
				<button class="btn btn-primary" type="submit" name="cmd" value="pesquisar">Pesquisar</button>
				<button class="btn btn-primary" type="button" name="cmd" onclick="enviar();" 
						value="adicionarJSON">Adicionar JSON</button>
			</div>
		</div>
	</form>
	<%if (lista != null && lista.size() > 0) {%>
	<div class="container">
		<table class="table table-striped">
			<thead class="table-dark">
				<tr>
					<th>Id</th>
					<th>Origem</th>
					<th>Destino</th>
					<th>Status</th>
					<th>Frete</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<%for (Entrega e : lista) { %>
				<tr>
					<td><%=e.getId()%></td>
					<td><%=e.getOrigem()%></td>
					<td><%=e.getDestino()%></td>
					<td><%=e.getStatus()%></td>
					<td><%=e.getFrete()%></td>
					<td>
						<button type="button" onclick="apagarRegistro(<%=e.getId()%>);" 
								class="btn btn-danger" aria-label="Left Align">
  								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							</button>
					</td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	<%}%>
	
	<script>
		function objectifyForm(formArray) {//serialize data function
			var returnArray = {};
			for (var i = 0; i < formArray.length; i++){
				returnArray[formArray[i]['name']] = formArray[i]['value'];
			}
			return returnArray;
		}
		function enviar() { 
			var arr = $('#frm').serializeArray();
			var arrJson = objectifyForm(arr);
			var arrJsonStr = JSON.stringify(arrJson);
			console.log("Formulario Serializado:");
			console.log(arr);
			console.log("Formulario JSON:");
			console.log(arrJson);
			
			function callback(resposta, status) {
				console.log("Resposta");
				console.log(resposta);
				console.log("Status");
				console.log(status);
			}
			var url = "http://localhost:8080/noite-aula8/entregaControllerJSON";
			$.post(url, arrJsonStr, callback);
		}
		
		function apagarRegistro(id) {
			function callback(resposta, status) {
				location.reload();
			}
			
			var url = "http://localhost:8080/noite-aula8/entregaController";
			$.post(url, {"id":id, "cmd":"apagar"}, callback);
		}
	</script>
</body>
</html>