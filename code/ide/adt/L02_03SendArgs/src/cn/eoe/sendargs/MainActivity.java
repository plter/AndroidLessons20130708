package cn.eoe.sendargs;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	private EditText etInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etInput = (EditText) findViewById(R.id.etInput);
		
		
		findViewById(R.id.btnStartAty).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (TextUtils.isEmpty(etInput.getText())) {
					Toast.makeText(MainActivity.this, "输入文本不能为空", Toast.LENGTH_SHORT).show();
				}else{
					Intent i = new Intent(MainActivity.this, Aty.class);
					i.putExtra(Aty.EXTRA_KEY_DATA, etInput.getText().toString());
//					startActivity(i);
					startActivityForResult(i, 1);
				}
			}
		});
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		switch (resultCode) {
		case Activity.RESULT_OK:
			Toast.makeText(MainActivity.this, "返回结果是："+data.getStringExtra(Aty.EXTRA_KEY_DATA), Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
		
		super.onActivityResult(requestCode, resultCode, data);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
