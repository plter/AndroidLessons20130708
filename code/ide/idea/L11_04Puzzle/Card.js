/**
 * Created with IntelliJ IDEA.
 * User: plter
 * Date: 13-8-7
 * Time: 上午11:00
 * To change this template use File | Settings | File Templates.
 */
(function(){

    function Card(img,rect){
        createjs.Container.call(this);

        this.image = img;
        this.sourceRect = rect;

        var GameView = cn.eoe.GameView;
        this.width = GameView.WIDTH/GameView.H_NUM;
        this.height = GameView.HEIGHT/GameView.V_NUM;

        this.scaleX =  (this.width-2)/this.sourceRect.width;
        this.scaleY =  (this.height-2)/this.sourceRect.height;

        this.bitmap = new createjs.Bitmap(img);
        this.bitmap.sourceRect = rect;
        this.addChild(this.bitmap);
    }
    var p =Card.prototype = new createjs.Container();
    p.putOnRightPlace = function(){
        this.x = this.width*this.rightI;
        this.y = this.height*this.rightJ;
    }

    p.putOnCurrentPlace = function(){
        this.x = this.width*this.currentI;
        this.y = this.height*this.currentJ;
    }

    p.onRightPlace = function(){
        return this.rightI==this.currentI&&this.rightJ==this.currentJ;
    }


    cn.eoe.Card = Card;
})();