package cn.eoe.bindremoteservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import cn.eoe.usingservice.EchoServiceRemoteBinder;

public class MainActivity extends Activity implements OnClickListener, ServiceConnection {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

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
		case R.id.btnBindService:
			bindService(serviceIntent, this, BIND_AUTO_CREATE);
			break;
		case R.id.btnUnbindService:
			unbindService(this);
			binder = null;
			break;
		case R.id.btnGetNum:
			if (binder!=null) {
				try {
					Toast.makeText(this, "当前服务内部的值是："+binder.getI(), Toast.LENGTH_SHORT).show();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
			break;

		default:
			break;
		}
	}

	private EchoServiceRemoteBinder binder = null;
	private Intent serviceIntent = new Intent("cn.eoe.usingservice.intent.action.EchoService");

	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		Toast.makeText(this, "onServiceConnected", Toast.LENGTH_SHORT).show();

		binder=EchoServiceRemoteBinder.Stub.asInterface(service);
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		// TODO Auto-generated method stub

	}

}
