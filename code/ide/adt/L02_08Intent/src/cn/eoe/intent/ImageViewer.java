package cn.eoe.intent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewer extends Activity {

	
	private ImageView iv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		iv = new ImageView(this);
		setContentView(iv);
		
		iv.setImageURI(getIntent().getData());
	}
}
