package cn.eoe.customanim;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ShakeAnim extends Animation {

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		
//		System.out.println(interpolatedTime+"<<<<<<<<<<<<<");
		
//		t.setAlpha(interpolatedTime);
		
		t.getMatrix().setTranslate((float) Math.sin(interpolatedTime*30)*10, (float) Math.sin(interpolatedTime*10)*10);
		
		super.applyTransformation(interpolatedTime, t);
	}
}
