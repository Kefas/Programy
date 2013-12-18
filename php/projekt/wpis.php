<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
 
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>Dodawanie wpisu</title>
</head>
<body>
<?php
	$user = $_GET['wpisUser'];
	$password = $_GET['wpisPassword'];
	$dir = dir('.');
	$uniqe = 0;
	$date = $_GET['wpisData'];
	$hour = $_GET['wpisData']['hour'];
	
	$file1 = $_GET['file1']['name'];
	$file2 = $_GET['file2']['name'];
	$file3 = $_GET['file3']['name'];
	
	echo $file1 . '<br />';
	
	echo $hour . ' <br />';
	while($file = $dir->read()){
		$fp = fopen($file.'/info.txt', r);
		if($fp!=null){
			$word = trim(fgets($fp), " \n");
			$pass2 = trim(fgets($fp), " \n");
			if(strcmp($user,$word) == 0){
				if(strcmp(md5($password), $pass2)){
					//$fp = fopen($file.'/'.date("s").strval($unique), w);
					$unique++;
					//fwrite()
				}
				else 
					echo 'Błędne hasło <br />';		
			}
			else
				echo 'Błędny login <br/ >';
			
				
		}
		
	}
	
	
?>
</body>
</html>