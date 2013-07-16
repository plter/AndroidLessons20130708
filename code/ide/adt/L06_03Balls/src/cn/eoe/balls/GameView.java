package cn.eoe.balls;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback {

	public GameView(Context context) {
		super(context);
		
		Circle c;
		
		for (int i = 0; i < 20; i++) {
			c = new Circle(20, Color.argb(255, (int)(256*Math.random()), (int)(256*Math.random()), (int)(256*Math.random())), (float)(5*Math.random()+1), (float)(5*Math.random()+1));
			c.setView(this);
			circles.add(c);
		}
		
		getHolder().addCallback(this);
	}
	
	
	public void draw(){
		Canvas c = getHolder().lockCanvas();
		
		if (c!=null) {
			
			c.drawColor(Color.WHITE);
			
			for (Circle circle : circles) {
				circle.internal_draw(c);
				circle.move();
			}
			
			getHolder().unlockCanvasAndPost(c);
		}
	}
	
	private Circle circle;
	private ArrayList<Circle> circles = new ArrayList<Circle>();
	

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		timer = new Timer();
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
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		timer.cancel();
		task.cancel();
	}
	
	private Timer timer;
	private TimerTask task;

}
