<html>
  <body>
    <h1>Tabuada</h1>

    <ul style="list-style: none;">
      <?php

        $n = 7;
        if (isset($_REQUEST['NUMERO'])) {
          $n = $_REQUEST['NUMERO'];
        }

        for($i = 0; $i <= 10; $i++) {
          $res = $n * $i;
          echo "<li>$n X $i = $res</li>";
        }

      ?>
    </ul>
  </body>
</html>
