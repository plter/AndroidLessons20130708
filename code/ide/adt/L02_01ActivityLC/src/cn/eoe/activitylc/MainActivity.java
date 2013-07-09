package cn.eoe.activitylc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	
	public static final String TAG = "MainActivity";
	
//	class ClickHandler implements View.OnClickListener{
//		
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
//		findViewById(R.id.btnStartAtyA).setOnClickListener(new ClickHandler());
		findViewById(R.id.btnStartAtyA).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, AtyA.class));
			}
		});
		
		
//		System.out.println("onCreate");
		
		Log.i(TAG, "onCreate");
//		Log.d(TAG, "onCreate");
//		Log.w(TAG, "onCreate");
//		Log.e(TAG, "onCreate");
	}
	
	
	
	
	
	@Override
	protected void onStart() {
		Log.i(TAG, "onStart");
		super.onStart();
	}
	
	
	@Override
	protected void onResume() {
		Log.i(TAG, "onResume");
		super.onResume();
	}
	
	
	@Override
	protected void onPause() {
		Log.i(TAG, "onPause");
		super.onPause();
	}
	
	@Override
	protected void onStop() {
		Log.i(TAG, "onStop");
		super.onStop();
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
//		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com")));
	}
	
	
	@Override
	protected void onDestroy() {
		Log.i(TAG, "onDestory");
		super.onDestroy();
	}
	
	@Override
	protected void onRestart() {
		Log.i(TAG, "onRestart");
		super.onRestart();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
