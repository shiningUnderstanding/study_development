package com.my.customer;

/**
 * 고객객체용 클래스이다
 * 고객정보(이름, ID, 비밀번호, 주소)
 * @author Administrator
 *
 */
class Customer{
	String id = new String();
	String pwd = new String();
	String name = new String();
	String address = new String();
	
	Customer(){}
	/**
	 * 고객정보를 초기화한다
	 * @param id 아이디
	 * @param pwd 비밀번호
	 * @param name 이름
	 * @param address 주소
	 */
	Customer(String id, String pwd, String name, String address){
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
	}
	
	/**
	 * 고객정보를 출력한다
	 * 출력예시 아이디 : 1, 비밀번호 : 2, 이름 : 3, 주소 : 4 이다
	 */
	void printInfo() {
		System.out.println("아이디 : " + id +", 비밀번호: " + pwd + ", 이름 : " + name + ", 주소 : " + address);
	}
}

/**
 * 고객객체를 저장소에 추가, 조회, 수정, 삭제하는 클래스이다.
 * @author Administrator
 *
 */
class CustomerDAO{
	Customer[] customers; //고객저장소
	int count;
	
	CustomerDAO(){
		this.customers = new Customer[5];
	}
	
	CustomerDAO(int size) {
		this.customers = new Customer[size];
	}
	
	void printInfo() {
		System.out.println("고객저장소의 크기" + customers.length);
		System.out.println("저장된 고객수" + count);
		
		for(int i = 0; i < count; i++) {
			Customer c = customers[i];
			System.out.print("[" + i + "]");
			c.printInfo();
		}
	}
	
//	void add(Customer c) {
//		for(int i = 0; i < customers.length; i++) {
//			if(customers[i] == null) {
//				customers[i] = c;
//				return;
//			}
//		}
//	}
	/**
	 * 고객정보추가
	 * @param customer
	 */
	void add(Customer customer) {
		if(count >= customers.length) {
			System.out.println("저장공간을 초과하였습니다.");
			return;
		}
		customers[count] = customer;
		count++;
		System.out.println("고객추가 성공");
	}
	
	Customer[] findAll() {
		Customer[] all = new Customer[count];
//		for(int i = 0; i < count; i++) {
//			all[i] = customers[i];
//		}
		System.arraycopy(customers, 0, all, 0, count);
		return all;
	}
	
//	void findById(String id) {
//		for(int i = 0; i < count; i++) {
//			if(customers[i].id.equals(id)) {
//				customers[i].printInfo();
//				return;
//			}
//		}
//		System.out.println("id : " + id + "고객은 존재하지 않습니다");
//	}
	
	Customer findById(String id) {
		for(int i = 0; i < count; i++) {
			Customer c = customers[i];
			String cId = c.id; //저장된고객ID
			if(cId.equals(id)) {
				return c;
			}
		}
		//System.out.println("id : " + id + "고객은 존재하지 않습니다");
		return null;
	}
	
