package cn.eoe.imglist;

import java.util.List;

import cn.eoe.imglist.net.CBListJsonDataLoadSuccess;
import cn.eoe.imglist.net.CBURLLoaderError;
import cn.eoe.imglist.net.CBURLLoaderTextSuccess;
import cn.eoe.imglist.net.ListJsonDataLoader;
import cn.eoe.imglist.net.URLLoader;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		adapter = new ImgListAdapter(this,R.layout.list_cell);
		setListAdapter(adapter);
		
		
		final ProgressDialog pd = ProgressDialog.show(this, "正在加载", "正在加载列表数据，请稍候");
		
		ListJsonDataLoader.load(Config.JSON_URL, new CBListJsonDataLoadSuccess() {
			
			@Override
			public void onExcute(List<ListCellData> args) {
//				System.out.println(args);
				
				adapter.addAll(args);
				
				pd.dismiss();
			}
		}, new CBURLLoaderError() {
			
			@Override
			public void onExcute(String args) {
				Toast.makeText(MainActivity.this, "连接失败 "+args, Toast.LENGTH_SHORT).show();
				pd.dismiss();
			}
		});
		
		
//		URLLoader.load(Config.JSON_URL, new CBURLLoaderTextSuccess() {
//			
//			@Override
//			public void onExcute(String args) {
//				System.out.println(args);
//				
//				
//				
//				pd.dismiss();
//			}
//		}, new CBURLLoaderError() {
//			
//			@Override
//			public void onExcute(String args) {
//				Toast.makeText(MainActivity.this, "连接失败 "+args, Toast.LENGTH_SHORT).show();
//				pd.dismiss();
//			}
//		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	private ArrayAdapter<ListCellData> adapter;

}
