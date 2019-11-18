<html>
  <body>
    <h1>Tabuada</h1>

    <ul style="list-style: none;">
      <?php

        $n = 7;
        if (isset($_REQUEST['NUMERO'])) {
          $n = $_REQUEST['NUMERO'];
        }

        if ($n >= 0 && $n <= 100) {
          for($i = 0; $i <= 10; $i++) {
            $res = $n * $i;
            echo "<li>$n X $i = $res</li>";
          }
        } else {
            echo "<h2>Numero invalido para a tabuada</h2>";
        }

      ?>
    </ul>
  </body>
</html>
