
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
	var x = $("#first").val();
	console.log(x);
	alert(x);
    });
});

