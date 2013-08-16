package cn.eoe.loaddata;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView) findViewById(R.id.tv);
	}

	private TextView tv;

	@Override
	protected void onResume() {


		final ProgressDialog pd = ProgressDialog.show(this, "加载", "正在加载数据，请稍候");
		new NetLoader(){

			protected void onPostExecute(String result) {

				pd.dismiss();
				
				if (result!=null) {
					tv.setText(result);
				}else{
					Toast.makeText(MainActivity.this, "加载数据失败", Toast.LENGTH_SHORT).show();
				}
			};

		}.execute("http://baidu.com");

		super.onResume();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
