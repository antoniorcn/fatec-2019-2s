<html>
  <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
  <body>
<?php
$tipo = $_REQUEST['TIPO'];
$ano = $_REQUEST['ANO'];
$calibre = $_REQUEST['CALIBRE'];
$cmd = $_REQUEST['CMD'];

$URL = 'mysql:host=localhost;dbname=quartel;charset=utf8';
$USER = 'root';
$PASS = '';
$db = new PDO($URL, $USER, $PASS);
if ($cmd == 'Enviar') {
  $SQL = "INSERT INTO armas (tipo, calibre, ano) VALUES (:tipo, :calibre, :ano)";
  $stmt = $db->prepare($SQL);
  $stmt->bindValue(':tipo', $tipo, PDO::PARAM_STR);
  $stmt->bindValue(':calibre', $calibre, PDO::PARAM_INT);
  $stmt->bindValue(':ano', $ano, PDO::PARAM_INT);
  $result = $stmt->execute();
} else if ($cmd == 'Pesquisar') {
  $SQL = "SELECT * FROM armas WHERE tipo like :tipo";
  $stmt = $db->prepare($SQL);
  $stmt->bindValue(':tipo', "%" . $tipo. "%", PDO::PARAM_STR);
  $stmt->execute();
?>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Tipo</th>
        <th>Calibre</th>
        <th>Ano</th>
      </tr>
    </thead>
    <tbody>
<?php
  forEach( $stmt as $row ) {
?>
  <tr>
    <td>
      <?=$row['tipo']?>
    </td>
    <td>
      <?=$row['calibre']?>
    </td>
    <td>
      <?=$row['ano']?>
    </td>
  </tr>
<?php
} // end for
?>
  </tbody>
</table>
<?php
} //end if
?>
</body>
</html>
