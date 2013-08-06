
var n = createjs;

var stage = new n.Stage("gameView");

//var bitmap = new n.Bitmap("image.jpg");
//bitmap.x = 100;
//stage.addChild(bitmap);


n.Ticker.setFPS(30);
n.Ticker.addEventListener("tick",stage);



var img = new Image();
img.onload=function(){
	initApp();
};
img.src = "image.jpg";


function initApp(){
	var bitmap = new n.Bitmap(img);
	bitmap.sourceRect = new n.Rectangle(100,100,100,100);
	bitmap.x =100;
	bitmap.y = 100;
	stage.addChild(bitmap);
};

