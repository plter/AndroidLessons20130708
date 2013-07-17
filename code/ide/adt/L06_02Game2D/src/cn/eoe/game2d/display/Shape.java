package cn.eoe.game2d.display;

import android.graphics.Canvas;

public abstract class Shape {
	
	
	
	/**
	 * 根据已设定好的属性对Canvas进行变换，之后执行绘图操作
	 * @param c
	 */
	void internal_draw(Canvas c){
		
		c.save();
		
		c.scale(scaleX, scaleY);
		c.rotate(rotation);
		c.translate(x, y);
		
		draw(c);
		
		c.restore();
		
	}
	
	
	public Stage getStage() {
		if (getParent()!=null) {
			return getParent().getStage();
		}else{
			if (this instanceof Stage) {
				return (Stage) this;
			}else{
				return null;
			}
		}
	}
	
	abstract protected void draw(Canvas c);
	
	
	private Container parent = null;
	private float x,y,scaleX=1,scaleY=1,rotation;

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

	public float getScaleX() {
		return scaleX;
	}

	public void setScaleX(float scaleX) {
		this.scaleX = scaleX;
	}

	public float getScaleY() {
		return scaleY;
	}

	public void setScaleY(float scaleY) {
		this.scaleY = scaleY;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public Container getParent() {
		return parent;
	}

	void setParent(Container parent) {
		this.parent = parent;
	}
}
