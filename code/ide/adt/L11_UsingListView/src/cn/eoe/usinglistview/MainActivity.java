package cn.eoe.usinglistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	
//	private ArrayAdapter<ListCellData> adapter;
	
	private ListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		adapter = new ListAdapter(this);
		
//		adapter = new ArrayAdapter<ListCellData>(this, android.R.layout.simple_list_item_1);
		setListAdapter(adapter);
		
		adapter.add(new ListCellData("Zhangdao", 10));
		adapter.add(new ListCellData("LiShaoqing", 11));
		adapter.add(new ListCellData("Pengyi", 12));
		adapter.add(new ListCellData("Zhangdao", 10));
		adapter.add(new ListCellData("LiShaoqing", 11));
		adapter.add(new ListCellData("Pengyi", 12));
		adapter.add(new ListCellData("Zhangdao", 10));
		adapter.add(new ListCellData("LiShaoqing", 11));
		adapter.add(new ListCellData("Pengyi", 12));
		adapter.add(new ListCellData("Zhangdao", 10));
		adapter.add(new ListCellData("LiShaoqing", 11));
		adapter.add(new ListCellData("Pengyi", 12));
		
//		adapter.add("Hello");
//		adapter.add("eoe");
		
		
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
//		Toast.makeText(this, adapter.getItem(position).getAge()+"", Toast.LENGTH_SHORT).show();
		
		adapter.remove(position);
		
		super.onListItemClick(l, v, position, id);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
