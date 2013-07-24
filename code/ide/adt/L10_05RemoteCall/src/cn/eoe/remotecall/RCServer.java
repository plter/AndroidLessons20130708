package cn.eoe.remotecall;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.eoe.remotecall.pkg.RCMethodPackage;
import cn.eoe.remotecall.pkg.RCResultPackage;

import android.os.AsyncTask;

public class RCServer {

	public RCServer(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}

	public String getCharSet() {
		return charSet;
	}


	/**
	 * 
	 * @param methodName
	 * @param args
	 * @return 此次远程通信的id
	 */
	public int call(String methodName,Object... args){
		return call(new RCMethodPackage(methodName, args).getPackage());
	}

	public int call(JSONObject jo){

		RCTask task = new RCTask(url, jo.toString(), charSet){
			@Override
			protected void onPostExecute(JSONObject result) {
				onServerResult(result, getId());
				super.onPostExecute(result);
			}
		};

		task.execute();
		return task.getId();
	}


	private void onServerResult(JSONObject result,int taskId){
		RCResultPackage pkg = new RCResultPackage(result);
		onResult(pkg.getResult(), pkg.getResultCode(), taskId);

		if (getOnRCServerResultListener()!=null) {
			getOnRCServerResultListener().onResult(pkg.getResult(), pkg.getResultCode(), taskId);
		}
	}

	protected void onResult(Object result,int resultCode,int taskId){
	}


	public void setOnRCServerResultListener(
			OnRCServerResultListener onRCServerResultListener) {
		this.onRCServerResultListener = onRCServerResultListener;
	}

	public OnRCServerResultListener getOnRCServerResultListener() {
		return onRCServerResultListener;
	}

	private OnRCServerResultListener onRCServerResultListener = null;
	private String url = null,charSet="utf-8";


	private static class RCTask extends AsyncTask<Void, Void, JSONObject>{

		private static final HttpClient httpClient = new DefaultHttpClient();
		private static int __id = 1;

		public RCTask(String url,String json,String charSet) {
			this.url=url;
			this.json=json;
			this.charSet = charSet;

			id = __id;
			__id++;
		}

		public int getId() {
			return id;
		}

		private String url=null,json=null,charSet = "utf-8";
		private int id = 0;


		@Override
		protected JSONObject doInBackground(Void... params) {

			HttpPost hp = new HttpPost(url);

			/*
			 * UnsupportedEncodingException
			 * ClientProtocolException
			 * IOException
			 * JSONException
			 */

			try {
				hp.setEntity(new StringEntity(json,charSet));
				String jsonResultStr = EntityUtils.toString(httpClient.execute(hp).getEntity());
				return new JSONObject(jsonResultStr);
			} catch (Exception e) {
				RCResultPackage result;
				if (e instanceof UnsupportedEncodingException) {
					result = new RCResultPackage(null, RCResultCode.CLIENT_UNSUPPORTED_ENCODING_ERROR);
				}else if (e instanceof ClientProtocolException) {
					result = new RCResultPackage(null, RCResultCode.CLIENT_PROTOCOL_ERROR);
				}else if (e instanceof IOException) {
					result = new RCResultPackage(null, RCResultCode.IO_ERROR);
				}else if (e instanceof JSONException) {
					result = new RCResultPackage(null, RCResultCode.INVALID_SERVER_RESULT);
				}else{
					result = new RCResultPackage(null, RCResultCode.UNKNOWN_ERROR);
				}
				return result.getPackage();
			}
		}

	}
}
