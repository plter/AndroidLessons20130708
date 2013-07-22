package cn.eoe.loadwebdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.btnLoadData).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		
		final ProgressDialog pd = ProgressDialog.show(this, "加载中", "正在加载数据，请稍候");
		
		new LoadWebDataTask(){
			protected void onPostExecute(String result) {
				
				pd.dismiss();
				
				if (result!=null) {
					new AlertDialog.Builder(MainActivity.this).setTitle("通信成功").setMessage(result).setPositiveButton("OK", null).show();
				}else{
					Toast.makeText(MainActivity.this, "通信失败", Toast.LENGTH_SHORT).show();
				}
			};
		}.execute("http://www.adobe.com");
		
		
		
//		try {
////			URLConnection uc = new URL("http://10.0.2.2:8080/L10_01HelloJee/index.jsp").openConnection();
//			URLConnection uc = new URL("http://www.adobe.com").openConnection();
//			InputStream is = uc.getInputStream();
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
//			String line = null;
////			String content="";
//			StringBuffer sb = new StringBuffer();
//			while((line=br.readLine())!=null){
////				content+=line;
//				sb.append(line);
//			}
//			
//			System.out.println(sb.toString());
//			
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
	}

}
