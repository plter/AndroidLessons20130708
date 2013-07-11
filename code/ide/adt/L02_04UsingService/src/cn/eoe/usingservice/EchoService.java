package cn.eoe.usingservice;

import java.util.Timer;
import java.util.TimerTask;

import cn.eoe.usingservice.EchoServiceRemoteBinder.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class EchoService extends Service {
	
	
	public static final String ACTION = "cn.eoe.usingservice.intent.action.EchoService";
	
	private static final String TAG = "EchoService";
	
	
//	@Override
//	public int onStartCommand(Intent intent, int flags, int startId) {
//		
//		Log.i(TAG, "onStartCommand");
//		
//		return super.onStartCommand(intent, flags, startId);
//	}
	

	@Override
	public IBinder onBind(Intent intent) {
		return binder1;
	}
	
	public class RemoteBinder extends Stub{

		@Override
		public int getI() throws RemoteException {
			return EchoService.this.getI();
		}
	}
	
	private RemoteBinder binder1 = new RemoteBinder();
	
	private EchoServiceBinder binder = new EchoServiceBinder();
	
	public class EchoServiceBinder extends Binder{
		public int getI(){
			return EchoService.this.getI();
		}
		
//		public EchoService getService(){
//			return EchoService.this;
//		}
	}
	
	
	@Override
	public void onCreate() {
		Log.i(TAG, "onCreate");
		
		timer = new Timer();
		task = new TimerTask() {
			
			@Override
			public void run() {
				i++;
				Log.i(TAG, i+"<<<<<<<<<<<");
			}
		};
		timer.schedule(task, 1000, 1000);
		
		super.onCreate();
	}
	
	
	private int i = 0;
	
	public int getI() {
		return i;
	}
	
	
	@Override
	public void onDestroy() {
		
		Log.i(TAG, "onDestory");
		
		task.cancel();
		timer.cancel();
		
		super.onDestroy();
	}
	
	private Timer timer;
	private TimerTask task;

}
