package cn.eoe.addnum;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) findViewById(R.id.tv);
	}
	
	
	@Override
	protected void onPause() {
		task.cancel(true);
		super.onPause();
	}
	
	
	@Override
	protected void onResume() {
		
		task = new AsyncTask<Void, Integer, Void>(){

			@Override
			protected Void doInBackground(Void... params) {
				
				int i = 0;
				
				while(true){
					i++;
					
					publishProgress(i);
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
						
						break;
					}
				}
				
				return null;
			}
			
			
			
			@Override
			protected void onCancelled() {
				// TODO Auto-generated method stub
				super.onCancelled();
			}
			
			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();
			}
			
			@Override
			protected void onPostExecute(Void result) {
				
				
				
				super.onPostExecute(result);
			}
			
			
			@Override
			protected void onProgressUpdate(Integer... values) {
				
				tv.setText(values[0]+"");
				
				super.onProgressUpdate(values);
			}
			
		};
		
		task.execute();
		
		super.onResume();
	}
	
	
	private AsyncTask<Void, Integer, Void> task;
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
