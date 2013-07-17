package cn.eoe.game2d.display;

import java.util.Timer;
import java.util.TimerTask;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback {

//	public GameView(Context context, AttributeSet attrs, int defStyle) {
//		super(context, attrs, defStyle);
//		// TODO Auto-generated constructor stub
//	}

//	public GameView(Context context, AttributeSet attrs) {
//		super(context, attrs);
//		// TODO Auto-generated constructor stub
//	}

	public GameView(Context context) {
		super(context);
		
		getHolder().addCallback(this);
		
		Stage.__locked = false;
		stage = new Stage();
		Stage.__locked = true;
	}
	
	
	public void draw(){
		Canvas c = getHolder().lockCanvas();
		c.drawColor(Color.WHITE);
		
		stage.internal_draw(c);
		
		getHolder().unlockCanvasAndPost(c);
	}
	
	public Stage getStage(){
		return stage;
	}
	
	private Stage stage;
	

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		timer  = new Timer();
		task = new TimerTask() {
			
			@Override
			public void run() {
				draw();
			}
		};
		timer.schedule(task, 20, 20);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		timer.cancel();
		task.cancel();
	}
	
	private Timer timer;
	private TimerTask task;

}
