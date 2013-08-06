/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class Container extends DisplayObject{
	
	public function new():Void;

	public var children:Array<DisplayObject>;
	
	public function addChild(child:DisplayObject):DisplayObject;
	public function addChildAt(child:DisplayObject,index:Int):DisplayObject;
	public function contains(child:DisplayObject):Bool;
	public function getChildAt(index:Int):DisplayObject;
	public function getChildIndex(child:DisplayObject):Int;
	public function getNumChildren():Int;
	public function getObjectsUnderPoint(x:Float,y:Float):Array<DisplayObject>;
	public function getObjectUnderPoint(x:Float,y:Float):DisplayObject;
	public function removeAllChildren():Void;
	public function removeChild(child:DisplayObject):Bool;
	public function removeChildAt(index:Int):Bool;
	public function setChildIndex(child:DisplayObject,index:Int):Void;
	public function sortChildren(sortFunction:Dynamic):Void;
	public function swapChildren(child1:DisplayObject,child2:DisplayObject):Void;
	public function swapChildrenAt(index1:Int,index2:Int):Void;
	
	
}
