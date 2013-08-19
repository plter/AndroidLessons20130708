import java.util.ArrayList;
import java.util.HashMap;



public class Main {

	public static void main(String[] args) {
		
//		HashMap<K, V>
//		ConcurrentHashMap<K, V>
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Hello");
		arr.add("World");
		
		ArrayList<String> pengingAdd = new ArrayList<>();
		
		HashMap<Integer, String> pendingMap= new HashMap<>();
		
//		pengingAdd.add("Pengyi");
		
		for (String string : arr) {
			if (string.equals("Hello")) {
//				arr.add("Pengyi");
				pengingAdd.add("Pengyi");
			}
		}
		arr.addAll(0, pengingAdd);
		
//		a();
		
//		new Main();
	}
	
	public Main() {
		
		
	}
	
	

	private static void a() {
		String a = "Hello";
		String b = "World";
		a = a+b;
		
		/*
		 * %d	int long
		 * %f	float double
		 * %x	16进制
		 * %o	8进制
		 * %c	字符
		 * %s	字符串
		 */
		
		System.out.println(String.format("Hello %d", 1));
		
		long d = 100;
		
		System.out.println(String.format("Long %d", d));
	}
}
