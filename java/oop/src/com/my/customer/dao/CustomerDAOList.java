package com.my.customer.dao;

import java.util.ArrayList;
import java.util.List;

import com.my.customer.exception.AddException;
import com.my.customer.exception.FindException;
import com.my.customer.exception.ModifyException;
import com.my.customer.exception.RemoveException;
import com.my.customer.vo.Customer;

/**
 * 고객객체를 저장소에 추가, 조회, 수정, 삭제하는 클래스이다.
 * 각 기능별 예외처리한다
 * 리스트 자료구조형태의 저장소를 사용한다
 * 리스트를 사용함으로써 이전 선언부로 사용하던 배열을 리스트로 바꾸었지만 이는 현업에서 좋은 방법이 아니다 결합도가 높아지기 때문
 * 그래서 인터페이스를 구현하여 결합도를 낮추었다.
 * @author Administrator
 * version - 3.0.0
 */
public class CustomerDAOList implements CustomerDAOInterface{
	private List<Customer> customers;//고객저장소

	public CustomerDAOList() {
		this.customers = new ArrayList<>(); //10개의 index 생성
	}
	
	public CustomerDAOList(int size) {
		this.customers = new ArrayList<>(size); //size 개수의 index 생성
	}
	
	/**
	 * 저장소에 고객정보추가
	 * @param customer 추가할 고객객체
	 * @throws AddException 
	 *     ID가 중복된 경우에는 "이미 존재하는 아이디입니다" 출력하고 저장 안한다.<br>
	 *     저장소가 꽉찬 경우에는 "저장소가 꽉찼습니다" 상세메세지를 갖는 예외가 발생한다.
	 */
	@Override
	public void add(Customer customer) throws AddException {
		//id중복확인
		for(Customer c : customers) {
			if(c.equals(customer)) {
				throw new AddException("이미 존재하는 아이디입니다.");
			}
		}
		//중복되지 않은 경우
		customers.add(customer);
	}
	
	@Override
	public List<Customer> findAll() throws FindException {
		return customers;
	}

	/**
	 * 아이디에 해당하는 고객을 저장소에서 찾아 반환한다
	 * @param id 아이디
	 * @return 고객객체
	 * @throws FindException 아이디에 해당 고객이 저장소에 없으면 "아이디에 해당하는 고객이 없습니다" 메세지를 발송한다
	 */
	@Override
	public Customer findById(String id) throws FindException {
		for(Customer c : customers) {
			if(c.getId().equals(id)) {
				return c;
			}
		}
		throw new FindException("아이디에 해당하는 고객이 없습니다");
	}

	/**
	 * 이름에 해당하는 고객들을 저장소에서 찾아 반환한다
	 * @param name 이름
	 * @return 고객객체배열
	 * @throws FindException 이름에 해당하는 고객이 저장소에 없으면 "단어를 포함한 이름의 고객은 없습니다" 메세지를 발송한다.
	 */
	@Override
	public List<Customer> findByName(String word) throws FindException {
		List<Customer> list = new ArrayList<>();
		for(Customer c : customers) {
			if(c.getName().contains(word)) {
				list.add(c);
			}
		}
		if(list.size() == 0) {
			throw new FindException("단어를 포함한 이름의 고객은 없습니다");
		}
		return list;
	}

	/**
	 * 아이디에 해당하는 고객정보(비밀번호, 이름, 주소)를 수정한다<br>
	 * 단, 기존내용과 같을 경우는 변경하지 않는다
	 * @param c 변경할 고객객체
	 * @throws ModifyException c고객객체의 아이디가 저장소에 없으면 예외 발생<br>
	 *                         기존내용과 같을 경우는 "고객정보가 변경되지 않았습니다" 메세지를 갖는 예외처리
	 */
	@Override
	public void modify(Customer c) throws ModifyException {
		try {
			Customer c1 = findById(c.getId());
			boolean flag = false;
			if(c1 != null) {
				if(!"".equals(c.getPwd())) {
					c1.setPwd(c.getPwd());
					flag = true;
				}else if(!"".equals(c.getName())) {
					c1.setName(c.getName());
					flag = true;
				}else if(!"".equals(c.getAddress())){
					c1.setAddress(c.getAddress());
					flag = true;
				}
			}
			if(!flag) {
				throw new ModifyException("고객정보가 변경되지 않았습니다");
			}
		} catch (FindException e) {
			throw new ModifyException(e.getMessage());
		}		
	}

	/**
	 * 아이디에 해당하는 고객객체를 삭제한다<br>
	 * @param id 삭제할 고객객체 id
	 * @throws RemoveException c고객객체의 아이디가 저장소에 없으면 예외 발생
	 */
	@Override
	public void remove(String id) throws RemoveException{
		for(Customer c : customers) {
			if(c.getId().equals(id)) {
				throw new RemoveException("삭제할 id가 없습니다.");
			}
		}
		customers.remove(new Customer(id,"","",""));
	}

	@Override
	public void printInfo() {
		System.out.println("저장된 고객수" + customers.size());
		
		for(Customer c : customers) {
			c.printInfo();
		}
		
	}

}
