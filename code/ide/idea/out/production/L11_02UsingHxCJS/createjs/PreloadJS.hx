package createjs;

extern class PreloadJS extends AbstractLoader{
	
	public function new(useXHR2:Bool):Void;
	
	public static var CSS:String="css";
	public static var IMAGE:String="image";
	public static var JAVASCRIPT:String='javascript';
	public static var JSON:String="json";
	public static var SOUND:String="sound";
	public static var TEXT:String="text";
	public static var TIMEOUT_TIME:Int=8000;
	public static var XML:String="xml";
	
	public var maintainScriptOrder:Bool;
	public var next:PreloadJS;
	public var stopOnError:Bool;
	public var useXHR:Bool;
	
	public function BrowserDetect():Dynamic;
	public function close():Void;
	public function getResult(value:String):Dynamic;
	public function initialize(useXHR:Bool):Void;
	public function installPlugin(plugin:Dynamic):Void;
	public function loadFile(file:Dynamic,loadNow:Bool=true):Void;
	public function loadManifest(manifest:Array<Dynamic>,loadNow:Bool=true):Void;
	public function setMaxConnections(value:Int):Void;
	public function setPaused(value:Bool):Void;
}
