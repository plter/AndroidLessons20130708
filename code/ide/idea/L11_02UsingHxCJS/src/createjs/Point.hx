/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class Point {

	public function new(x:Float,y:Float):Void;
	
	public var x:Float;
	public var y:Float;
	
	public function clone():Point;
}
