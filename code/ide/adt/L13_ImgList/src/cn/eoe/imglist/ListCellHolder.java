package cn.eoe.imglist;

import android.widget.ImageView;
import android.widget.TextView;

public class ListCellHolder {

	
	
	private ImageView ivIcon;
	public ImageView getIvIcon() {
		return ivIcon;
	}
	public void setIvIcon(ImageView ivIcon) {
		this.ivIcon = ivIcon;
	}
	public TextView getTvLabel() {
		return tvLabel;
	}
	public void setTvLabel(TextView tvLabel) {
		this.tvLabel = tvLabel;
	}
	private TextView tvLabel;
}
