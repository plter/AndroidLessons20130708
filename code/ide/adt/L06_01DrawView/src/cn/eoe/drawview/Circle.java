package cn.eoe.drawview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Circle extends View {

	public Circle(Context context) {
		super(context);
	}
	
	private float x = 50;
	private float y = 0;
	private float speedY = 5;
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		
		Paint paint = new Paint();
		paint.setColor(0xffff0000);
		
		canvas.drawCircle(x, y, 20, paint );
		y+=speedY;
		
		invalidate();
		
		super.onDraw(canvas);
	}

}
