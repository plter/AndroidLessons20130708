/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class Graphics {
	
	public function new():Void;
	
	public static var BASE_64:Dynamic;
	public static var STROKE_CAPS_MAP:Array<String>;
	public static var STROKE_JOINTS_MAP:Array<String>;
	
	public function curveTo(cpx:Float , cpy:Float , x:Float , y:Float):Void;
	public function drawRect(x:Float , y:Float , width:Float , height:Float):Void;
	
	public function arc(x:Float , y:Float , radius:Float , startAngle:Float , endAngle:Float , anticlockwise:Bool=false):Graphics;
	public function arcTo ( x1:Float , y1:Float , x2:Float , y2:Float , radius:Float ):Graphics;
	
	/**
	 * @param image			The Image, Canvas, or Video object to use as the pattern.
	 * @param repetition	Optional. Indicates whether to repeat the image in the fill area. One of "repeat", "repeat-x", "repeat-y", or "no-repeat". Defaults to "repeat".
	 */
	public function beginBitmapFill ( image:Dynamic , repetition:String="repeat" ):Graphics;
	public function beginBitmapStroke ( image:Dynamic , repetition:String="repeat" ):Graphics;
	public function beginFill ( color:String ):Graphics;
	public function beginLinearGradientFill ( colors:Array<String> , ratios:Array<Float> , x0:Float , y0:Float , x1:Float , y1:Float ):Graphics;
	public function beginLinearGradientStroke ( colors:Array<String> , ratios:Array<Float> , x0:Float , y0:Float , x1:Float , y1:Float ):Graphics;
	public function beginRadialGradientFill ( colors:Array<String> , ratios:Array<Float> , x0:Float , y0:Float,r0:Float , x1:Float , y1:Float,r1:Float ):Graphics;
	public function beginRadialGradientStroke ( colors:Array<String> , ratios:Array<Float> , x0:Float , y0:Float,r0:Float , x1:Float , y1:Float,r1:Float ):Graphics;
	public function beginStroke ( color:String ):Graphics;
	public function bezierCurveTo ( cp1x:Float , cp1y:Float , cp2x:Float , cp2y:Float , x:Float , y:Float  ):Graphics;
	public function clear ():Graphics;
	public function clone ():Graphics;
	public function closePath ():Graphics;
	public function decodePath (str:String):Graphics;
	public function draw (context2d:Dynamic):Void;
	public function drawAsPath (context2d:Dynamic):Void;
	public function drawCircle ( x:Float , y:Float , radius:Float ):Graphics;
	public function drawEllipse ( x:Float , y:Float , w:Float , h:Float ):Graphics;
	public function drawPolyStar ( x:Float , y:Float , radius:Float , sides:Float , pointSize:Float , angle:Float ):Graphics;
	public function drawRoundRect ( x:Float , y:Float , w:Float , h:Float , radius:Float ):Graphics;
	public function drawRoundRectComplex ( x:Float , y:Float , w:Float , h:Float , radiusTL:Float , radiusTR:Float , radiusBR:Float , radiusBL:Float ):Graphics;
	public function endFill ():Graphics;
	public function endStroke ():Graphics;
	public function lineTo ( x:Float , y:Float ):Graphics;
	public function moveTo ( x:Float , y:Float ):Graphics;
	public function quadraticCurveTo ( cpx:Float , cpy:Float , x:Float , y:Float ):Graphics;
	public function rect ( x:Float , y:Float , w:Float , h:Float ):Graphics;
	public function setStrokeStyle ( thickness:Dynamic , caps:Dynamic="butt" , joints:Dynamic="miter" , miter:Dynamic=null ):Graphics;
	public function toString ():String;
	
	public static function getHSL ( hue:Float , saturation:Float , lightness:Float , alpha:Float=1 ):String;
	public static function getRGB ( r:Float , g:Float , b:Float , alpha:Float=1 ):String;
	
}
