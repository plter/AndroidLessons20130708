import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class UsingMap {
	public static void main(String[] args) {
		
//		new ConcurrentHashMap<>()
		
//		HashMap<String, String> map = new HashMap<>();
//		map.put("h", "Hello");
//		map.put("w", "World");
//		
//		System.out.println(map.get("h"));
		
		
		HashSet<String> hs= new HashSet<>();
		hs.add("1");
		hs.add("2");
		hs.add("3");
		hs.add("4");
		hs.add("5");
		hs.add("6");
		
		Iterator<String> it = hs.iterator();
		String value;
		
		while(it.hasNext()){
			value = it.next();
			System.out.println(value);
		}
		
	}
}
