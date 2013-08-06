/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class ColorMatrixFilter {
	
	public function new(matrix:Dynamic):Void;
	
	public function applyFilter ( ctx2d:Dynamic , x:Float , y:Float , width:Float , height:Float , targetCtx:Dynamic , targetX:Float , targetY:Float ):Void;
	public function clone():ColorMatrixFilter;
	public function toString():String;
}
