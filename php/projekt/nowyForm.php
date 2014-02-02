<?php include('head.php');?>
<body>
	<form method="post" action="nowy.php">
		<p>
			Blog <br />
			<input type="text" name="blog" />
		</p>
		<p>
			Nazwa użytkownika <br/>
			<input type="text" name="user"/>
		</p>
		<p>
			Hasło<br />
			<input type="password" name="password"/>
		</p>
		<p>
			Opis<br />
			<textarea name="opis" cols="50" rows="5">Opis...</textarea>
		</p>
		<p><input type="reset" name="clear" value="Wyczyść"/></p>	
		<p><input type="submit" name="submit" value="Prześlij"/></p>
	</form>
	<?php include('menu.php'); ?>
</body>
</html>