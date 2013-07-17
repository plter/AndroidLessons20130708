package cn.eoe.game2d;

import cn.eoe.game2d.display.Circle;
import cn.eoe.game2d.display.Container;
import cn.eoe.game2d.display.GameView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {
	
	
	private GameView gv;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		gv = new GameView(this);
		setContentView(gv);
		
		Container container = new Container();
		container.setX(100);
		container.setY(200);
		
		Circle c = new Circle();
		container.addChild(c);
		
		gv.getStage().addChild(container);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
