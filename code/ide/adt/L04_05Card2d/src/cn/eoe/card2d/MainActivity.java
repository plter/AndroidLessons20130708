package cn.eoe.card2d;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener, AnimationListener {
	
	
	private ImageView ivRecto,ivVerso;
	private FrameLayout root;
	private ScaleAnimation sa120;
	private ScaleAnimation sa021;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sa021 = new ScaleAnimation(0, 1, 1, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		sa120 = new ScaleAnimation(1, 0, 1, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		sa021.setDuration(350);
		sa120.setDuration(350);
		sa120.setAnimationListener(this);
		
		root = (FrameLayout) findViewById(R.id.root);
		ivRecto = (ImageView) findViewById(R.id.ivRecto);
		ivVerso = (ImageView) findViewById(R.id.ivVerso);
		
		root.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if (rectoVisible) {
			turnToVerso();
		}else{
			turnToRecto();
		}
	}
	
	public void turnToVerso() {
		if (rectoVisible) {
			ivRecto.startAnimation(sa120);
		}
	}
	
	public void turnToRecto(){
		if (!rectoVisible) {
			ivVerso.startAnimation(sa120);
		}
	}
	
	
	public void showRecto(){
		ivRecto.setVisibility(View.VISIBLE);
		ivVerso.setVisibility(View.INVISIBLE);
		rectoVisible = true;
	}
	
	public void showVerso(){
		ivRecto.setVisibility(View.INVISIBLE);
		ivVerso.setVisibility(View.VISIBLE);
		rectoVisible = false;
	}
	
	public boolean isRectoVisile(){
		return ivRecto.getVisibility()==View.VISIBLE;
	}
	
	private boolean rectoVisible= true;
	

	@Override
	public void onAnimationStart(Animation animation) {
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		if (rectoVisible) {
			showVerso();
			ivVerso.startAnimation(sa021);
		}else{
			showRecto();
			ivRecto.startAnimation(sa021);
		}
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
	}

}
