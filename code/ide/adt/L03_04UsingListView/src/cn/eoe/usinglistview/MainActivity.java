package cn.eoe.usinglistview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adapter = new ArrayAdapter<PeopleListCellData>(this, android.R.layout.simple_list_item_1);
		adapter.add(new PeopleListCellData("Hello",18));
		adapter.add(new PeopleListCellData("eoe",19));
		
		lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	private ListView lv;
	private ArrayAdapter<PeopleListCellData> adapter = null;
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		PeopleListCellData data = adapter.getItem(position);
		
		Toast.makeText(this, "名字："+data.getName()+",年龄："+data.getAge(), Toast.LENGTH_SHORT).show();
		
	}

}
