package cn.eoe.bitmap;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	
	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iv = (ImageView) findViewById(R.id.iv);
		
		Bitmap b = ((BitmapDrawable)(getResources().getDrawable(R.drawable.yangmi))).getBitmap();
		iv.setImageBitmap(b);
//		iv.setImageBitmap(null);
		
//		b.recycle();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
