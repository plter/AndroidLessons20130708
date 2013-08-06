/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class DisplayObject {

	public var alpha:Float;
	public var cacheCanvas:Dynamic;
	public var cacheID:Float;
	public var compositeOperation:String;
	public var filters:Array<Dynamic>;
	public var hitArea:DisplayObject;
	public var id:Float;
	public var mask:Shape;
	public var mouseEnabled:Bool;
	public var name:String;
	public var parent:DisplayObject;
	public var regX:Float;
	public var regY:Float;
	public var rotation:Float;
	public var scaleX:Float;
	public var scaleY:Float;
	public var shadow:Shadow;
	public var skewX:Float;
	public var skewY:Float;
	public var snapToPixel:Bool;
	public var visible:Bool;
	public var x:Float;
	public var y:Float;
	
	public static var suppressCrossDomainErrors:Bool;
	
	
	public function cache(x:Float,y:Float,width:Float,height:Float,scale:Float=1):Void;
	public function clone(recursive:Bool=false):DisplayObject;
	public function draw(context2d:Dynamic,ignoreCache:Bool):Void;
	public function getCacheDataURL():Dynamic;
	public function getConcatenatedMatrix(mat:Matrix2D):Matrix2D;
	public function getMatrix(mat:Matrix2D):Matrix2D;
	public function getStage():Stage;
	public function globalToLocal(x:Float,y:Float):Point;
	public function hitTest(x:Float,y:Float):Bool;
	public function isVisible():Bool;
	public function localToGlobal(x:Float,y:Float):Point;
	public function localToLocal(x:Float,y:Float,target:DisplayObject):Point;
	public function setTransform(x:Float , y:Float , scaleX:Float , scaleY:Float , rotation:Float , skewX:Float , skewY:Float , regX:Float , regY:Float):DisplayObject;
	public function setupContext(context2d:Dynamic):Void;
	public function toString():String;
	public function uncache():Void;
	public function updateCache(compositeOperation:String):Void;
	
	//Events
	public var onClick:MouseEvent->Void;
	public var onDoubleClick:MouseEvent->Void;
	public var onMouseOut:MouseEvent->Void;
	public var onMouseOver:MouseEvent->Void;
	public var onPress:MouseEvent->Void;
	public var onTick:Void->Void;
}
