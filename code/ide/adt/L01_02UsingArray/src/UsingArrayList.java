
import java.util.ArrayList;



public class UsingArrayList {

	public static void main(String[] args) {
		
		ArrayList<String> arr = new ArrayList<>();
		arr.add("Hello");
		arr.add("World");
		arr.add("eoe");
		
		for (int i = 0; i < arr.size(); i++) {
			if (i==1) {
				arr.add("Zhangdao");
			}
		}
		
//		for (String string : arr) {
//			if (string.equals("Hello")) {
//				arr.add("Zhangdao");
//			}
//		}
		
		System.out.println(arr);
		
		
//		arr.remove("World");
		
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i));
//		}
		
//		String s = "Hello";
//		String s1 = "He"+"llo";
//		String s1 = new String("Hello");
		
//		System.out.println(s.equals(s1));
	}
}
