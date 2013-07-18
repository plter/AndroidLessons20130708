package cn.eoe.cards;

import android.graphics.Color;
import android.graphics.RectF;

import com.plter.android.game2d.display.Sprite;
import com.plter.android.game2d.display.TextLine;

public class Card extends Sprite {

	public Card() {
		recto = new Sprite();
		recto.add(new Rect(100, 100, Color.RED));
		tl=new TextLine();
		recto.add(tl);
		tl.getPaint().setColor(Color.WHITE);
		tl.getPaint().setTextSize(36);
		tl.x = 20;
		tl.y = 30;
		
		verso = new Rect(100, 100, Color.BLUE);
		
		add(verso);
		add(recto);
		
		showRecto();
	}
	
	@Override
	public RectF getBounds() {
		return bounds;
	}
	
	private RectF bounds = new RectF(0, 0, 100, 100);
	
	
	public void showRecto(){
		recto.visible=true;
		verso.visible=false;
		rectoVisible = true;
	}
	
	public void showVerso(){
		recto.visible=false;
		verso.visible=true;
		rectoVisible = false;
	}
	
	public boolean isRectoVisible() {
		return rectoVisible;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
		tl.setText(num+"");
	}

	private int num = 0;
	private boolean rectoVisible = true;
	
	private TextLine tl;
	private Sprite recto;
	private Rect verso;
}
