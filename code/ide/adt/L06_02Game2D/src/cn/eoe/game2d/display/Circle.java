package cn.eoe.game2d.display;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circle extends Shape {
	
	
	public Circle() {
		paint.setColor(Color.RED);
	}
	

	private Paint paint=new Paint();

	@Override
	protected void draw(Canvas c) {
		c.drawCircle(0, 0, 20, paint);
	}
	

}
