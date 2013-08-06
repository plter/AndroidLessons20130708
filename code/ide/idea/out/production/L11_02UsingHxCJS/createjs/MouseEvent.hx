/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class MouseEvent {
	
	public function new(type:String , stageX:Float , stageY:Float , target:DisplayObject , nativeEvent:Dynamic , pointerID:Float , primary:Bool , rawX:Float , rawY:Float):Void;
	public var type:String ;
	public var stageX:Float;
	public var stageY:Float;
	public var target:DisplayObject;
	public var nativeEvent:Dynamic;
	public var pointerID:Float;
	public var primary:Bool;
	public var rawX:Float;
	public var rawY:Float;


	public function clone():MouseEvent;
	public function toString():String;
}
