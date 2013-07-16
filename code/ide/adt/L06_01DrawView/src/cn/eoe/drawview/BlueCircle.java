package cn.eoe.drawview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class BlueCircle extends SurfaceView implements Callback {

	public BlueCircle(Context context) {
		super(context);
		
		getHolder().addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		
		Canvas c = getHolder().lockCanvas();
		
		c.drawColor(Color.WHITE);
		
		Paint paint = new Paint();
		paint.setColor(0xff0000ff);
		c.drawCircle(200, 200, 200, paint);
		
		getHolder().unlockCanvasAndPost(c);
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
