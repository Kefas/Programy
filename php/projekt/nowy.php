<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
 
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>Formularz do zak³adania blogu</title>
</head>
<body>
<?php
	header('Content-type: text/html');
	$blog = $_GET['blog'];
	$user = $_GET['user'];
	$password = $_GET['password'];
	$opis = $_GET['opis'];

	
	$dir = dir('.');
	
	while($file = $dir->read())
 	 if($file != '.' && $file != '..') 
	 	if(strcmp(strtolower($file),strtolower($blog)) == 0)
			echo 'Blog o takiej nazwie "' . $blog . '"' . ' ju¿ istnieje! <br />';
		else{
			echo 'Utworzenie katalogu powiod³o siê';
			mkdir($blog);
			$fp = fopen($blog . '/info.txt',w);
			fwrite($fp,$user."\n");
			fwrite($fp, md5($password)."\n");
			fwrite($fp, $opis);
			fclose($fp);
			break;
		}
    		
	 
	$dir->close();
	
	
?>
</body>
</html>