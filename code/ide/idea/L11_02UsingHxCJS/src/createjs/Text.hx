/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class Text extends DisplayObject{

	public function new(text:String="" , font:String="12pt Courier" , color:String="#000000" ):Void;
	
	public var color:String;
	public var font:String;
	public var lineHeight:Float;
	public var lineWidth:Float;
	public var maxWidth:Float;
	public var outline:Bool;
	public var text:String;
	public var textAlign:String;
	public var textBaseline:String;

	public function getMeasuredHeight():Float;
	public function getMeasuredLineHeight():Float;
	public function getMeasuredWidth():Float;
	
}
