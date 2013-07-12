package cn.eoe.usingadapter;

import cn.eoe.lib.android.utils.MAdapter;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends ListActivity {
	
	
	private MAdapter<People> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		adapter = new MAdapter<People>(this,R.layout.list_cell) {
			
			@Override
			public void initListCell(int position, View listCell, ViewGroup parent) {
				
				TextView tvName = (TextView) listCell.findViewById(R.id.tvName);
				TextView tvAge = (TextView) listCell.findViewById(R.id.tvAge);
				
				People p = getItem(position);
				tvName.setText("name:"+p.getName());
				tvAge.setText("Age:"+p.getAge());
			}
		};
		
		
		adapter.add(new People("小华", 18));
		adapter.add(new People("小明", 20));
		
		setListAdapter(adapter);
	}

}
