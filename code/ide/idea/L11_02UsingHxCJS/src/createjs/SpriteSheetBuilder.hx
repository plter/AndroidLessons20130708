/**
 * @author plter
 * @see http://plter.sinaapp.com
 */

package createjs;


extern class SpriteSheetBuilder {
	
	public function new():Void;
	
	public var defaultScale:Float;
	public var maxHeight:Float;
	public var maxWidth:Float;
	public var padding:Float;
	public var spriteSheet:SpriteSheet;
	
	
	public function addFrame ( source:DisplayObject , sourceRect:Rectangle , scale:Float=1 , setupFunction:Void->Void=null , setupParams:Array<Dynamic>=null , setupScope:Dynamic=null ):Float;
	public function addMovieClip(source:MovieClip , sourceRect:Rectangle=null , scale:Float=1):Void;
	public function build():Void;
	public function buildAsync(_callback:Void->Void=null , timeSlice:Float=0.3):Void;
	public function clone():SpriteSheetBuilder;
	public function stopAsync():Void;
	public function toString():String;
	
	
}
