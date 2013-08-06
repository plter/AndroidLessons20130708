/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class BitmapAnimation extends DisplayObject{

	public function new(spriteSheet:SpriteSheet):Void;

	public var currentAnimation:String;
	public var currentAnimationFrame:Float;
	public var currentFrame:Float;
	public var offset:Float;
	public var paused:Bool;
	public var spriteSheet:SpriteSheet;
	
	public function advance():Void;
	public function gotoAndPlay(frame:Dynamic):Void;
	public function gotoAndStop(frame:Dynamic):Void;
	public function play():Void;
	public function stop():Void;
	
	
	
	public var onAnimationEnd:Void->Void;
}
