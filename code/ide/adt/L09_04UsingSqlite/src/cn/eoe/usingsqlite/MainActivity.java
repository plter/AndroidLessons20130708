package cn.eoe.usingsqlite;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {
	
	
	private SQLConn sc;
	private SQLiteDatabase dbWrite,dbRead;
	private SimpleCursorAdapter sca;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		
		sc = new SQLConn(this);
		dbWrite = sc.getWritableDatabase();
		dbRead = sc.getReadableDatabase();
		
//		ContentValues cv;
//		
//		for (int i = 0; i < 10; i++) {
//			cv = new ContentValues();
//			cv.put(SQLConn.COLMUN_NAME, "用户 "+i);
//			cv.put(SQLConn.COLMUN_SEX, "女");
//			dbWrite.insert(SQLConn.TABLE_NAME, null, cv);
//		}
		
		
		/*
		 * 如果想查询得到所有结果，直接把所有的查询条件传值为null，
		 * 如果把 colmuns 数据指定为new String[]{SQLConn.COLMUN_NAME},说明
		 * 查询结果中只包括名称列
		 */
//		dbRead.query(SQLConn.TABLE_NAME,null , SQLConn.COLMUN_NAME+"=?", new String[]{"用户 1"}, groupBy, having, orderBy)
		Cursor c = dbRead.query(SQLConn.TABLE_NAME,null , null, null, null, null,null);
//		while(c.moveToNext()){
//			System.out.println(String.format("名字：%s,性别：%s", 
//					c.getString(c.getColumnIndex(SQLConn.COLMUN_NAME)),
//					c.getString(c.getColumnIndex(SQLConn.COLMUN_SEX))
//					)
//			);
//		}
		
		sca = new SimpleCursorAdapter(this, R.layout.list_cell, c, 
				new String[]{SQLConn.COLMUN_NAME,SQLConn.COLMUN_SEX}, 
				new int[]{R.id.tvName,R.id.tvSex});
		
		setListAdapter(sca);
		
		
		//如果需要在数据库中的发生变化后对列表进行刷新，则要调用changeCursor方法
//		sca.changeCursor(c);
	}
	
	@Override
	protected void onDestroy() {
		dbRead.close();
		dbWrite.close();
		super.onDestroy();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
