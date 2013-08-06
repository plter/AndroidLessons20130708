/**
 * @author plter
 * @see http://plter.sinaapp.com
 */

package createjs;

extern class MovieClip extends Container{
	
	public function new(mode:String , startPosition:Float , loop:Bool , labels:Dynamic):Void;
	
	public var actionsEnabled:Bool;
	public var loop:Bool;
	public var mode:String;
	public var paused:Bool;
	public var startPosition:Float;
	public var timeline:Dynamic;
	
	public static var INDEPENDENT:String;
	public static var SYNCHED:String;
	public static var SINGLE_FRAME:String;
	
	public function gotoAndPlay(frame:Dynamic):Void;
	public function gotoAndStop(frame:Dynamic):Void;
	public function play():Void;
	public function stop():Void;
	
}
