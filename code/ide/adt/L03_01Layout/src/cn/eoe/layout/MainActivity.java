package cn.eoe.layout;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener {
	
	
	private LinearLayout ll;
	private LinearLayout.LayoutParams lp;
	private Button btn;
	private Button btnChangeLayoutParams;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ll);
		
		ll = (LinearLayout) findViewById(R.id.root);
		
		for (int i = 0; i < 5; i++) {
			btn = new Button(this);
			btn.setText("Remove me");
			
			Log.i("Btn ID", btn.getId()+"<<<<<<<<<<<<");
			
//			lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//			lp = new LinearLayout.LayoutParams(-2, -2);
//			ll.addView(btn, lp);
			
			ll.addView(btn, -2, -2);
			
			btn.setOnClickListener(this);
		}
		
		btnChangeLayoutParams = new Button(this);
		btnChangeLayoutParams.setText("切换布局参数");
		ll.addView(btnChangeLayoutParams, -1, -2);
		btnChangeLayoutParams.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) v.getLayoutParams();
//				lp.width = lp.width==-1?-2:-1;
				lp.width = -3-lp.width;
				v.setLayoutParams(lp);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
//		((LinearLayout)v.getParent()).removeView(v);
		ll.removeView(v);
	}

}
