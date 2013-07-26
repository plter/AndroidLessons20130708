package cn.eoe.customevent;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity implements OnNumberChangedListener {
	
	
	private AddNumTask addNumTask;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) findViewById(R.id.tv);
	}
	
	
	@Override
	protected void onResume() {
		
		addNumTask = new AddNumTask();
		addNumTask.setOnNumberChangedListener(this);
		
		
		addNumTask.execute();
		
		super.onResume();
	}
	
	
	@Override
	protected void onPause() {
		
		addNumTask.stop();
		
		super.onPause();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onChange(int value) {
		tv.setText(value+"");
	}

}
