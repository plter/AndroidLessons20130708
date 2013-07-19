package cn.eoe.usingsp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends Activity implements OnCheckedChangeListener {
	
	
	private CheckBox cb;
	private SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		sp = getSharedPreferences("data", Context.MODE_PRIVATE);
		sp = getSharedPreferences("data", Context.MODE_MULTI_PROCESS);
		
		cb = (CheckBox) findViewById(R.id.cb);
		cb.setOnCheckedChangeListener(this);
		refreshCb();
	}
	
	
	private void refreshCb(){
		cb.setChecked(sp.getBoolean("checked", false));
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		
		Editor e = sp.edit();
		e.putBoolean("checked", isChecked);
		e.commit();
		
		refreshCb();
	}

}
