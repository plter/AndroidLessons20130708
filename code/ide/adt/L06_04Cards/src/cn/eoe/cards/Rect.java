package cn.eoe.cards;

import android.graphics.Path.Direction;

import com.plter.android.game2d.display.Shape;

public class Rect extends Shape {

	public Rect(float width,float height,int color) {
		getPaint().setColor(color);
		getPath().addRect(0, 0, width, height, Direction.CW);
	}
	
}
