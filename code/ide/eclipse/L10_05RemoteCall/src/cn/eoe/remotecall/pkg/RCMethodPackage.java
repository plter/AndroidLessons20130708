package cn.eoe.remotecall.pkg;

import org.json.JSONArray;
import org.json.JSONException;

public class RCMethodPackage extends RCPackage {

	public RCMethodPackage(String jsonString) throws JSONException {
		super(jsonString);
	}
	
	public RCMethodPackage(String methodName,Object... args) {
		put("methodName", methodName);
		
		
		JSONArray jsonArgs = new JSONArray();
		for (int i = 0; i < args.length; i++) {
			jsonArgs.put(args[i]);
		}
		put("args", jsonArgs);
	}
	
	public String getMethodName(){
		return getString("methodName");
	}
	
	public Object[] getArgs(){
		JSONArray jsonArr = getArray("args");
		Object[] args = null;
		if (jsonArr!=null) {
			args = new Object[jsonArr.length()];
			for (int i = 0; i < args.length; i++) {
				try {
					args[i] = jsonArr.get(i);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}else{
			args = new Object[0];
		}
		return args;
	}
}
