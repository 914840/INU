package model;


public class Person {
	private String age;
	private String firstName;
	private String lastName;
	
	public Person(String age, String firstName, String lastName){
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getAge(){
		return age;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setAge(String age){
		this.age = age;
	}
	
	public void setFirstName(String name){
		this.firstName = name;
	}
	
	public void setLastName(String name){
		this.lastName = name;
	}
}
