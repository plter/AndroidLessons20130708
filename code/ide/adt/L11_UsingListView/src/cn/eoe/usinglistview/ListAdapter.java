package cn.eoe.usinglistview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
	
	public ListAdapter(Context context) {
		this.context = context;
	}
	
	public void add(ListCellData data){
		dataList.add(data);
		
		notifyDataSetChanged();
	}
	
	
	public void remove(int position){
		dataList.remove(position);
		
		notifyDataSetChanged();
	}
	
	

	@Override
	public int getCount() {
		return dataList.size();
	}

	@Override
	public ListCellData getItem(int position) {
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView==null) {
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_cell, null);
		}
		
		TextView tvName = (TextView) convertView.findViewById(R.id.tvName),
				tvAge = (TextView) convertView.findViewById(R.id.tvAge);
		
		ListCellData data = getItem(position);
		tvName.setText("Name:"+data.getName());
		tvAge.setText("Age:"+data.getAge());
		
		return convertView;
	}
	
	
	public Context getContext() {
		return context;
	}
	
	
	private Context context;
	private List<ListCellData> dataList = new ArrayList<ListCellData>();

}
