package cn.eoe.remotecall;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) findViewById(R.id.tv);
		
		new RCServer("http://10.0.2.2:8080/L10_05RemoteCall/index.jsp"){
			protected void onResult(Object result, int resultCode, int taskId) {
				tv.setText(result.toString());
			};
		}.call("hello", "Lisi");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
