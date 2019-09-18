<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestão de Brinquedos</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<h1>Gestão de Brinquedos</h1>
	<form>
		<div class="container">
			<div class="form-group">
				<label for="">Id</label>
				<td><input name="txtId" readonly="readonly" class="form-control"/></td>
			</div>
			<div class="form-group">
				<label for="">Categoria</label>
				<select name="txtCategoria" class="form-control">
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
				<input name="txtNome" class="form-control"/>
			</div>
			<div class="form-group">
				<button name="cmd" value="salvar" class="btn btn-primary">Salvar</button>
			</div>			
		</div>			
	</form>


</body>
</html>