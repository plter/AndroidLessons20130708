package cn.eoe.touches;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnTouchListener {
	
	
	private LinearLayout ll;
	private static final String TAG = "Touches";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ll = (LinearLayout) findViewById(R.id.root);
		ll.setOnTouchListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	private float distance=-1;
	private float currentDistance = -1;

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		
//		Log.i(TAG, "action:"+event.getAction());
		
//		Log.e(TAG, "Pointer count:"+event.getPointerCount());
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_MOVE:
			if (event.getPointerCount()>=2) {
				float x1 = event.getX(0);
				float y1 = event.getY(0);
				float x2 = event.getX(1);
				float y2 = event.getY(1);
				float disX = x1-x2;
				float disY = y1-y2;
				
				currentDistance = (float) Math.sqrt(disX*disX+disY*disY);
				
				if (distance>-1) {
					if (currentDistance-distance>10) {
						Log.i(TAG, "放大");
						distance = currentDistance;
					}else if(currentDistance-distance<-10){
						Log.i(TAG, "缩小");
						distance = currentDistance;
					}
				}else{
					distance = currentDistance;
				}
			}
			break;
		}
		return true;
	}

}
