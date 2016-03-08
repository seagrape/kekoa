package com.sina.kekoa.demo3.jdbc;

import java.io.Serializable;

public class Student implements Serializable{

 
	private static final long serialVersionUID = -5984761936796047044L;
	
	private int id;
    private String name;
    private int age;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

    
}
