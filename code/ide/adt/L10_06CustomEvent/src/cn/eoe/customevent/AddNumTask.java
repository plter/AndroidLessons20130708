package cn.eoe.customevent;

import android.os.AsyncTask;

public class AddNumTask extends AsyncTask<Void, Integer, Void> {

	@Override
	protected Void doInBackground(Void... params) {
		
		while(running){
			
			publishProgress(value);
			
			value++;
			
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
	protected void onProgressUpdate(Integer... values) {
		
		if (getOnNumberChangedListener()!=null) {
			getOnNumberChangedListener().onChange(values[0]);
		}
		
		super.onProgressUpdate(values);
	}

	public void stop(){
		running =false;
	}
	
	
	public OnNumberChangedListener getOnNumberChangedListener() {
		return onNumberChangedListener;
	}


	public void setOnNumberChangedListener(OnNumberChangedListener onNumberChangedListener) {
		this.onNumberChangedListener = onNumberChangedListener;
	}

	private int value = 0;
	private boolean running = true;
	private OnNumberChangedListener onNumberChangedListener=null;
}
