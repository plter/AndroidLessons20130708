package createjs;

extern class AbstractLoader {
	
	public function new():Void{}
	
	public var canceled:Bool;
	public var loaded:Bool;
	public var progress:Float;
	
	public function cancel():Void;
	public function getItem():Dynamic;
	public function load():Void;
	
	public var onComplete:Void->Void;
	public var onError:Void->Void;
	public var onFileLoad:Void->Void;
	public var onFileProgress:Void->Void;
	public var onLoadStart:Void->Void;
	public var onProgress:Void->Void;
	
}
