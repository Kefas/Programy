<?php include('head.php');?>
<body>
	<form enctype="multipart/form-data" method="post" onsubmit="return validateForm()" action="wpis.php">
		<p>
			Nazwa użytkownika<br />
			<input type="text" name="wpisUser"/>
		</p>
		<p>
			Hasło<br />
			<input type="password" name="wpisPassword"/>
		</p>
		<p>
			Wpis <br />
			<textarea name="opis" cols="20" rows="5">Opis...</textarea>
		</p>
		<p>
			Data <br />
			<input type="text" name="wpisData" value="" /><br />
			<script>
				var d = new Date();
				var year = d.getFullYear();
				var month = d.getMonth()+1;
				var day = d.getDate();
				if(parseInt(day) < 10)
					day = "0"+day;
				if(parseInt(month) < 10)
					month = "0"+month;
			
			 	document.getElementsByName("wpisData")[0].value = year + "-" + month + "-" + day;
			 		
			 		
			 		function validateForm(){
						var date = document.getElementsByName("wpisData")[0].value;
						var month = parseInt(date.substring(5, 7),10);
       				var day   = parseInt(date.substring(8, 10),10);
       				var year  = parseInt(date.substring(0, 4),10);
       				
								
						var matches = /^(\d{4})[-\/](\d{2})[-\/](\d{2})$/.exec(date);
						if(parseInt(day) < 1 || parseInt(day) > 31 || parseInt(month) <1 || parseInt(month) >12)
							matches = null;
   					if (matches == null){
    						alert("Niepoprawny format daty!");
    						var d = new Date();
							var year = d.getFullYear();
							var month = d.getMonth()+1;
							var day = d.getDate();
							if(parseInt(day) < 10)
								day = "0"+day;
							if(parseInt(month) < 10)
								month = "0"+month;
    						document.getElementsByName("wpisData")[0].value = year + "-" + month + "-" + day;
    						return false;
   				 	}
   				 	var hm = document.getElementsByName("wpisGodziny")[0].value;
   				 	var matches = /^(\d{2})[:](\d{2})$/.exec(hm);
   				 	var hour = parseInt(hm.substring(0,2),10);
   				 	var minute = parseInt(hm.substring(3,5),10);
   				 	if(parseInt(hour) > 23 || parseInt(hour) < 0 || parseInt(minute) <0 || parseInt(minute) > 59 )
   				 		matches = null;
   				 	if (matches == null){
   				 		alert("Niepoprawny format godziny!");
   				 		var date = new Date();
   				 		var hour = d.getHours();
							var minute = d.getMinutes();
							if(parseInt(hour)<10)
								hour = "0" +hour;
							if(parseInt(minute)<10)
								minute = "0" + minute;
    						
    						document.getElementsByName("wpisGodziny")[0].value = hour + ":" + minute;
    						return false;
   				 	}	
    
	
					}
			</script>
			Godzina:Minuty<br />
			<input type="text" name="wpisGodziny" value=""/>
			<script>
				var d = new Date();
				var hour = d.getHours();
				var minute = d.getMinutes();
				if(parseInt(hour) <10 && parseInt(minute) < 10)
					document.getElementsByName("wpisGodziny")[0].value = "0" + hour + ":0" + minute;
				else if(parseInt(hour)<10)
					document.getElementsByName("wpisGodziny")[0].value = "0" + hour + ":" + minute;
				else if(parseInt(minute) < 10)
					document.getElementsByName("wpisGodziny")[0].value = hour + ":0" + minute;
				else
					document.getElementsByName("wpisGodziny")[0].value = hour + ":" + minute;
			</script>			
		</p>
		<p><input type="file" name="file1" onchange="checkFile()") /></p>
		<script>
			function checkFile(){
				var i =2;
				while(document.getElementsByName("file"+i)[0] != undefined){
					i = i+1;
				}
		
				var newFile = document.createElement("p");
				newFile.innerHTML = "<p><input type=\"file\" name=\"file"+i+"\" onchange=\"checkFile()\" /></p>";
				var elem = document.getElementsByTagName("form");
				elem[0].insertBefore(newFile, elem[0].childNodes[8]);
			
			}
		</script>
		<p><input type="reset" name="clear" value="Wyczyść"/></p>	
		<p><input type="submit" name="submit" value="Prześlij"/></p>
	</form>
	<?php include('menu.php'); ?>
</body>
</html>