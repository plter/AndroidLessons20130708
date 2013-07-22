package cn.eoe.helloserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	
	
	private EditText etName;
	private TextView tvOut;
	
	private static final String SERVER_URL = "http://10.0.2.2:8080/L10_01HelloJee/hello.jsp";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvOut = (TextView) findViewById(R.id.tvOut);
		etName = (EditText) findViewById(R.id.etName);
		findViewById(R.id.connServer).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		if (TextUtils.isEmpty(etName.getText())) {
			Toast.makeText(this, "输入文本不能为空", Toast.LENGTH_SHORT).show();
			return;
		}
		
		final ProgressDialog pd = ProgressDialog.show(this, "正在通信", "正在连接服务器，请科稍候");
		
		new AsyncTask<Void, Void, String>() {

			@Override
			protected String doInBackground(Void... params) {
				try {
					InputStream is = new URL(String.format("%s?name=%s", SERVER_URL,etName.getText().toString())).openStream();
					
					BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
					String line = null;
					StringBuffer content = new StringBuffer();
					while((line=br.readLine())!=null){
						content.append(line);
					}
					is.close();
					return content.toString();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
			
			@Override
			protected void onPostExecute(String result) {
				pd.dismiss();
				
				if (result!=null) {
					tvOut.setText(result);
				}else{
					Toast.makeText(MainActivity.this, "通信失败", Toast.LENGTH_SHORT).show();
				}
				
				super.onPostExecute(result);
			}
		}.execute();
		
	}

}
