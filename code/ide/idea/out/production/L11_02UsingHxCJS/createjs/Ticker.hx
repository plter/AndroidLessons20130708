/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class Ticker {

	public static var useRAF:Bool;
	
	public static function addListener(stage:Stage , pauseable:Bool=true):Void;
	public static function getFPS():Float;
	public static function getInterval():Float;
	public static function getMeasuredFPS(ticks:Float):Float;
	public static function getPaused():Bool;
	public static function getTicks(pauseable:Bool=false):Float;
	public static function getTime(pauseable:Bool):Float;
	public static function init():Void;
	public static function removeAllListeners():Void;
	public static function removeListener(o:Dynamic):Void;
	public static function setFPS(fps:Float):Void;
	public static function setInterval(interval:Float):Void;
	public static function setPaused(b:Bool):Void;
	
	//Events
	public static var tick:Float->Void;
	
}
