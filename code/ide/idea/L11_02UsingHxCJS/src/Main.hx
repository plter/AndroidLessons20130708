package ;
import createjs.Shape;
import createjs.Ticker;
import createjs.Stage;

class Main {
    public function new() {
    }

    public static function main():Void{
        var doc:Dynamic = untyped __js__("document");

        var stage:Stage = new Stage(doc.getElementById("game"));

        var r:Shape = new Shape();
        r.graphics.beginFill("#f00");
        r.graphics.drawRect(0,0,100,100);
        r.graphics.endFill();
        stage.addChild(r);

        Ticker.setFPS(30);
        Ticker.addListener(stage);
    }
}
