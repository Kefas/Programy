<?php include('head.php');?>
<body>
	<form action="index.php" method="get">
		<input type="text" name="input" />
	</form>
	
	
	<?php
		$var = $_POST['input'];
		echo $var;
		echo '<br/>';
		$var = str_replace("_",".",$var);  // changing "_" to "." to make a pattern

		header('Content-type: text/html');
		$plik = fopen('dict.txt', 'r');   // open my dictionary file
		while (!feof($plik)) {
 			$s = fgets($plik);
			$s = trim($s, " \n\t\r\0");   // deleting unnecessary signs
			if(strlen($s) == strlen($var))// checking length of word
				if(ereg($var, $s)){       // checking if pattern matching word from dictionaty
					$s = iconv("ISO-8859-2", "UTF-8",$s);
					echo $s;
					echo '<br />';
				}
  			
			
		}
		fclose($plik);
	?>
</body>
</html>