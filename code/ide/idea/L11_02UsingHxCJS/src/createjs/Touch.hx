/**
 * @author plter
 * @see http://plter.sinaapp.com
 */

package createjs;

extern class Touch {
	
	public static function disable(stage:Stage):Void;
	public static function enable ( stage:Stage , singleTouch:Bool=false , allowDefault:Bool=false ):Bool;
	public static function isSupported():Bool;
}
