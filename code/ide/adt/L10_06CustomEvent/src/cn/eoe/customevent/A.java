package cn.eoe.customevent;

public class A {
	
	private A() {
	}

	
	public static A getInstance(){
		
		if (__instance==null) {
			__instance = new A();
		}
		
		return __instance;
	}
	
	private static A __instance = null;
}
