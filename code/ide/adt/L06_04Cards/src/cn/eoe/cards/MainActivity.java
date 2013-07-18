package cn.eoe.cards;

import com.plter.android.game2d.display.GameView;
import com.plter.android.game2d.events.TouchEvent;
import com.plter.lib.java.event.EventListener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity implements EventListener<TouchEvent> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		v = new GameView(this);
		setContentView(v);
		
		Card c = new Card();
		c.setNum(5);
		c.setY(400);
		c.touchDown.add(this);
		v.add(c);
		
		c = new Card();
		c.setNum(6);
		c.setY(200);
		c.touchDown.add(this);
		v.add(c);
//		
//		v.add(c);
		
//		Card c;
//		
//		for (int i = 0; i < 5; i++) {
//			c = new Card();
//			c.setNum(i);
//			v.add(c);
//			
//			c.y = 110*i;
//		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	private GameView v;


	@Override
	public boolean onReceive(Object target, TouchEvent event) {
		Card card = (Card) target;
		if (card.isRectoVisible()) {
			card.showVerso();
		}else{
			card.showRecto();
		}
		return true;
	}

}
