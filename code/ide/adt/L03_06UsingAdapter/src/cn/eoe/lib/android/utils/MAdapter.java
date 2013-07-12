package cn.eoe.lib.android.utils;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class MAdapter<T> extends BaseAdapter {
	
	public MAdapter(Context context,int listCellResId) {
		this.context = context;
		this.listCellResId = listCellResId;
		
		items = new ArrayList<T>();
	}
	
	public void add(T obj){
		items.add(obj);
		notifyDataSetChanged();
	}
	

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public T getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView==null) {
			convertView = LayoutInflater.from(context).inflate(listCellResId, null);
		}
		
		initListCell(position, convertView, parent);
		
		return convertView;
	}
	
	public abstract void initListCell(int position, View listCell, ViewGroup parent);
	
	private Context context;
	private int listCellResId;
	private ArrayList<T> items;
}
