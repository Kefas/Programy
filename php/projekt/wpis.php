<?php include('head.php');?>
<body>
<?php
	$user = $_POST['wpisUser'];
	$password = $_POST['wpisPassword'];
	$text = $_POST['opis'];
	$dir = dir('.');
	$date = str_replace("-","",$_POST['wpisData']);
	$hour = str_replace(":","",$_POST['wpisGodziny']);
	
	$file1 = $_FILES['file1']['tmp_name'];
	$file4 = $_FILES['file2']['tmp_name'];
	$file3 = $_FILES['file3']['tmp_name'];
	
	$login = false;
	$pass = true;

	while($file = $dir->read()){
		$fp = fopen($file.'/info.txt', r);
		if($fp!=null){
			$word = trim(fgets($fp), " \n");
			$pass2 = trim(fgets($fp), " \n");
			if(strcmp($user,$word) == 0){
				$login = true;
				$pass = false;
				if(strcmp(md5($password), $pass2)==0){
					$pass = true;
					$unique = 0;
					$dir2 = dir($file);
					while($file2 = $dir2->read()){
						if(strstr($file2,$file) && !strstr($file2,"."))
							$unique++;
					}
					$dir2->close();
					$fpl = fopen("semafor_nowy.txt","r+");
					if (flock($fpl, LOCK_EX)){
						$fp = fopen($file.'/'.$date.$hour.date('s').strval($unique), "w");			
						fwrite($fp, $text);
						fclose($fp);
						$nrPlik = 1;
						if(is_uploaded_file($file1)){
							$odcz1 = pathinfo($_FILES['file1']['name']);					
							move_uploaded_file($file1, $file."/".$date.$hour.date('s').strval($unique)."0".$nrPlik.".".$odcz1['extension']);
							$nrPlik++;
							echo '<p>Plik '.$_FILES['file1']['name'].' zapisany pomyślnie <p/>';
						}

						if(is_uploaded_file($file4)){
							$odcz2 = pathinfo($_FILES['file2']['name']);
							move_uploaded_file($file4, $file."/".$date.$hour.date('s').strval($unique)."0".$nrPlik.".".$odcz2['extension']);			
							echo '<p>Plik '.$_FILES['file2']['name'].' zapisany pomyślnie <p/>';
							$nrPlik++;
						}
						
						if(is_uploaded_file($file3)){
							$odcz3 = pathinfo($_FILES['file3']['name']);
							move_uploaded_file($file3, $file."/".$date.$hour.date('s').strval($unique)."0".$nrPlik.".".$odcz3['extension']);			
							echo '<p>Plik '.$_FILES['file3']['name'].' zapisany pomyślnie <p/>';
						}
						echo '<p>Wpis został dodany pomyślnie</p>';
						flock($fpl, LOCK_UN);
						fclose($fpl);
						break;	
					}
					else
						echo '<p>Bład semafora</p>';
				}
									
			} 
						
		}
		
	}
	if($login == false)
		echo 'Błędny login <br/ >';	
	if($pass == false)
			echo 'Błędne hasło <br />';	
	
	include('menu.php');
	
//	header("Location: blog.php?name=$folder&$submit=Wyślij");
?>
</body>
</html>