package cn.eoe.loadwebdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;

/**
 * 对象型原型对应表
 * Void			void
 * Float 		float
 * Double 		double
 * Integer		int
 * Long			long
 * Short		short
 * Byte			byte
 * Character	char
 * Boolean		boolean
 */


public class LoadWebDataTask extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		
//		publishProgress(0.1f);
		
		String url = params[0];
		try {
			InputStream is = new URL(url).openStream();
			BufferedReader br= new BufferedReader(new InputStreamReader(is, "utf-8"));
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
	protected void onPreExecute() {
		super.onPreExecute();
	}
	
	@Override
	protected void onPostExecute(String result) {
		
		
		super.onPostExecute(result);
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
		super.onProgressUpdate(values);
	}
}
