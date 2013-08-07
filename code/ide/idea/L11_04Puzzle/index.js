/**
 * Created with IntelliJ IDEA.
 * User: plter
 * Date: 13-8-7
 * Time: 上午10:47
 * To change this template use File | Settings | File Templates.
 */

var stage = new createjs.Stage("gameView");

var img = new Image();
img.onload = function(){
    stage.addChild(new cn.eoe.GameView(img));
};
img.src = "img.jpg";




createjs.Ticker.addEventListener("tick",function(){
    stage.update();
});