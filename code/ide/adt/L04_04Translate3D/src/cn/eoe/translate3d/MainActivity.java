package cn.eoe.translate3d;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
	
	
	private ImageView iv;
	private Translate3D t3d;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		t3d = new Translate3D();
		t3d.setDuration(3000);
		t3d.setFillAfter(true);
		
		iv = (ImageView) findViewById(R.id.iv);
		iv.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		iv.startAnimation(t3d);
	}

}
