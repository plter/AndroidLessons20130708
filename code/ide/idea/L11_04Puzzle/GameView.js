/**
 * Created with IntelliJ IDEA.
 * User: plter
 * Date: 13-8-7
 * Time: 上午10:57
 * To change this template use File | Settings | File Templates.
 */

(function(){

    var __this;

    /**
     *
     * @param {Image} img
     * @constructor
     */
    function GameView(img){
        createjs.Container.call(this);

        __this = this;

        this.image = img;
        this.cards = [];
        this.cardsMap = [];
        for(var i =0;i< GameView.H_NUM;i++){
            this.cardsMap.push([]);
        }


        this.cutImages();

//        var c = new cn.eoe.Card(img,new createjs.Rectangle(0,0,100,100));
//        this.addChild(c);

    }

    GameView.H_NUM = 4;
    GameView.V_NUM = 3;
    GameView.WIDTH = 640;
    GameView.HEIGHT = 480;

    var p = GameView.prototype = new createjs.Container();


    p.cutImages = function(){

        var picWidth = this.image.width/GameView.H_NUM;
        var picHeight = this.image.height/GameView.V_NUM;
        var card;

        for(var i=0;i<GameView.H_NUM;i++){
            for(var j=0;j<GameView.V_NUM;j++){
                if(i!=GameView.H_NUM-1||j!=GameView.V_NUM-1){
                    card = new cn.eoe.Card(img,new createjs.Rectangle(i*picWidth,j*picHeight,picWidth,picHeight));
                    card.rightI = i;
                    card.rightJ = j;
                    card.currentI = i;
                    card.currentJ = j;

                    card.putOnRightPlace();
                    this.addChild(card);
                    this.cards.push(card);
                    this.cardsMap[i][j] = card;
                    card.addEventListener("click", this.cardClickhandler);
                }
            }
        }
    };

    p.cardClickhandler = function(event){

        var card = event.target;

        var dir = __this.getMoveDir(card);

        switch (dir){
            case cn.eoe.CardMoveDir.LEFT:

                __this.cardsMap[card.currentI][card.currentJ] = null;
                card.currentI--;
                __this.cardsMap[card.currentI][card.currentJ] = card;
                card.putOnCurrentPlace();
                __this.checkSuc();
                break;
            case cn.eoe.CardMoveDir.UP:
                __this.cardsMap[card.currentI][card.currentJ] = null;
                card.currentJ--;
                __this.cardsMap[card.currentI][card.currentJ] = card;
                card.putOnCurrentPlace();
                __this.checkSuc();
                break;
            case cn.eoe.CardMoveDir.RIGHT:
                __this.cardsMap[card.currentI][card.currentJ] = null;
                card.currentI++;
                __this.cardsMap[card.currentI][card.currentJ] = card;
                card.putOnCurrentPlace();
                __this.checkSuc();
                break;
            case cn.eoe.CardMoveDir.DOWN:
                __this.cardsMap[card.currentI][card.currentJ] = null;
                card.currentJ++;
                __this.cardsMap[card.currentI][card.currentJ] = card;
                card.putOnCurrentPlace();
                __this.checkSuc();
                break;
        }
    };


    p.checkSuc = function(){
        if(this.allCardsOnRightPlace()){
            alert("成功");
        }
    }


    p.allCardsOnRightPlace = function(){
        for(var i =0;i<this.cards.length;i++){
            if(!this.cards[i].onRightPlace()){
                return false;
            }
        }

        return true;
    }


    p.getMoveDir = function(card){

        if(card.currentI>0&&!__this.cardsMap[card.currentI-1][card.currentJ]){
            return cn.eoe.CardMoveDir.LEFT;
        }
        if(card.currentJ>0&&!__this.cardsMap[card.currentI][card.currentJ-1]){
            return cn.eoe.CardMoveDir.UP;
        }
        if(card.currentI<GameView.H_NUM-1&&!__this.cardsMap[card.currentI+1][card.currentJ]){
            return cn.eoe.CardMoveDir.RIGHT;
        }
        if(card.currentJ<GameView.V_NUM-1&&!__this.cardsMap[card.currentI][card.currentJ+1]){
            return cn.eoe.CardMoveDir.DOWN;
        }

        return cn.eoe.CardMoveDir.NONE;
    };



    cn.eoe.GameView = GameView;


}());