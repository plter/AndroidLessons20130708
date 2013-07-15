package cn.eoe.translateanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	
	private Button btnTanslateMe;
	private Animation ta;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		ta = new TranslateAnimation(0, 200, 0, 100);
//		ta.setDuration(1000);
		
		ta = AnimationUtils.loadAnimation(this, R.anim.move_btn);
//		ta.setFillAfter(true);
		
		btnTanslateMe = (Button) findViewById(R.id.btnTanslateMe);
		btnTanslateMe.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		btnTanslateMe.startAnimation(ta);
		
	}

}
