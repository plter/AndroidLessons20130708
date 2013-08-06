/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class ColorMatrix {
	
	public function new(brightness:Float , contrast:Float , saturation:Float , hue:Float ):Void;
	
	
	public static var DELTA_INDEX:Array<Dynamic>;
	public static var IDENTITY_MATRIX:Array<Dynamic>;
	public static var LENGTH:Float;
	
	public function adjustBrightness(value:Float):ColorMatrix;
	public function adjustColor ( brightness:Float , contrast:Float , saturation:Float , hue:Float ):ColorMatrix;
	public function adjustContrast(value:Float):ColorMatrix;
	public function adjustHue(value:Float):ColorMatrix;
	public function adjustSaturation(value:Float):ColorMatrix;
	public function clone():ColorMatrix;
	public function concat(matrix:Dynamic):ColorMatrix;
	public function copyMatrix(matrix:Dynamic):ColorMatrix;
	public function reset():ColorMatrix;
	public function toArray():Array<Dynamic>;
	
}
