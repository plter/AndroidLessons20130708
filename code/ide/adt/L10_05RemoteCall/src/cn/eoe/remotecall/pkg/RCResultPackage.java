package cn.eoe.remotecall.pkg;

import org.json.JSONException;
import org.json.JSONObject;


public class RCResultPackage extends RCPackage{

	
	public RCResultPackage(JSONObject json){
		super(json);
	}
	
	public RCResultPackage(Object result,int resultCode) {
		put("result", result);
		put("resultCode", resultCode);
	}
	
	public RCResultPackage(Object result,int resultCode,String errorMsg) {
		this(result,resultCode);
		put("errorMsg", errorMsg);
	}
	
	public RCResultPackage(String jsonString) throws JSONException{
		super(jsonString);
	}
	
	
	public String getErrorMsg(){
		return getString("errorMsg");
	}
	
	
	public Object getResult() {
		return getObject("result");
	}
	
	public int getResultCode() {
		return getInt("resultCode");
	}
}
