package cn.eoe.darwapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback {

//	public GameView(Context context, AttributeSet attrs, int defStyle) {
//		super(context, attrs, defStyle);
//		// TODO Auto-generated constructor stub
//	}
//
//	public GameView(Context context, AttributeSet attrs) {
//		super(context, attrs);
//		// TODO Auto-generated constructor stub
//	}

	public GameView(Context context) {
		super(context);
		
		getHolder().addCallback(this);
	}
	
	
	public void draw(){
		
		Paint p=new Paint();
		p.setColor(Color.RED);
		
		Canvas canvas = getHolder().lockCanvas();
		
		canvas.drawColor(Color.WHITE);
		
		canvas.save();
		canvas.translate(100, 100);
		canvas.drawRect(new Rect(0,0 , 100, 100), p);
		canvas.restore();
		
		p.setColor(Color.BLUE);
		canvas.drawCircle(0, 0, 100, p);
		
		
		getHolder().unlockCanvasAndPost(canvas);
	}
	

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		draw();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
