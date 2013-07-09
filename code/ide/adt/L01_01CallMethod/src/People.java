import java.util.ArrayList;


public class People {

	
	public People(int age,String name) {
		setAge(age);
		setName(name);
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	private int age;
	private String name;
	
	public static final String WORD="Hello";
	
	public static final ArrayList<People> initedPeople = new ArrayList<>();
	
	static{
		System.out.println("Static code block in people");
		
		initedPeople.add(new People(20, "小明"));
		initedPeople.add(new People(21, "小明"));
		initedPeople.add(new People(22, "小明"));
	}
	
}
