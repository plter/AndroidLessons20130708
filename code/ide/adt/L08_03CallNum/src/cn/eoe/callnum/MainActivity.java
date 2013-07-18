package cn.eoe.callnum;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	
	
	private EditText etNum;
	private TelephonyManager tm;
	private static final String TAG = "TEL";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		
		etNum = (EditText) findViewById(R.id.etNum);
		
		findViewById(R.id.btnCall).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
//		Intent i = new Intent(Intent.ACTION_VIEW);
//		i.setData(Uri.parse("tel:"+etNum.getText().toString()));
//		startActivity(i);
		
		try {
			Method getITelephonyMehtod = TelephonyManager.class.getDeclaredMethod("getITelephony");
			getITelephonyMehtod.setAccessible(true);
			Object _ITelephony = getITelephonyMehtod.invoke(tm);
			
			Method callMethod = _ITelephony.getClass().getMethod("call", String.class);
			callMethod.invoke(_ITelephony, "5556");
			
			
//			Method[] methods = _ITelephony.getClass().getMethods();
//			for (Method method : methods) {
//				if (method.getName().equals("call")) {
//					Class<?>[] types = method.getParameterTypes();
//					for (Class<?> class1 : types) {
//						Log.i(TAG, class1+"");
//					}
//					
//					break;
//				}
//			}
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
