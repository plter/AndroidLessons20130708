package cn.eoe.imglist.net;

public abstract class CBURLLoaderBinraySuccess implements CBURLLoaderSuccess<Object> {

	@Override
	public void onExcute(Object args) {
		onExcute((byte[])args);
	}

	public abstract void onExcute(byte[] bytes);
	
}
