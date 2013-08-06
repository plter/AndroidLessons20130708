/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class Shadow {
	
	public function new( color:String , offsetX:Float , offsetY:Float , blur:Float ):Void;
	
	public var blur:Float;
	public var color:String;
	public static var identity:Shadow;
	public var offsetX:Float;
	public var offsetY:Float;
	public function clone():Shadow;
	public function toString():String;
}
