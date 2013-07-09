package cn.eoe.sendargs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Aty extends Activity {

	
	private EditText etInput;
	private TextView tvOut;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty);
		
		String value = getIntent().getStringExtra(EXTRA_KEY_DATA);
		
		
		etInput = (EditText) findViewById(R.id.etInput);
		tvOut = (TextView) findViewById(R.id.tvOut);
		tvOut.setText(value);
		
		
		findViewById(R.id.btnFinish).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if (TextUtils.isEmpty(etInput.getText())) {
					Toast.makeText(Aty.this, "输入文本不能为空", Toast.LENGTH_SHORT).show();
				}else{
					
					Intent i = new Intent();
					i.putExtra(EXTRA_KEY_DATA, etInput.getText().toString());
					setResult(Activity.RESULT_OK, i);
					
					finish();
				}
			}
		});
	}
	
	
	public static final String EXTRA_KEY_DATA ="data";
	
}
