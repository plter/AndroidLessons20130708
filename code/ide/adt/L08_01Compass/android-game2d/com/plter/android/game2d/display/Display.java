package com.plter.android.game2d.display;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

import com.plter.android.game2d.events.TouchEvent;
import com.plter.lib.java.event.EventListenerList;

public abstract class Display{
	
	void internal_draw(Canvas canvas){
		canvas.save();
		canvas.translate(x-regX, y-regY);
		canvas.rotate(rotation,regX,regY);
		canvas.scale(scaleX, scaleY,regX,regY);
		draw(canvas);
		canvas.restore();
	}
	
	
	public Stage getRoot(){
		if (this instanceof Stage) {
			return (Stage) this;
		}
		return parent!=null?parent.getRoot():null;
	}
	
	
	public float getGlobalX(){
		if (getParent()!=null) {
			return x+getParent().getGlobalX();
		}
		return 0;
	}
	
	public float getGlobalY(){
		if (getParent()!=null) {
			return y+getParent().getGlobalY();
		}
		return 0;
	}
	
	public abstract void draw(Canvas canvas);
	
	public Container getParent() {
		return parent;
	}


	void internal_setParent(Container parent) {
		this.parent = parent;
	}
	
	void internal_dispatchTouchEvent(TouchEvent e){
		
		if (TouchEvent.TOUCH_MOVE.equals(e.getType())) {
			touchMove.dispatch(this, e.clone());
		}else if (TouchEvent.TOUCH_DOWN.equals(e.getType())) {
			touchDown.dispatch(this, e.clone());
		}else if (TouchEvent.TOUCH_UP.equals(e.getType())) {
			touchUp.dispatch(this, e.clone());
		}
		
		touch.dispatch(this, e);
	}
	
	public boolean hitTest(float x, float y) {
		return getBounds().contains(x, y);
	}

	public boolean hitTest(float left, float top, float right, float bottom) {
		return getBounds().intersect(left, top, right, bottom);
	}
	
	public boolean hitTest(PointF p) {
		return hitTest(p.x, p.y);
	}
	
	public boolean hitTest(RectF rect) {
		return hitTest(rect.left, rect.top, rect.right, rect.bottom);
	}

	public boolean hitTest(Display display) {
		return hitTest(display.getBounds());
	}
	
	public Matrix getBoundsMatrix() {
		boundsMatrix.reset();
		boundsMatrix.preTranslate(x-regX, y-regY);
		boundsMatrix.preRotate(rotation,regX,regY);
		boundsMatrix.preScale(scaleX, scaleY,regX,regY);
		return boundsMatrix;
	}
	
	private final Matrix boundsMatrix = new Matrix();
	public abstract RectF getBounds();
	public GameView getGameView() {
		Stage r = getRoot();
		return r!=null?r.getGameView():null;
	}
	
	public Context getContext(){
		return getGameView()!=null?getGameView().getContext():null;
	}

	public boolean isTouchEnable() {
		return touchEnable;
	}

	public void setTouchEnable(boolean touchEnable) {
		this.touchEnable = touchEnable;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public float x=0,y=0,scaleX=1,scaleY=1,rotation=0,regX=0,regY=0;
	public boolean visible=true;
	private Container parent=null;
	private boolean touchEnable=true;
	private float alpha=1;
	
	public final EventListenerList<TouchEvent> touch = new EventListenerList<TouchEvent>();
	public final EventListenerList<TouchEvent> touchMove = new EventListenerList<TouchEvent>();
	public final EventListenerList<TouchEvent> touchDown = new EventListenerList<TouchEvent>();
	public final EventListenerList<TouchEvent> touchUp = new EventListenerList<TouchEvent>();
}
