/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class Stage extends Container{
	
	public function new(canvasElement:Dynamic):Void;
	
	public var autoClear:Bool;
	public var canvas:Dynamic;
	public var mouseInBounds:Bool;
	public var mouseX:Float;
	public var mouseY:Float;
	public var snapToPixelEnabled:Bool;
	public var tickOnUpdate:Bool;
	
	public function update():Void;
	public function clear():Void;
	public function enableMouseOver(frequency:Float=20):Void;
	public function toDataURL ( backgroundColor:String="rgba(255,255,255,0)" , mimeType:String="image/png" ):String;
}
