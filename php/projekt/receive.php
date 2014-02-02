<?php

	$file = "./messages.txt";
	if(!file_exists($file))
	{
		$writer = fopen($file, "a");
		fclose($writer);
	}
	
	readfile($file);

?>

