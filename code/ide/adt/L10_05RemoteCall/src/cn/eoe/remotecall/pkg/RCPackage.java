package cn.eoe.remotecall.pkg;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RCPackage {
	
	public RCPackage() {
		_package = new JSONObject();
	}
	
	public RCPackage(JSONObject json){
		_package = json;
	}
	
	public RCPackage(String jsonString) throws JSONException{
		_package = new JSONObject(jsonString);
	}
	
	public String getString(String key){
		try {
			return getPackage().getString(key);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Object getObject(String key){
		try {
			return getPackage().get(key);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getInt(String key){
		try {
			return getPackage().getInt(key);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public JSONArray getArray(String key){
		try {
			return getPackage().getJSONArray(key);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void put(String key,Object value){
		try {
			getPackage().put(key, value);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void put(String key,String value){
		try {
			getPackage().put(key, value);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	
	public void put(String key,JSONArray value){
		try {
			getPackage().put(key, value);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	
	public void put(String key,int value){
		try {
			getPackage().put(key, value);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public String getJsonString(){
		return getPackage().toString();
	}
	
	public JSONObject getPackage(){
		return _package;
	}
	
	private JSONObject _package;
}
