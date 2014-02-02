<?php include('head.php');?>
<body>
	<form action="blog.php" method="get">
		<input type="text" name="name" />
		<input type="submit" name="submit" value="Wyślij" />
	</form>

	<?php
		header('Content-type: text/html');
		$file = $_GET['name'];
		
		
		
		if(isset($_GET['submit'])){
			$dir = dir(".");
			if(file_exists($file)){
				$fp = fopen($file."/info.txt","r");
				$user = fgets($fp);
				$pass = fgets($fp);
				echo '
					<h1>Blog '.$file.'</h1>
					<p>'.str_replace("\n","<br/>", (fread($fp,1000))).'</p>
				';
				fclose($fp);
				$folder = dir($file);
				while($plik = $folder->read()){
					if(!strstr($plik,".")){
						$text = implode('', file($file."/".$plik));	
						$text = str_replace("\n", "<br/>", $text);	
						echo '
							<h3>Wpis</h3>
							<p>
							'.$text.'
							<br />';
						$folder2 = dir($file);
						while($plik2 = $folder2->read()){
							if(strstr($plik2,$plik) && strstr($plik2, ".") && !strstr($plik2,".k") ){
								echo '
									<p><a href="'.$file."/".$plik2.'">'.$plik2.' </a></p>
								';
							}
						}
							
						echo '<form method="post" action="komentForm.php">
								<p><input type="submit" value="Skomentuj" /></p>
								<p><input type="hidden" name="nazwaBlog" value="'.$file.'" /><p>
								<p><input type="hidden" name="nazwaWpis" value="'.$plik.'" /></p>
								</form>
								';
						
									  	
						if(file_exists($file."/".$plik.".k")){
							echo '<h6>Komentarze:</h6>';
							$dir = dir($file."/".$plik.".k");
							while(($kom = $dir->read())!= null){
						 		if($kom != "." && $kom!= ".."){
									$fp = fopen($dir->path."/".$kom, "r");
									//echo $plik."/".$kom.'<br/>';
									echo '<p> Komentarz '.fgets($fp).'<br />';
									echo 'Data: '.fgets($fp).'<br />';
									echo 'Napisał: '.fgets($fp).'<br />';
									while($text = fgets($fp))
										echo ' >'.$text."<br/>";
									echo '</p>';
									fclose($fp);
								}											
							}					
							$dir->close();	
						}
						else 
							echo '<p>Brak komentarzy</p>';	
						echo '***************************************';
					}
									
				}
			}
			else if(strlen($file)==0 ){
			 	$dir = dir(".");
				while($folder = $dir->read())
					if(is_dir($folder) && $folder!="." && $folder!="..")
						echo '<a href="?name='.$folder.'&submit=Wyślij">'.$folder.'</a><br/>';
			}
			else{
				echo '
					<p>Nie ma takiego bloga!</p>
					';					
			}		
		}		

	include('menu.php');
	?>
</body>
</html>