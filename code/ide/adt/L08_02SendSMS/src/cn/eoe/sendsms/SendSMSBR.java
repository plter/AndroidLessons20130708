package cn.eoe.sendsms;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SendSMSBR extends BroadcastReceiver{

	public static final String ACTION = "cn.eoe.sendsms.intent.action.SendSMSBR";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		switch (getResultCode()) {
		case Activity.RESULT_OK:
			Toast.makeText(context, "发送成功", Toast.LENGTH_SHORT).show();
			break;
		default:
			Toast.makeText(context, "发送失败", Toast.LENGTH_SHORT).show();
			break;
		}
	}
	
}