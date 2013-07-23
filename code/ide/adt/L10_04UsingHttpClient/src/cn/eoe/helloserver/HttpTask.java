package cn.eoe.helloserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;

public class HttpTask extends AsyncTask<Void, Void, String> {

	public HttpTask(String name,int httpMethod) {
		this.name = name;
		this.httpMethod = httpMethod;
	}


	@Override
	protected String doInBackground(Void... params) {
		HttpResponse hr;
		try {
			switch (httpMethod) {
			case HttpMethod.POST:
				HttpPost hp = new HttpPost(SERVER_URL);

				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				pairs.add(new BasicNameValuePair("name", name));
				hp.setEntity(new UrlEncodedFormEntity(pairs));
				hr=httpClient.execute(hp);
				break;
			default:
				HttpGet hg = new HttpGet(String.format("%s?name=%s", SERVER_URL,name));
				hr=httpClient.execute(hg);
				break;
			}
			
			InputStream is = hr.getEntity().getContent();
			
			BufferedReader br= new BufferedReader(new InputStreamReader(is, "utf-8"));
			String line = null;
			StringBuffer sb = new StringBuffer();
			while((line=br.readLine())!=null)
				sb.append(line);
			
			is.close();
			return sb.toString();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String name;
	private int httpMethod = HttpMethod.GET; 
	private static final String SERVER_URL = "http://10.0.2.2:8080/L10_01HelloJee/hello.jsp";
	private static final HttpClient httpClient = new DefaultHttpClient();
}
