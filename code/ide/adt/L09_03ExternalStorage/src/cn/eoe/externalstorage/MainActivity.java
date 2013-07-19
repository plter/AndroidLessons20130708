package cn.eoe.externalstorage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;

// /mnt/sdcard/
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		File dir = Environment.getExternalStorageDirectory();
		
		File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/.eoe/data/");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		
		File data = new File(dir, "data.txt");
		
		//read
		try {
			FileInputStream fis = new FileInputStream(data);
			byte[] bytes = new byte[fis.available()];
			fis.read(bytes);
			fis.close();
			
			System.out.println(new String(bytes,"utf-8"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
//		write		
//		if (!data.exists()) {
//			try {
//				data.createNewFile();
//				FileOutputStream fos = new FileOutputStream(data);
//				fos.write("Hello Android".getBytes("utf-8"));
//				fos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
