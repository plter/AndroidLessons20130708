package cn.eoe.internalstorage;

import android.content.Context;

public class Bundle {

	private Bundle() {
		
	}
	
	private Context context=null;
	
	public Context getContext() {
		return context;
	}
	
	void setContext(Context context) {
		this.context = context;
	}
	
	private static Bundle __b=null;
	public static Bundle getInstance(){
		if (__b==null) {
			__b = new Bundle();
		}
		return __b;
	}
}
