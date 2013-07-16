package cn.eoe.balls;

import android.graphics.Canvas;

public abstract class Shape {
	
	
	void internal_draw(Canvas c){
		c.save();
		c.translate(getX(), getY());
		draw(c);
		c.restore();
	}
	
	abstract protected void draw(Canvas c);

	private float x,y;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public GameView getView() {
		return view;
	}

	public void setView(GameView view) {
		this.view = view;
	}

	private GameView view;
}
