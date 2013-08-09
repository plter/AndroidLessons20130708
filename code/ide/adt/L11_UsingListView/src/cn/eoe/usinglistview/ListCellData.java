package cn.eoe.usinglistview;

public class ListCellData {
	public ListCellData(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	
	public int getAge() {
		return age;
	}
	
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	
	private String name;
	private int age;
}
