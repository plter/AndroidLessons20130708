package cn.eoe.startserviceinotherapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.btnStart).setOnClickListener(this);
		findViewById(R.id.btnStop).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnStart:
			startService(serviceIntent);
			break;
		case R.id.btnStop:
			stopService(serviceIntent);
			break;

		default:
			break;
		}
	}

	private Intent serviceIntent = new Intent("cn.eoe.usingservice.intent.action.EchoService");
}
