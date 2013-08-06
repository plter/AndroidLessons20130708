/**
 * @author plter
 * @see http://plter.sinaapp.com
 */

package createjs;

extern class SpriteSheetUtils {
	
	public static function extractFrame ( spriteSheet:SpriteSheet , frame:Float ):Dynamic;
	public static function flip ( spriteSheet:SpriteSheet , flipData:Dynamic ):Void;
	public static function mergeAlpha ( rbgImage:Dynamic , alphaImage:Dynamic , canvas:Dynamic ):Dynamic;
	
}