	Customer[] findByName(String name) {
//		int wordCnt = 0; //단어를 포함한 고객수
//		for(int i = 0; i < count; i++) {
//			Customer c = customers[i];
//			String cName = c.name;
//			if(cName.contains(name)) { // if(cName.contains(word) == true){}
//				wordCnt++;
//			}
//		}
		
		Customer[] cArr1 = new Customer[count];
		int cArrIndex = 0;
		for(int i = 0; i < count; i++) {
			Customer c = customers[i];
			String cName = c.name;
			if(cName.contains(name)) { // if(cName.contains(word) == true){}
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
	
	void modify(Customer c) {
//		for(int i = 0; i < count; i++) {
//			Customer c = customers[i];
//			String cId = c.id; //저장된고객ID
//			if(cId.equals(id)) {
//				c.pwd = pwd;
//				c.name = name;
//				c.address = address;	
//			}
//		}
		Customer c1 = findById(c.id);
		boolean flag = false;
		if(c1 != null) {
			if(!"".equals(c.pwd)) {
				c1.pwd = c.pwd;
				flag = true;
			}
			if(!"".equals(c.name)) {
				c1.name = c.name;
				flag = true;
			}
			if(!"".equals(c.address)) {
				c1.address =c.address;
				flag = true;
			}
		}
		
		if(flag) {
			System.out.println("고객정보가 변경되었습니다");
		}else {
			System.out.println("고객정보가 변경되지않았습니다");
		}
	}
	
	void delete(String id) {
		//아이디를 찾아 삭제하고 나머지 배열을 할칸씩 당기기
		//count--;
		for(int i = 0; i < count; i++) {
			if(customers[i].id.equals(id) && i < count - 1) {
				customers[i] = customers[i + 1];
				count--;
			}else if(customers[i].id.equals(id) && i == count - 1) {
				customers[i] = null;
				count--;
			}
		}
		
	}
}

public class CustomerManager {
	public static void main(String[] args) {
		CustomerDAO dao;
		dao = new CustomerDAO(); // 최대 5명이 저장될 저장소
		
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);
		String work;
		do {
			System.out.println("작업구분 : 1 - 고객추가, 2 - 저장소정보, 3 - 고객전체조회, 4 - 아이디로 검색, 5 - 이름으로 검색 9 - 종료");
			work = sc.nextLine();
			
			if(work.equals("1")) {
				System.out.println(">>고객 추가<<");
				
				System.out.println("아이디 : ");
				String id = sc.nextLine();
				System.out.println("비밀번호 : ");
				String pwd = sc.nextLine();
				System.out.println("이름 : ");
				String name = sc.nextLine();
				System.out.println("주소 : ");
				String address = sc.nextLine();
				
				Customer c1 = new Customer(id, pwd, name, address);
				dao.add(c1);
			}else if(work.equals("2")) {
				System.out.println(">>저장소정보<<");
				dao.printInfo();
			}else if(work.equals("3")) {
				System.out.println(">>고객전체조회<<");
				Customer[] all = dao.findAll();
				for(Customer c : all) {
					c.printInfo();
				}
			}else if(work.equals("4")) {
				System.out.println(">>아이디로검색<<");
				System.out.println("아이디 : ");
				String id = sc.nextLine();
				Customer c = dao.findById(id);
				if(c == null) {
					System.out.println("id : " + id + "고객은 존재하지 않습니다");
				}else {
					c.printInfo();
				}
			}else if(work.equals("5")) {
				System.out.println(">>이름으로검색<<");
				System.out.println("검색어 : ");
				String word = sc.nextLine();
				Customer[] cArr = dao.findByName(word);
				if(cArr == null) {
					System.out.println("단어 [ " + word + "]를 이름에 포함한 고객은 존재하지 않습니다");
				}else {
					for(Customer c2 : cArr) {
						c2.printInfo();
					}
				}
			}else if(work.equals("6")) { //고객수정
				System.out.println(">>고객수정<<");
				System.out.println("아이디 : ");
				String id = sc.nextLine();
				Customer c = dao.findById(id);
				if(c == null) {
					System.out.println("id : " + id + "고객은 존재하지 않습니다");
				}else {
					c.printInfo();
					System.out.println("변경안하려면 enter를 입력하고, 변경하려면 값을 입력하시오");
					System.out.println("비밀번호[" + c.pwd + "]");
					String cPwd = sc.nextLine();
					//System.out.println("입력된 비번값:" + cPwd);
					System.out.println("이름[" + c.name + "]");
					String cName = sc.nextLine();
					System.out.println("주소[" + c.address + "]");
					String cAddress = sc.nextLine();
					Customer cModify = new Customer(id, cPwd, cName, cAddress);
					dao.modify(cModify);
				}
			}else if(work.equals("7")) {
				System.out.println(">>삭제<<");
				System.out.println("삭제 할 아이디 : ");
				String id = sc.nextLine();
				Customer c = dao.findById(id);
				if(c == null) {
					System.out.println("id : " + id + "고객은 존재하지 않습니다");
				}else {
					dao.delete(id);
					System.out.println("id : " + id + "삭제가 완료되었습니다.");
				}
			}else if(work.equals("9")) {
				System.out.println(">>종료<<");
				System.exit(0);
			}
		}while(!work.equals("9"));

//		dao.printInfo();
		
//		Customer c1 = new Customer("id1", "p1", "n1", "a1");
//		dao.add(c1); //고객저장소의 0번 index에 c1객체참조시킨다.
//		
//		Customer c2 = new Customer("id2", "p2", "n2", "a2");
//		dao.add(c2);
//		Customer c3 = new Customer("id3", "p3", "n3", "a3");
//		dao.add(c3);
		
		
//		dao.printInfo();
		
//		dao = new CustomerDAO(10); // 최대 10명이 저장될 저장소
//		dao.printInfo();
	}
}
