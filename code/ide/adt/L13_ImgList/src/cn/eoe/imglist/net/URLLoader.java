package cn.eoe.imglist.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class URLLoader extends AsyncTask<Void, Void, Object>{
	
	
	private static String charSet = "utf-8";
	
	public static void setCharSet(String charSet) {
		URLLoader.charSet = charSet;
	}
	
	public static String getCharSet() {
		return charSet;
	}

	public static void load(String url,final CBURLLoaderBinraySuccess suc,final CBURLLoaderError fail){
		new URLLoader(url,suc,fail).execute();
	}
	
	public static void load(final String url,final CBURLLoaderTextSuccess suc,final CBURLLoaderError fail){
		new URLLoader(url,new CBURLLoaderBinraySuccess() {
			
			@Override
			public void onExcute(byte[] bytes) {
				if (suc!=null) {
					try {
						suc.onExcute(new String(bytes,getCharSet()));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
						
						fail.onExcute(url);
					}
				}
			}
		},fail).execute();
	}
	
	
	public URLLoader(String url,CBURLLoaderBinraySuccess suc,CBURLLoaderError fail) {
		this.url = url;
		this.suc = suc;
		this.fail = fail;
	}
	
	private String url;
	private CBURLLoaderBinraySuccess suc=null;
	private CBURLLoaderError fail=null;
	

	@Override
	protected Object doInBackground(Void... params) {
		
		try {
			HttpResponse hr = httpClient.execute(new HttpGet(url));
			InputStream in = hr.getEntity().getContent();
			
			byte[] bytes = new byte[1024];
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int len = -1;
			while((len=in.read(bytes))>-1){
				bos.write(bytes, 0, len);
			}
			in.close();
			byte[] outBytes = bos.toByteArray();
			bos.close();
			return outBytes;
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	protected void onPostExecute(Object result) {
		
		if (result!=null) {
			if (suc!=null) {
				suc.onExcute(result);
			}
		}else{
			if (fail!=null) {
				fail.onExcute(url);
			}
		}
		
		super.onPostExecute(result);
	}
	
	
	private static final HttpClient httpClient = new DefaultHttpClient();
}
