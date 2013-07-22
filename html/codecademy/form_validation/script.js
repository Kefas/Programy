$(document).ready(function(){
    
    $("#header").animate({
	height: "50px",
	opacity: 0.8
    }, 500);
    $("h1").fadeTo(600, 0.01);
    $("h1").fadeTo(500, 1);

    $("#formularz").fadeTo(600, 0.01);
    $("#formularz").fadeTo(500, 1);
    $("#submit").click(function(){
	var first = $("#first").val();
	var last = $("#last").val();
	var date = $("#date").val();
	var man = $("#man:checked").val();
	var woman = $("#woman:checked").val();
	
	if( first.length === 0 ){
	    alert("Nie wpisałeś imienia!");
	}
	if( last.length === 0){
	    alert("brak nazwiska");
	}
	if( man === "on" && woman === "on" ){
	    alert("Nie mozesz byc jednoczesnie baba i chopem!");
	}
	if( man !== "on" && woman !=="on"){
	    alert("bezplciowiec co?? ");
	}
	alert(man);
    });
});

