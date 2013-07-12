package cn.eoe.usinglistactivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	
	private ArrayAdapter<CellData> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"a","b","c"});
		adapter = new ArrayAdapter<CellData>(this, android.R.layout.simple_list_item_multiple_choice){
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				CheckedTextView ctv = (CheckedTextView) super.getView(position, convertView, parent);
				CellData data = getItem(position);
				ctv.setChecked(data.isChecked());
				return ctv;
			}
		};
		
		
		for (int i = 0; i < 30; i++) {
			adapter.add(new CellData("Item "+i));
		}
		
		setListAdapter(adapter);
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
//		CheckedTextView ctv = (CheckedTextView) v;
//		ctv.setChecked(!ctv.isChecked());
		
		CellData data = adapter.getItem(position);
		data.setChecked(!data.isChecked());
		adapter.notifyDataSetChanged();
		
		
		super.onListItemClick(l, v, position, id);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
