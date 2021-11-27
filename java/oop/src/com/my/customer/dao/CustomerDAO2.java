package com.my.customer.dao;

import com.my.customer.exception.AddException;
import com.my.customer.exception.FindException;
import com.my.customer.exception.ModifyException;
import com.my.customer.exception.RemoveException;
import com.my.customer.vo.Customer;

/**
 * 고객객체를 저장소에 추가, 조회, 수정, 삭제하는 클래스이다.
 * 각 기능별 예외처리한다
 * @author Administrator
 * version - 2.0.0
 */
public class CustomerDAO2 {
	private Customer[] customers; //고객저장소
	private int count;
	
	public CustomerDAO2(){
		this.customers = new Customer[5];
	}
	
	public CustomerDAO2(int size) {
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
	public void add(Customer customer) throws AddException{
		try {
			//ID중복확인
			for(int i = 0; i < count; i++) {
				if(customers[i].equals(customer)) {
					throw new AddException("이미 존재하는 아이디입니다.");
				}
			}

			//중복되지 않은 경우
			customers[count] = customer;
			count++;
		}catch(ArrayIndexOutOfBoundsException e) {
			throw new AddException("저장공간을 초과하였습니다. 현재고객수 : " + count);
		}
	}
	
	public Customer[] findAll() {
		Customer[] all = new Customer[count];
		System.arraycopy(customers, 0, all, 0, count);
		return all;
	}
	
	/**
	 * 아이디에 해당하는 고객을 저장소에서 찾아 반환한다
	 * @param id 아이디
	 * @return 고객객체
	 * @throws FindException 아이디에 해당 고객이 저장소에 없으면 "아이디에 해당하는 고객이 없습니다" 메세지를 발송한다
	 */
	public Customer findById(String id) throws FindException{
		for(int i = 0; i < count; i++) {
			Customer c = customers[i];
			String cId = c.getId(); //저장된고객ID
			if(cId.equals(id)) {
				return c;
			}
		}
		throw new FindException("아이디에 해당하는 고객이 없습니다.");
	}
	
	/**
	 * 이름에 해당하는 고객들을 저장소에서 찾아 반환한다
	 * @param name 이름
	 * @return 고객객체배열
	 * @throws FindException 이름에 해당하는 고객이 저장소에 없으면 "단어를 포함한 이름의 고객은 없습니다" 메세지를 발송한다.
	 */
	public Customer[] findByName(String name) throws FindException{
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
			return cArr;
		}
		throw new FindException("단어를 포함한 이름의 고객이 없습니다.");
	}
	
	/**
	 * 아이디에 해당하는 고객정보(비밀번호, 이름, 주소)를 수정한다<br>
	 * 단, 기존내용과 같을 경우는 변경하지 않는다
	 * @param c 변경할 고객객체
	 * @throws ModifyException c고객객체의 아이디가 저장소에 없으면 예외 발생<br>
	 *                         기존내용과 같을 경우는 "고객정보가 변경되지 않았습니다" 메세지를 갖는 예외처리
	 */
	public void modify(Customer c) throws ModifyException{
		Customer c1;
		try {
			c1 = findById(c.getId());
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
			
			if(!flag) {
				throw new ModifyException("고객정보가 변경되지않았습니다");
			}
		} catch (FindException e) {
			throw new ModifyException(e.getMessage());
		}


	}
	
	/**
	 * 아이디에 해당하는 고객정보(아이디,비밀번호, 이름, 주소)를 삭제한다<br>
	 * @param c 변경할 고객객체
	 * @throws RemoveException c고객객체의 아이디가 저장소에 없으면 예외 발생<br>
	 *                         삭제가 되지 않았을 경우는 "고객정보가 삭제되지 않았습니다" 메세지를 갖는 예외처리
	 */
	public void delete(String id) throws RemoveException{
		for(int i = 0; i < count; i++) {
			if(customers[i].getId().equals(id) && i < count - 1) {
				customers[i] = customers[i + 1];
				count--;
				return;
			}else if(customers[i].getId().equals(id) && i == count - 1) {
				customers[i] = null;
				count--;
				return;
			}
		}
		throw new RemoveException("고객정보가 삭제되지 않았습니다");
	}
}
