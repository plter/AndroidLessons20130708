package cn.eoe.usingcp;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
//		setContentView(R.layout.activity_main);
		
//		for (int i = 0; i < 10; i++) {
//			ContentValues cv = new ContentValues();
//			cv.put(SQLConn.COLMUN_NAME, "张道 "+i);
//			cv.put(SQLConn.COLMUN_SEX, "女");
//			
//			getContentResolver().insert(MyCP.URI, cv);
//		}
		
		Cursor c = getContentResolver().query(Uri.parse("content://com.eoe.usingcp.MyCP/user"), null, null, null, null);
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_cell, c, new String[]{SQLConn.COLMUN_NAME,SQLConn.COLMUN_SEX}, new int[]{R.id.tvName,R.id.tvSex});
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
