package cn.eoe.cards;

import com.plter.android.game2d.display.GameView;
import com.plter.android.game2d.events.TouchEvent;
import com.plter.lib.java.event.EventListener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		v = new GameView(this);
		setContentView(v);
		
//		Card c = new Card();
//		c.setNum(5);
//		c.touchDown.add(new EventListener<TouchEvent>() {
//			
//			@Override
//			public boolean onReceive(Object target, TouchEvent event) {
//				
//				Card card = (Card) target;
//				if (card.isRectoVisible()) {
//					card.showVerso();
//				}else{
//					card.showRecto();
//				}
//				
//				return true;
//			}
//		});
//		
//		v.add(c);
		
		Card c;
		
		for (int i = 0; i < 5; i++) {
			c = new Card();
			c.setNum(i);
			v.add(c);
			
			c.y = 110*i;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	private GameView v;

}
