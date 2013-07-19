package cn.eoe.internalstorage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	
	private EditText etContent;
	private static final String FILE_NAME = "textData";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		etContent = (EditText) findViewById(R.id.etContent);
		
		findViewById(R.id.btnSave).setOnClickListener(this);
		
		readTextData();
	}
	
	
	private void readTextData(){
		try {
			InputStream is = openFileInput(FILE_NAME);
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			
			String str = new String(bytes,"utf-8");
			etContent.setText(str);
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void writeTextData(){
		try {
			OutputStream os = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
			
			os.write(etContent.getText().toString().getBytes("utf-8"));
			os.close();
			
			Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	@Override
//	protected void onResume() {
//		cn.eoe.internalstorage.Bundle.getInstance().setContext(this);
//		
//		super.onResume();
//	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		writeTextData();
		
	}

}
