package com.my.customer.vo;

//vo(value object) dto(data transfer object)
/**
* 고객객체용 클래스이다
* 고객정보(이름, ID, 비밀번호, 주소)
* @author Administrator
*
*/
public class Customer {
	public String id = new String();
	public String pwd = new String();
	public String name = new String();
	public String address = new String();
	
	public Customer(){}
	
	/**
	 * 고객정보를 초기화한다
	 * @param id 아이디
	 * @param pwd 비밀번호
	 * @param name 이름
	 * @param address 주소
	 */
	public Customer(String id, String pwd, String name, String address){
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
	}
	
	/**
	 * 고객정보를 출력한다
	 * 출력예시 아이디 : 1, 비밀번호 : 2, 이름 : 3, 주소 : 4 이다
	 */
	public void printInfo() {
		System.out.print("아이디 : " + id +", 비밀번호: " + pwd + ", 이름 : " + name + ", 주소 : " + address + " 이다.");
	}
	
	/**
	 * 현재고객의 아이디와 매개변수 고객객체의 아이디가 같으면 true반환
	 * 그 외의 경우는 false를 반환한다. 
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Customer) {
			Customer c = (Customer)obj;
			if(this.id.equals(c.id)) {
				return true;
			}
		}
		return false;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getPwd() {
		return pwd;
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