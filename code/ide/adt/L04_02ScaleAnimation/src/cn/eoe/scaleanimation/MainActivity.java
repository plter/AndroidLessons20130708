package cn.eoe.scaleanimation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, AnimationListener {
	
	
	private Button btnScaleMe;
	private ScaleAnimation sa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		sa = new ScaleAnimation(0, 1, 0, 1);
//		sa = new ScaleAnimation(0, 1, 0, 1, 50, 50);
		sa = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		sa.setDuration(1000);
		
		btnScaleMe = (Button) findViewById(R.id.btnScaleMe);
		btnScaleMe.setOnClickListener(this);
		
		sa.setAnimationListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		btnScaleMe.startAnimation(sa);
	}

	@Override
	public void onAnimationStart(Animation animation) {
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		Toast.makeText(this, "动画执行完毕", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
	}

}
