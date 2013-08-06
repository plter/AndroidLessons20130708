/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class Matrix2D {

	public function new( a:Float , b:Float , c:Float , d:Float , tx:Float , ty:Float ):Void;

	public var a:Float;
	public var alpha:Float;
	public var atx:Float;
	public var b:Float;
	public var c:Float;
	public var compositeOperation:String;
	public var d:Float;
	public static var DEG_TO_RAD:Float;
	public var shadow:Shadow;
	public var ty:Float;
	
	public function append(a:Float , b:Float , c:Float , d:Float , tx:Float , ty:Float ):Matrix2D;
	public function appendMatrix(mat:Matrix2D):Matrix2D;
	public function appendProperties(a:Float , b:Float , c:Float , d:Float , tx:Float , ty:Float,alpha:Float , shadow:Shadow , compositeOperation:String ):Matrix2D;
	public function appendTransform(x:Float , y:Float , scaleX:Float , scaleY:Float , rotation:Float , skewX:Float , skewY:Float , regX:Float=0 , regY:Float=0):Matrix2D;
	public function clone():Matrix2D;
	public function decompose(target:Dynamic):Matrix2D;
	public function identity():Matrix2D;
	public function invert():Matrix2D;
	public function isIdentity():Bool;
	public function prepend(a:Float , b:Float , c:Float , d:Float , tx:Float , ty:Float ):Matrix2D;
	public function prependMatrix():Void;
	public function prependProperties(alpha:Float , shadow:Shadow , compositeOperation:String):Matrix2D;
	public function prependTransform(x:Float , y:Float , scaleX:Float , scaleY:Float , rotation:Float , skewX:Float , skewY:Float , regX:Float=0 , regY:Float=0):Matrix2D;
	public function rotate(angle:Float):Matrix2D;
	public function scale(x:Float,y:Float):Matrix2D;
	public function skew(skewX:Float,skewY:Float):Matrix2D;
	public function translate(x:Float,y:Float):Matrix2D;
	
}
