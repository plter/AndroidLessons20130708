package cn.eoe.imglist;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class ListCellData {

	public ListCellData(String label,String iconUrl) {
		this.iconUrl = iconUrl;
		this.label = label;
	}
	
	
	public String getIconUrl() {
		return iconUrl;
	}
	
	public String getLabel() {
		return label;
	}
	
	
	public void loadIconOnce(final CBIconBitmapLoaded cb){
		if (!iconLoaded) {
			
			new AsyncTask<Void, Void, InputStream>() {

				@Override
				protected InputStream doInBackground(Void... params) {
					
					try {
						return new URL(getIconUrl()).openStream();
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					return null;
				}
				
				@Override
				protected void onPostExecute(InputStream result) {
					
					if (result!=null) {
						iconBitmap = BitmapFactory.decodeStream(result);
						cb.onIconBitmapLoad();
					}
					
					super.onPostExecute(result);
				}
			}.execute();
			
//			URLLoader.load(getIconUrl(), new CBURLLoaderBinraySuccess() {
//				
//				@Override
//				public void onExcute(byte[] bytes) {
//					
//					iconBitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//					
//					cb.onIconBitmapLoad();
//				}
//			}, null);
			
			iconLoaded = true;
		}
	}
	
	public Bitmap getIconBitmap() {
		return iconBitmap;
	}
	
	private Bitmap iconBitmap = null;
	private boolean iconLoaded = false;
	
	private String label,iconUrl;
}
