package cn.eoe.game2d.display;

import java.util.ArrayList;

import android.graphics.Canvas;

public class Container extends Shape {
	
	
	
	/**
	 * 重写Shape的internal_draw方法，在对Canvas变换之后调用所有子对象的internl_draw方法对子对象进行绘制
	 */
	@Override
	void internal_draw(Canvas c) {
		
		c.save();
		
		c.scale(getScaleX(), getScaleY());
		c.rotate(getRotation());
		c.translate(getX(), getY());
		
		for (int i = 0; i < children.size(); i++) {
			children.get(i).internal_draw(c);
		}
		
		c.restore();
	}
	
	public void addChild(Shape s){
		children.add(s);
		s.setParent(this);
	}
	
	public void removeChild(Shape s){
		children.remove(s);
		s.setParent(null);
	}
	
	
	private ArrayList<Shape> children = new ArrayList<Shape>();
	

	@Override
	protected final void draw(Canvas c) {
	}

}
