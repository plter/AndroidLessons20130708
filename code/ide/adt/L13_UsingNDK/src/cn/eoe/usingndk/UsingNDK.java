package cn.eoe.usingndk;

public class UsingNDK {

	public native int getNum();
	
	static{
		System.loadLibrary("usingndk");
	}
}
