package cn.eoe.balls;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Circle extends Shape {

	public Circle(float r,int color,float speedX,float speedY) {
		setR(r);
		setColor(color);
		this.speedX = speedX;
		this.speedY = speedY;
	}
	
	
	private float r = 10;
	
	@Override
	protected void draw(Canvas c) {
		c.drawCircle(0, 0, getR(), paint);
	}

	public float getR() {
		return r;
	}
	
	private int color = 0xffff0000;

	public void setR(float r) {
		this.r = r;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
		paint.setColor(color);
	}
	
	public void move(){
		setX(getX()+speedX);
		setY(getY()+speedY);
		
		if (getX()<getR()) {
			speedX = Math.abs(speedX);
		}
		if (getY()<getR()) {
			speedY = Math.abs(speedY);
		}
		if (getX()>getView().getWidth()-getR()) {
			speedX = -Math.abs(speedX);
		}
		if (getY()>getView().getHeight()-getR()) {
			speedY = -Math.abs(speedY);
		}
	}
	
	public boolean hitTest(Circle c){
		float distanceX = c.getX()-getX();
		float distanceY = c.getY()-getY();
		
		float distance = (float) Math.sqrt((distanceX*distanceX+distanceY*distanceY));
		return distance<c.getR()+getR();
	}
	
	private Paint paint = new Paint();
	
	
	private float speedX,speedY;
}
