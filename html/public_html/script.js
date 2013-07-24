window.onload = function(){
    //pole gry
    var canvas = document.createElement('canvas');
    var ctx = canvas.getContext('2d');
    //pole z wynikiem
    var canvas2 = document.createElement('canvas');
    var ctx2 = canvas2.getContext('2d');
    //zmienne
    var scr = 0;
    var level = 0;
    var direction = 0;
    var active = true;
    var instrukcje = false;

    //ustawienie rozmiarów
    canvas.height = 400;
    canvas.width = 400;
    canvas2.height = 100;
    canvas2.width = 180;

    //dołaczenie canvasów do odpowiednich elementów
    var pole = document.getElementById("pole");
    pole.appendChild(canvas);
    var score = document.getElementById("score");
    score.appendChild(canvas2);
    
    //tworzenie tablicy gry
    var map = new Array(40);
    for (var i=0; i<map.length; i++){
	map[i] = new Array(40);
    }

    // Mr snake.
    var snake = new Array(5);
    
    //wygenerowanie stanu początkowego
    map = snakeGenerator(map);
    map = foodGenerator(map);
    drawGame();
    
    //głowna pętla gry
    function drawGame(){
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	ctx2.clearRect(0,0, canvas2.width, canvas2.height);
	
	//petla odpowiedzalna za ruch snake
	for (var i = snake.length-1; i>=0; i--){
	    //ustawienia dla glowy
	    if (i === 0) {
		switch(direction) {
                case 0: // Right
                    snake[0] = { x: snake[0].x + 1, y: snake[0].y }
                    break;
                case 1: // Left
                    snake[0] = { x: snake[0].x - 1, y: snake[0].y }
                    break;
                case 2: // Up
                    snake[0] = { x: snake[0].x, y: snake[0].y - 1 }
                    break;
                case 3: // Down
                    snake[0] = { x: snake[0].x, y: snake[0].y + 1 }
                    break;
		}
		// koniec gry przez wypadniecie z mapy
		if (snake[0].x < 0 || 
                    snake[0].x >= 40 ||
                    snake[0].y < 0 ||
                    snake[0].y >= 40) {
                    gameOver();
                    return;
		}
		// zdobycie pozywienia, wydluzenie weza
		if ( map[snake[0].x][snake[0].y] === 1){
		    scr += 10;
		    map = foodGenerator(map);

		    snake.push({x: snake[snake.length -1].x, y: snake[snake.length -1].y});
		    map[snake[snake.length-1].x][snake[snake.length-1].y] = 2;
		    //zwiekszenie levelu
		    if ( scr % 50 === 0 )
			level += 1;

		}else if(map[snake[0].x][snake[0].y] === 2) {
		    //koniec gry przez ugryzienie
                    gameOver();
                    return;
		}
		//nadanie wartosci nowej glowie
		map[snake[0].x][snake[0].y] = 2;
	    }
	    // przesuwanie reszty ciala
	    else {
                //usuwanie ostatniego elementu
                if (i === (snake.length - 1)) {
                    map[snake[i].x][snake[i].y] = null;
                }
		//przesuwanie pozostalych
                snake[i] = { x: snake[i - 1].x, y: snake[i - 1].y };
                map[snake[i].x][snake[i].y] = 2;
            }
        }
	//funkcja czyszczaca wszystko    
	drawMain();
	
	//rysowanie calej mapy z wezem i pozywieniem od nowa
	for(var i=0; i< map.length; i++)
	    for(var j=0; j<map[0].length; j++){
		if(map[i][j] === 1){
		    ctx.fillStyle = "black";
		    ctx.fillRect( i*10, j*10, 10, 10);
		}
		if(map[i][j] === 2){
		    ctx.fillStyle = "orange";
		    ctx.fillRect( i*10, j*10, 10, 10);
		}
	    }
	// predokosc gry
	if(active){
	    if(level < 6)
		setTimeout(drawGame, 350 - level * 50 );
	    else
		setTimeout(drawGame, 100);
	}    
	
	    
    }
    
    //funkcja rysujaca/czyszczaca
    function drawMain(){
	ctx.lineWidth = 2;
	ctx.strokeStyle = "black";
	ctx.strokeRect(0, 0, canvas.width, canvas.height);
	
	ctx2.lineWidth = 2;
	ctx2.strokeStyle = "black";
	ctx2.strokeRect(2,2, canvas2.width-4, canvas2.height - 4);
	ctx2.font = "18px sans-serif";
	ctx2.fillText("Score: "+ scr ,60,40);
	ctx2.fillText("Level: "+ level,60,60);
    }
    
   
    //koniec gry
    function gameOver(){
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	ctx.fillStyle = "black";
	ctx.font ="18px Sans-serif";
	ctx.fillText("Game over!", ((canvas.width/2) - ( ctx.measureText("Game Over!").width/2)), 150);
	ctx.font = "12px";
	ctx.fillText("Your score was: " + scr, ((canvas.width/2) - (ctx.measureText("Your score was: ").width/2)),170);
	active = false;
    }

    //generowanie pozywienia
    function foodGenerator(map){
	var rndX = Math.round(Math.random() * 39);
	var rndY = Math.round(Math.random() * 39);

	while( map[rndX][rndY] === 2){
	    rndX = Math.round(Math.random() * 39);
	    rndY = Math.round(Math.random() * 39);
	}
	map[rndX][rndY] = 1;
	return map;
    }

    //generowanie weza
    function snakeGenerator(map){
	for(var i=0; i<snake.length ; i++){
	    map[20][i+10] = 2;
	    snake[i] = {x: 20, y: i+10};
	}
	
	return map;
    }

    //obsluga klawiszy
    window.addEventListener('keydown', function(e) {
	if (e.keyCode === 87 && direction !== 3) {
	    direction = 2; // Up
	} else if (e.keyCode === 83 && direction !== 2) {
	    direction = 3; // Down
	} else if (e.keyCode === 65 && direction !== 0) {
	    direction = 1; // Left
	} else if (e.keyCode === 68 && direction !== 1) {
	    direction = 0; // Right
	} else if( e.keyCode === 72){
	    // pokazywanie i ukrywanie sterowania
	    if(instrukcje === false){
	    $("#instrukcje").animate({
		height: "200px"
	    },500);
	    
	    $('#instrukcje').append("<ul><li>W - up</li><li>S - down</li><li>A - left</li><li>D - right</li></ul>");
	    instrukcje = true;
	    }
	    else{
		$("#instrukcje > ul").remove();
		$("#instrukcje").animate({
		    height: "80px"
		},500);
		instrukcje = false;
	    }
	}
    });
    
}
	