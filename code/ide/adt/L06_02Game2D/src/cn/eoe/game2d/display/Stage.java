package cn.eoe.game2d.display;

public class Stage extends Container {

	public Stage() {
		
		if (__locked) {
			throw new RuntimeException("该类不允许被外部实例化");
		}
	}
	
	static boolean __locked = true;
}
