<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
 
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>Formularz do zakładania blogu</title>
</head>
<body>
	<form method="get" action="koment.php">
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
		<p><input type="reset" name="clear" value="Wyczyść"/></p>		
		<p><input type="submit" name="submit" value="Prześlij"/></p>
				</form>
	
	
</body>
</html>