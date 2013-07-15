package cn.eoe.translate3d;

import android.graphics.Camera;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Translate3D extends Animation {
	
	
	private Camera camera;
	private int width,height;
	
	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight) {
		camera = new Camera();
		
		this.width = width;
		this.height=height;
		super.initialize(width, height, parentWidth, parentHeight);
	}
	

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		
		camera.save();
		
		camera.rotateY(interpolatedTime*180);
		
		camera.getMatrix(t.getMatrix());
		
		t.getMatrix().preTranslate(-width/2, -height/2);
		t.getMatrix().postTranslate(width/2, height/2);
		
		camera.restore();
		
		super.applyTransformation(interpolatedTime, t);
	}
	
}
