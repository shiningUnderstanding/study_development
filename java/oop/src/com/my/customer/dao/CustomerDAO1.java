package com.my.customer.dao;

import com.my.customer.vo.Customer;

/**
 * 고객객체를 저장소에 추가, 조회, 수정, 삭제하는 클래스이다.
 * @author Administrator
 * version - 1.0.0
 */
public class CustomerDAO1 {
	private Customer[] customers; //고객저장소
	private int count;
	
	public CustomerDAO1(){
		this.customers = new Customer[5];
	}
	
	public CustomerDAO1(int size) {
		this.customers = new Customer[size];
	}
	
	public void printInfo() {
		System.out.println("고객저장소의 크기" + customers.length);
		System.out.println("저장된 고객수" + count);
		
		for(int i = 0; i < count; i++) {
			Customer c = customers[i];
			System.out.print("[" + i + "]");
			c.printInfo();
		}
	}
	

	/**
	 * 저장소에 고객정보추가
	 * 단, ID가 중복된 경우에는 "이미 존재하는 아이디입니다" 출력하고 저장 안한다.
	 * @param customer 고객객체
	 */
	public void add(Customer customer) {
		if(count >= customers.length) {
			System.out.println("저장공간을 초과하였습니다.");
			return;
		}else {
			//ID중복확인
			for(int i = 0; i < count; i++) {
				if(customers[i].equals(customer)) {
					System.out.println("이미존재하는 아이디입니다.");
					return;
				}
			}

			customers[count] = customer;
			count++;
			System.out.println("고객추가 성공");
		}
	}
	
	public Customer[] findAll() {
		Customer[] all = new Customer[count];
		System.arraycopy(customers, 0, all, 0, count);
		return all;
	}
	
	
	public Customer findById(String id) {
		for(int i = 0; i < count; i++) {
			Customer c = customers[i];
			String cId = c.getId(); //저장된고객ID
			if(cId.equals(id)) {
				return c;
			}
		}
		return null;
	}
	
	public Customer[] findByName(String name) {
		Customer[] cArr1 = new Customer[count];
		int cArrIndex = 0;
		for(int i = 0; i < count; i++) {
			Customer c = customers[i];
			String cName = c.getName();
			if(cName.contains(name)) { 
				cArr1[cArrIndex] = c;
				cArrIndex++;
			}
		}
		Customer []cArr = null;
		if(cArrIndex > 0) {
			cArr = new Customer[cArrIndex];
			System.arraycopy(cArr1, 0, cArr, 0, cArrIndex);
		}
		return cArr;
	}
	
	public void modify(Customer c) {
		Customer c1 = findById(c.getId());
		boolean flag = false;
		if(c1 != null) {
			if(!"".equals(c.getPwd())) {
				c1.setPwd(c.getPwd());
				flag = true;
			}
			if(!"".equals(c.getName())) {
				c1.setName(c.getName());
				flag = true;
			}
			if(!"".equals(c.getAddress())) {
				c1.setAddress(c.getAddress());
				flag = true;
			}
		}
		
		if(flag) {
			System.out.println("고객정보가 변경되었습니다");
		}else {
			System.out.println("고객정보가 변경되지않았습니다");
		}
	}
	
	public void delete(String id) {
		for(int i = 0; i < count; i++) {
			if(customers[i].getId().equals(id) && i < count - 1) {
				customers[i] = customers[i + 1];
				count--;
			}else if(customers[i].getId().equals(id) && i == count - 1) {
				customers[i] = null;
				count--;
			}
		}
		
	}

}