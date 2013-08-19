package cn.eoe.imglist.net;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.eoe.imglist.Config;
import cn.eoe.imglist.ListCellData;

public class ListJsonDataLoader {

	public static void load(final String url,final CBListJsonDataLoadSuccess suc,final CBURLLoaderError fail){
		URLLoader.load(url, new CBURLLoaderTextSuccess() {
			
			@Override
			public void onExcute(String args) {
				try {
					JSONArray result = new JSONArray(args);
					List<ListCellData> list = new ArrayList<ListCellData>();
					JSONObject jo ;
					
					for (int i = 0; i < result.length(); i++) {
						jo = result.getJSONObject(i);
						list.add(new ListCellData(jo.getString("title"), Config.BASE_URL+jo.getString("icon")));
					}
					
					suc.onExcute(list);
				} catch (JSONException e) {
					e.printStackTrace();
					
					if (fail!=null) {
						fail.onExcute(url);
					}
				}
			}
		}, fail);
	}
}
