package cn.eoe.imglist;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ImgListAdapter extends ArrayAdapter<ListCellData> implements CBIconBitmapLoaded {

	public ImgListAdapter(Context context, int listCellId) {
		super(context, listCellId);
	}

	@Override
	public void initListCell(int position, View listCell) {

		ListCellHolder listCellHolder;
		
		if (listCell.getTag()!=null) {
			listCellHolder = (ListCellHolder) listCell.getTag();
		}else{
			ListCellHolder holder = new ListCellHolder();
			holder.setIvIcon((ImageView) listCell.findViewById(R.id.ivIcon));
			holder.setTvLabel((TextView) listCell.findViewById(R.id.tvLabel));
			listCell.setTag(holder);
			
			listCellHolder = holder;
		}
		
		ListCellData data = getItem(position);
		if (data.getIconBitmap()!=null) {
			listCellHolder.getIvIcon().setImageBitmap(data.getIconBitmap());
		}else{
			listCellHolder.getIvIcon().setImageResource(R.drawable.ic_launcher);
			data.loadIconOnce(this);
		}
		listCellHolder.getTvLabel().setText(data.getLabel());
	}

	@Override
	public void onIconBitmapLoad() {
		notifyDataSetChanged();
	}

}
