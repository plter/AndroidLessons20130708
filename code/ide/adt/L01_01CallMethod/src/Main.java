import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {
	
	public static void main(String[] args) {
		
		new Main();
		
//		Main.sayHello();
		
//		People p = new People(0, "");
//		String s =People.WORD;
//		
//		People p;
		
//		System.out.println(People.initedPeople);
	}
	
	public static void sayHello(){
		System.out.println("Hello Java");
	}
	
	
	public Main() {
//		System.out.println(max(1,2,4,5,2));
		
		try {
			Method m = getClass().getMethod("sayHello1",String.class);
			m.invoke(this);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	
	public void sayHello1(String name){
		System.out.println("Hello "+name);
	}
	
	
	
	
	public int max(int ... args){
		
//		args[1]
		
		int maxValue = Integer.MIN_VALUE;
		
		for (int i = 0; i < args.length; i++) {
			maxValue = maxValue>args[i]?maxValue:args[i];
		}
		
		return maxValue;
	}
}
