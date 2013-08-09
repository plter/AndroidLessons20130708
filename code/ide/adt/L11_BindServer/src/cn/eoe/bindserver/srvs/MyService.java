package cn.eoe.bindserver.srvs;

import java.util.Timer;
import java.util.TimerTask;

import cn.eoe.srvs.MyServiceBinder;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {
	
	public static final String ACTION ="cn.eoe.binderservice.intent.action.srvs.MyService";
	

	@Override
	public IBinder onBind(Intent intent) {
		return new MyServiceBinder.Stub() {
			
			@Override
			public int getNum() throws RemoteException {
				return MyService.this.getNum();
			}
		};
	}
	
	
	public class MyBinder extends Binder{
		public int getNum(){
			return MyService.this.getNum();
		}
	}
	
	
	
	
	@Override
	public void onCreate() {
		System.out.println("onCreate");
		
		timer = new Timer();
		task = new TimerTask() {
			
			@Override
			public void run() {
				num++;
				System.out.println(num);
			}
		};
		timer.schedule(task, 1000, 1000);
		
		super.onCreate();
	}
	
	
	public int getNum() {
		return num;
	}
	
	private int num = 0;
	
	
	@Override
	public void onDestroy() {
		System.out.println("onDestory");
		
		timer.cancel();
		task.cancel();
		
		super.onDestroy();
	}
	
	
	private Timer timer;
	private TimerTask task;

}
