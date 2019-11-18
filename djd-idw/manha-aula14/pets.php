<?php

  if (isset($_REQUEST['NOME'])) {
    $nome = $_REQUEST['NOME'];
  }

  if (isset($_REQUEST['NASCIMENTO'])) {
    $nascimento = $_REQUEST['NASCIMENTO'];
  }

  if (isset($_REQUEST['PESO'])) {
    $peso = $_REQUEST['PESO'];
  }

  echo "<h3>Nome: $nome</h3>";
  echo "<h3>Nascimento: $nascimento</h3>";
  echo "<h3>Peso: $peso</h3>";
 ?>
