/**
 * @author plter
 * @see http://plter.sinaapp.com
 */

package createjs;

extern class AlphaMapFilter {

	/**
	 * @param alphaMap The greyscale image (or canvas) to use as the alpha value for the result. This should be exactly the same dimensions as the target.
	 */
	public function new(alphaMap:Dynamic):Void;
	
	public function applyFilter ( ctx2d:Dynamic , x:Float , y:Float , width:Float , height:Float , targetCtx:Dynamic , targetX:Float , targetY:Float ):Void;
	public function clone():AlphaMapFilter;
	public function toString():String;
	
}
