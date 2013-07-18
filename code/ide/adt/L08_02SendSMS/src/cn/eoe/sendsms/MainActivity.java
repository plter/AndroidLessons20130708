package cn.eoe.sendsms;

import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	private SmsManager sm;
	private EditText etNum,etContent;
	private SendSMSBR sendSMSBR;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sm = SmsManager.getDefault();
		
		sendSMSBR = new SendSMSBR();
		
		etNum = (EditText) findViewById(R.id.etNumInput);
		etContent = (EditText) findViewById(R.id.etContent);
		
		findViewById(R.id.btnSendSMS).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
		
		registerReceiver(sendSMSBR, new IntentFilter(SendSMSBR.ACTION));
		
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		unregisterReceiver(sendSMSBR);
		super.onPause();
	}
	

	@Override
	public void onClick(View v) {
		if (TextUtils.isEmpty(etNum.getText())) {
			Toast.makeText(this, "电话号码不能为空", Toast.LENGTH_SHORT).show();
			return;
		}
		if (TextUtils.isEmpty(etContent.getText())) {
			Toast.makeText(this, "文字内容不能为空", Toast.LENGTH_SHORT).show();
			return;
		}
		
		
		/**
		 * sentIntent 是用来侦听发送者与服务中心连接的状态
		 * deliveryIntent 是用来侦听服务中心与目标号码的连接状态
		 */
		sm.sendTextMessage(etNum.getText().toString(), null, etContent.getText().toString(), PendingIntent.getBroadcast(this, 1, new Intent(SendSMSBR.ACTION), PendingIntent.FLAG_UPDATE_CURRENT), null);
	}

}
