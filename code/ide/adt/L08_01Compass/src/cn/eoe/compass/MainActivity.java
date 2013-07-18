package cn.eoe.compass;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;

import com.plter.android.game2d.display.GameView;
import com.plter.android.game2d.display.Image;
import com.plter.android.game2d.tools.BitmapLoader;

public class MainActivity extends Activity implements SensorEventListener {
	
	
	private SensorManager sm;
	private Sensor s;
	private static final String TAG = "Compass";
	private Image img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		gv = new GameView(this);
		setContentView(gv);
		
		img = new Image(BitmapLoader.loadBitmap(this, R.drawable.pointer));
		gv.add(img);
		
		img.x = 100;
		img.y = 100;
		img.regX = img.getWidth()/2;
		img.regY = img.getHeight()/2;
		img.rotation = 45;
		
		sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		s = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		
//		List<Sensor> sensors = sm.getSensorList(Sensor.TYPE_ALL);
		
//		for (Sensor sensor : sensors) {
//			Log.i(TAG, sensor.getName()+","+sensor.getType());
//		}
		
		
	}
	
	
	@Override
	protected void onResume() {
		
		sm.registerListener(this, s, SensorManager.SENSOR_DELAY_FASTEST);
		
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		
		sm.unregisterListener(this);
		
		super.onPause();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private GameView gv;

	@Override
	public void onSensorChanged(SensorEvent event) {
		
		switch (event.sensor.getType()) {
		case Sensor.TYPE_ORIENTATION:
//			Log.i(TAG, event.values[0]+"");
			img.rotation = 180-event.values[0];
			break;
		}
	}


	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

}
