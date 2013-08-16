package cn.eoe.usingas;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	
	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) findViewById(R.id.tv);
	}
	
	
	private TimerTask task;
	
	@Override
	protected void onResume() {
		
		task = new TimerTask(){
			@Override
			protected void onProgressUpdate(Integer... values) {
				
				tv.setText(values[0]+"");
				
				super.onProgressUpdate(values);
			}
		};
		
		task.execute();
		super.onResume();
	}
	
	
	@Override
	protected void onPause() {
		task.stop();
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
