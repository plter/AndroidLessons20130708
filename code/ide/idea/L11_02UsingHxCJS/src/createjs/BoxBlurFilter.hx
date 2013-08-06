/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class BoxBlurFilter {
	
	public function new(blurX:Float , blurY:Float , quality:Float):Void;
	
	public function applyFilter ( ctx2d:Dynamic , x:Float , y:Float , width:Float , height:Float , targetCtx:Dynamic , targetX:Float , targetY:Float ):Void;
	public function clone():BoxBlurFilter;
	public function toString():String;
	public function getBounds():Rectangle;
	
}
