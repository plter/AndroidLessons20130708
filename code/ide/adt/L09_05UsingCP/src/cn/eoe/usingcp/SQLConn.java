package cn.eoe.usingcp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLConn extends SQLiteOpenHelper {


	public static final String TABLE_NAME = "user";
	public static final String COLMUN_NAME = "name";
	public static final String COLMUN_SEX = "sex";
	public static final String COLMUN_ID = "_id";


	public SQLConn(Context context) {
		super(context, "data", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE "+TABLE_NAME+"(" +
				COLMUN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
				COLMUN_NAME+" TEXT NOT NULL DEFAULT \"\"," +
				COLMUN_SEX+" TEXT NOT NULL DEFAULT \"\")");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		
	}

}
