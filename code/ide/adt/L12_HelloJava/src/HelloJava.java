
public class HelloJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		People p = new People();
		p.age = 19;
		
		People p1 = p;
		p1.age = 20;
		
		
		System.out.println(p.age);
	}

}
