package cn.eoe.usingbr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBR extends BroadcastReceiver {
	
	
	public static final String ACTION  = "cn.eoe.usingbr.MyBR";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("MyBR", "onReceive");
	}

}
