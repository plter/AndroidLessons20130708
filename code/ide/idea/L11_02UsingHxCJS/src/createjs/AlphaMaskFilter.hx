/**
 * @author plter
 * @see http://plter.sinaapp.com
 */

package createjs;

extern class AlphaMaskFilter {
	public function new(alphaMap:Dynamic):Void;
	
	public function applyFilter ( ctx2d:Dynamic , x:Float , y:Float , width:Float , height:Float , targetCtx:Dynamic , targetX:Float , targetY:Float ):Void;
	public function clone():AlphaMaskFilter;
	public function toString():String;
}
