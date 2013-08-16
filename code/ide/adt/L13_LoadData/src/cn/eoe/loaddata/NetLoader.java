package cn.eoe.loaddata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;

public class NetLoader extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... params) {
		String url = params[0];
		
		try {
			InputStream in = new URL(url).openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			StringBuffer content = new StringBuffer();
			
			String line = null;
			
			while((line=br.readLine())!=null){
				content.append(line);
			}
			
			in.close();
			
			return content.toString();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
