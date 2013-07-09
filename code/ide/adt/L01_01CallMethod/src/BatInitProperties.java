
public class BatInitProperties {

	public static void main(String[] args) {
		
		new BatInitProperties();
		
	}
	
	
	public BatInitProperties() {
		
		String[] strs = new String[]{"a","b","c","d","e","f"};
		
		for (int i = 0; i < strs.length; i++) {
			try {
				getClass().getField(strs[i]).set(this, i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(b);
		
	}
	
	
	public int a = 0;
	public int b = 0;
	public int c = 0;
	public int d = 0;
	public int e = 0;
	public int f = 0;
}
