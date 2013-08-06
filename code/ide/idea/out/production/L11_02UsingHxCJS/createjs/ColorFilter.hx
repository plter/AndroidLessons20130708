/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class ColorFilter {
	
	public function new(redMultiplier:Float , 
					greenMultiplier:Float , 
					blueMultiplier:Float , 
					alphaMultiplier:Float , 
					redOffset:Float , 
					greenOffset:Float , 
					blueOffset:Float , 
					alphaOffset:Float ):Void;
					
	public var alphaOffset:Float;
	public var blueMultiplier:Float;
	public var blueOffset:Float;
	public var greenMultiplier:Float;
	public var greenOffset:Float;
	public var redMultiplier:Float;
	public var redOffset:Float;
	
	public function applyFilter ( ctx2d:Dynamic , x:Float , y:Float , width:Float , height:Float , targetCtx:Dynamic , targetX:Float , targetY:Float ):Void;
	public function clone():ColorFilter;
	public function toString():String;
}
