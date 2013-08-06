/**
 * @author plter
 * @see http://plter.sinaapp.com
 */
 
package createjs;

extern class Bitmap extends DisplayObject{

	/**
	 * @param imageOrUri <Image | HTMLCanvasElement | HTMLVideoElement | String> The source object or URI to an image to display. This can be either an Image, Canvas, or Video object, or a string URI to an image file to load and use. If it is a URI, a new Image object will be constructed and assigned to the .image property.
	 */
	public function new(imageOrUri:Dynamic):Void;
	
	public var image:Dynamic;
	public var sourceRect:Rectangle;
}
