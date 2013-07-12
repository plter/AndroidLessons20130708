package cn.eoe;

import java.util.ArrayList;

public class CustomClass<Student> {
	
	
	public void addStudent(Student s){
		arr.add(s);
	}
	
	public Student getStudent(int index){
		return arr.get(index);
	}
	
	private ArrayList<Student> arr = new ArrayList<Student>();
}
