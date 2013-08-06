var cjs = createjs;
var stage = new cjs.Stage(document.getElementById("game"));

var anim = new lib.Anim();
stage.addChild(anim);
stage.update();

//anim.onClick = function(){
//	console.log("Clicked");
//};
//anim.onClick = null;


anim.addEventListener("click",function(){
	console.log("Clicked");
});


cjs.Ticker.setFPS(30);
cjs.Ticker.addEventListener("tick",stage);