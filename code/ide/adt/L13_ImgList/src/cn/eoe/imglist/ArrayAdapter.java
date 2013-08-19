package cn.eoe.imglist;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class ArrayAdapter<T> extends BaseAdapter {
	
	
	public ArrayAdapter(Context context,int listCellId) {
		this.context = context;
		this.listCellId = listCellId;
	}
	
	
	public void addAll(List<T> data){
		list.addAll(data);
		
		notifyDataSetChanged();
	}
	

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public T getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView==null) {
			convertView = LayoutInflater.from(getContext()).inflate(listCellId, null);
		}
		
		initListCell(position, convertView);
		
		return convertView;
	}
	
	
	public abstract void initListCell(int position,View listCell);
	
	public Context getContext() {
		return context;
	}
	
	private Context context;
	private int listCellId = 0;
	private final List<T> list = new ArrayList<T>();

}
