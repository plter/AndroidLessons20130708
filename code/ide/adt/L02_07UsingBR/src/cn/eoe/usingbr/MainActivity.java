package cn.eoe.usingbr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		br = new MyBR();
		
		findViewById(R.id.btnSendBc).setOnClickListener(this);
		findViewById(R.id.btnRegBcr).setOnClickListener(this);
		findViewById(R.id.btnUnregBcr).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
//		sendBroadcast(new Intent(this, MyBR.class));
		
		switch (v.getId()) {
		case R.id.btnRegBcr:
			registerReceiver(br, new IntentFilter(MyBR.ACTION));
			break;
		case R.id.btnUnregBcr:
			unregisterReceiver(br);
			break;
		case R.id.btnSendBc:
			sendBroadcast(new Intent(MyBR.ACTION));
			break;

		default:
			break;
		}
	}
	
	private MyBR br;

}
