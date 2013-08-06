/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class SpriteSheet {
	
	public function new(data:Dynamic):Void;
	
	public var complete:Bool;
	public function clone():SpriteSheet;
	public function getAnimation(name:String):Dynamic;
	public function getAnimations():Array<Dynamic>;
	public function getFrame(frameIndex:Float):Dynamic;
	public function getNumFrames(animationName:String):Float;
	public function toString():String;
	
	public var onComplete:Void->Void;
	
}
