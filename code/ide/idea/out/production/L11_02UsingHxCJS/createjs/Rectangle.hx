/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class Rectangle {
	
	public function new( x:Float=0 , y:Float=0 , width:Float=0 , height:Float=0 ):Void;
	
	
	public var  x:Float;
	public var y:Float;
	public var width:Float;
	public var height :Float;
	
	public function clone():Rectangle;
	public function toString():String;
}
