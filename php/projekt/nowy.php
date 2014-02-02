<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
 
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>Formularz do zak�adania blogu</title>
</head>
<body>
<?php
	header('Content-type: text/html');
	$blog = trim($_POST['blog']," \n\t\r");
	$user = $_POST['user'];
	$password = $_POST['password'];
	$opis = $_POST['opis'];

	$dir = dir('.');
	if(file_exists($blog))
		echo 'Blog o takiej nazwie "' . $blog . '"' . ' już istnieje! <br />';
	else{
		//echo $blog . " " . $file . '<br/>';
		$fpl = fopen("semafor_nowy.txt","r+");
		if (flock($fpl, LOCK_EX)){
			if(file_exists($blog)){
				echo 'Blog o takiej nazwie "' . $blog . '"' . ' już istnieje! <br />';
				break;
			}
			echo 'Utworzenie blogu powiodło się';
			mkdir(strtolower($blog));
			$fp = fopen($blog . '/info.txt',w);
			fwrite($fp,$user."\n");
			fwrite($fp, md5($password)."\n");
			fwrite($fp, $opis);			
			fclose($fp);
			flock($fpl, LOCK_UN);
		}
		else 
			echo '<p>Problemy z blokadą</p>';
		fclose($fpl);
	}	 
	$dir->close();
	include('menu.php');
		
?>
</body>
</html>