package cn.eoe.usingcp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyCP extends ContentProvider {
	
	
	public static final Uri URI = Uri.parse("content://com.eoe.usingcp.MyCP");
	
	private SQLConn conn;
	private SQLiteDatabase dbRead,dbWrite;
	

	@Override
	public boolean onCreate() {
		conn = new SQLConn(getContext());
		dbRead = conn.getReadableDatabase();
		dbWrite = conn.getWritableDatabase();
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		System.out.println(uri);
		
		return dbRead.query(SQLConn.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		dbWrite.insert(SQLConn.TABLE_NAME, null, values);
		return uri;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return dbWrite.delete(SQLConn.TABLE_NAME, selection, selectionArgs);
	}	

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		return dbWrite.update(SQLConn.TABLE_NAME, values, selection, selectionArgs);
	}

}
