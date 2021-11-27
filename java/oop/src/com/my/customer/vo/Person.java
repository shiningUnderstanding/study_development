package com.my.customer.vo;

public class Person {
	protected String name;
	protected String address;
	
	Person(){}
	Person(String name, String address){
		this.name = name;
		this.address = address;
	}
	
	public void printInfo() {
		System.out.println("이름 : " + name + ", 주소 : " + address);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
}
