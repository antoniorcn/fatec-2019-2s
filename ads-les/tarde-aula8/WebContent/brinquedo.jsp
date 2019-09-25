<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat, 
java.util.List, edu.toyrus.entidade.Brinquedo" %>
<%-- <%@ page include="cabecalho.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestão de Brinquedos</title>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h1>Gestão de Brinquedos</h1>
	<%-- <jsp:include page="./cabecalho.jsp"/> --%>
	
	<%
		List<Brinquedo> brinquedos = 
				(List<Brinquedo>) session.getAttribute("LISTA");
	%>
	
	<form id="frm" action="./brinquedoController" method="get">
		<div class="container">
			<div class="form-group">
				<label for="">Id</label>
				<td><input name="id" id="txtId" readonly="readonly" class="form-control" value="0"/></td>
			</div>
			<div class="form-group">
				<label for="">Categoria</label>
				<select name="categoria" id="txtCategoria" class="form-control">
					<option value="bola">Bolas</option>
					<option value="boneca">Bonecas</option>
					<option value="boneco">Bonecos</option>
					<option value="car">Carrinhos</option>
					<option value="jogos_tab">Jogos Tabuleiro</option>
					<option value="jogos_ele">Jogos Eletrônicos</option>
				</select>
			</div>			
			<div class="form-group">
				<label for="">Nome</label>
				<input name="nome" id="txtNome" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="">Fabricante</label>
				<input name="fabricante" id="txtFabricante" class="form-control"/>
			</div>			
			<div class="form-group">
				<button type="submit" name="cmd" value="salvar" class="btn btn-primary">Salvar</button>
				<button type="submit" name="cmd" value="pesquisar" class="btn btn-primary">Pesquisar</button>
				<button type="button" name="cmd" value="salvarJson" 
					class="btn btn-primary" onclick="salvarJson();">Salvar JSON</button>
			</div>			
		</div>			
	</form>
	<% if(brinquedos != null && brinquedos.size() > 0)  {%>
	<div class="container">
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Fabricante</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<% for (Brinquedo b : brinquedos) { %>
					<tr>
						<td><%=b.getId()%></td>
						<td><%=b.getNome()%></td>
						<td><%=b.getFabricante()%></td>
						<td>
							<button type="button" onclick="deleteRecord(<%=b.getId()%>);" 
								class="btn btn-danger" aria-label="Left Align">
  								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							</button>
						</td>
					</tr>
				<%}%>
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
		
		
		function deleteRecord(id) { 
			var URL = "http://localhost:8080/tarde-aula7/brinquedoController";
			
			function callBack( resposta, status ) { 
				location.reload();
			} 
			$.ajax({
			    url: URL,
			    type: 'post',
			    contentType: 'application/x-www-form-urlencoded',
			    data: {"id": id, "cmd":"delete"},
			    success: callBack
			});
		}
		
		function salvarJson() { 
			/* var txtId = document.getElementById("txtId");
			var txtCategoria = document.getElementById("txtCategoria");
			var txtNome = document.getElementById("txtNome");
			var id = txtId.value == "" ? "0" : txtId.value;
			var obj = {	"id" : id, 
						"categoria": txtCategoria.value,
						"nome": txtNome.value};
			console.log("Objeto Criado");
			console.log(obj);
			var strObj = JSON.stringify(obj);
			*/
			var arr = $('#frm').serializeArray();
			var strObj = JSON.stringify(arr);
			// var arrSerialized = objectifyForm(arr;
			console.log("Array");
			console.log(arr);
			console.log("Array Serialized");
			console.log(strObj);
			var arrSerialized = objectifyForm(arr);
			var URL = "http://localhost:8080/tarde-aula7/brinquedoControllerJSON";
			
			function callBack( resposta, status ) { 
				console.log("Resposta: ");
				console.log(resposta);
				console.log("Status: ");
				console.log(status);
			} 
			
			$.post(URL, strObj, callBack);
			
		}
	</script>
	
</body>
</html>