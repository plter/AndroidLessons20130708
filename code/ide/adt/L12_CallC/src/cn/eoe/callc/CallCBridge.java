package cn.eoe.callc;

public class CallCBridge {
	public native int getNum();
	
	
	static{
		System.loadLibrary("CallC");
	}
}
