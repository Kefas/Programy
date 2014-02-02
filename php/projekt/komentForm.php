<?php include('head.php');?>
<body>
	<form method="post" action="koment.php">
		<p>Komentarz<br/>	
			<select name="ocena">
				<option>Pozytywny</option>
				<option>Neutralny</option>
				<option>Negatywny</option>	
			</select>
		</p>
		<p>
			Opis <br />
			<textarea name="opis" cols="50" rows="5">Opis...</textarea>
		</p>
		
		<p>
			Podpis <br />
			<input type="text" name="caption"/>
		</p>			
		
		
		<p><input type="hidden" name="nazwaBlog" value="<?php echo $_POST['nazwaBlog']; ?>" /></p>
		<p><input type="hidden" name="nazwaWpis" value="<?php echo $_POST['nazwaWpis'] ?>"</p>
		<p><input type="reset" name="clear" value="Wyczyść"/></p>		
		<p><input type="submit" name="submit" value="Prześlij"/></p>
		
	</form>
	<?php include('menu.php'); ?>
	
	
</body>
</html>