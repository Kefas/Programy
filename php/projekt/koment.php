<?php include('head.php');?>
<body>
<?php
	$ocena = $_POST['ocena'];
	$text = $_POST['opis'];
	$podpis = $_POST['caption'];
	$unique = 0;
	$folder = $_POST['nazwaBlog'];
	$wpis  = $_POST['nazwaWpis'];

	
	if(!file_exists($folder."/".$wpis.".k"))
		mkdir($folder."/".$wpis.".k");
	$nr = 0;
	
	$dir = dir($folder."/".$wpis.".k");
	while(($file = $dir->read())!=null)
		if($file != "." && $file != "..")
			$nr++;
	
	$fpl = fopen("semafor_nowy.txt", "r+");
	if(flock($fpl, LOCK_EX)){
		$fp = fopen($folder."/".$wpis.".k/".$nr, "w");
		fwrite($fp, $ocena."\n");
		fwrite($fp, date("Y-m-d") .", ". date("H:i:s")."\n");
		fwrite($fp, $podpis. "\n");
		fwrite($fp, $text);
		fclose($fp);
		flock($fpl, LOCK_UN);
		fclose($fpl);
	}
	else {
		echo '<p>Komentarz nie został dodany poprawnie</p>';
	}
	echo ' <a href=blog.php?name='.$folder.'&submit=Wyślij>Powrót</a>';
	//header("Location: blog.php?name=$folder&submit=Wyślij");
?>
</body>
</html>