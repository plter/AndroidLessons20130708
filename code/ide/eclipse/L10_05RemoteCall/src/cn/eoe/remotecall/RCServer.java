package cn.eoe.remotecall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import cn.eoe.remotecall.pkg.RCMethodPackage;
import cn.eoe.remotecall.pkg.RCResultPackage;

public class RCServer {
	
	public void handle(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		PrintWriter pw = response.getWriter();
		
		try {
			InputStream is = request.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, charSet));
			String line=null;
			StringBuffer sb = new StringBuffer();
			while((line=br.readLine())!=null){
				sb.append(line);
			}
			is.close();
			br.close();
			
			RCMethodPackage methodPkg = new RCMethodPackage(sb.toString());
			String methodName = methodPkg.getMethodName();
			
			Method[] methods = getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					try {
						Object realResult = method.invoke(this, methodPkg.getArgs());
						
						pw.append(new RCResultPackage(realResult, RCResultCode.RESULT_OK).getJsonString());
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
						
						pw.append(new RCResultPackage(null, RCResultCode.ARGS_ERROR).getJsonString());
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					return;
				}
			}
			
			pw.append(new RCResultPackage(null, RCResultCode.NO_SUCH_METHOD,"No such method "+methodName).getJsonString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
			
			pw.append(new RCResultPackage(null, RCResultCode.CLIENT_PROTOCOL_ERROR).getJsonString());
		}
	}
	
	
	public String getCharSet() {
		return charSet;
	}
	
	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}
	
	private String charSet = "utf-8";
}
