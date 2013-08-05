
var canvas = document.getElementById("game");
var context = canvas.getContext("2d");
//context.translate(100,100);
context.fillStyle = "#f00";
//context.fillRect(0,0,100,100);

var speedY = 1;
var x=0,y=0;

setInterval(function(){
	context.clearRect(0,0,800,600);
	
	context.save();
	
	context.translate(x,y);
	
	context.fillRect(0,0,100,100);
	context.restore();
	
	y+=speedY;
	
}, 50);
