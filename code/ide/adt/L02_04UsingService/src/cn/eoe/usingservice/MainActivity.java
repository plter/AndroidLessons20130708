package cn.eoe.usingservice;

import cn.eoe.usingservice.EchoService.EchoServiceBinder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, ServiceConnection {

	private static final String TAG  = "MainActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		serviceIntent = new Intent(this, EchoService.class);
		
		findViewById(R.id.btnStartService).setOnClickListener(this);
		findViewById(R.id.btnStopService).setOnClickListener(this);
		findViewById(R.id.btnBindService).setOnClickListener(this);
		findViewById(R.id.btnUnbindService).setOnClickListener(this);
		findViewById(R.id.btnGetNum).setOnClickListener(this);
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
		case R.id.btnStartService:
			startService(serviceIntent);
			break;
		case R.id.btnStopService:
			stopService(serviceIntent);
			break;
		case R.id.btnGetNum:
			if (binder1!=null) {
				try {
					Toast.makeText(this, "当前服务内部的值是："+binder1.getI(), Toast.LENGTH_SHORT).show();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
			break;
		case R.id.btnBindService:
			bindService(serviceIntent, this, BIND_AUTO_CREATE);
			break;
		case R.id.btnUnbindService:
			unbindService(this);
//			binder = null;
			binder1 = null;
			break;
		default:
			break;
		}
	}
	
	private Intent serviceIntent;
	private EchoService.EchoServiceBinder binder = null;
	private EchoServiceRemoteBinder binder1 = null;

	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		
//		Intent i = new Intent();
//		i.setComponent(new Comp)
		
		Log.i(TAG, "onServiceConnected");
//		binder = (EchoServiceBinder) service;
		
		binder1 = EchoServiceRemoteBinder.Stub.asInterface(service);
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
	}
	
	

}
