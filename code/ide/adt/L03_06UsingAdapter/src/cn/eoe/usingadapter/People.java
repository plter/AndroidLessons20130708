package cn.eoe.usingadapter;

public class People {

	public People(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	private String name;
	private int age;
}
