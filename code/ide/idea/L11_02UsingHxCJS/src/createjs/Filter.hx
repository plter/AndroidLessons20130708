/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class Filter {
	
	public function new():Void;

	public function applyFilter ( ctx2d:Dynamic , x:Float , y:Float , width:Float , height:Float , targetCtx:Dynamic , targetX:Float , targetY:Float ):Void;
	public function clone():Filter;
	public function toString():String;
	public function getBounds():Rectangle;
}
