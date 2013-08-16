package cn.eoe.usingas;

import android.os.AsyncTask;

public class TimerTask extends AsyncTask<Void, Integer, Void> {

	@Override
	protected Void doInBackground(Void... params) {
		
		int i = 0;
		
		while(running){
			
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
	
	
	private boolean running = false;
	
	
	public boolean isRunning() {
		return running;
	}
	
	public void stop(){
		running= false;
	}
	
	
	@Override
	protected void onPreExecute() {
		running = true;
		super.onPreExecute();
	}
	
//	@Override
//	protected void onPostExecute(Void result) {
//		// TODO Auto-generated method stub
//		super.onPostExecute(result);
//	}
//	
//	@Override
//	protected void onCancelled() {
//		// TODO Auto-generated method stub
//		super.onCancelled();
//	}
//	
//	@Override
//	protected void onProgressUpdate(Integer... values) {
//		
//		super.onProgressUpdate(values);
//	}

}
