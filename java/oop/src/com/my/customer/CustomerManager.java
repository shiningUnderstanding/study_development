package com.my.customer;

import java.util.List;

import com.my.customer.dao.CustomerDAOInterface;
import com.my.customer.dao.CustomerDAOList;
import com.my.customer.exception.AddException;
import com.my.customer.exception.FindException;
import com.my.customer.exception.ModifyException;
import com.my.customer.exception.RemoveException;
import com.my.customer.vo.Customer;

public class CustomerManager {
	public static void main(String[] args) {
		CustomerDAOInterface dao;
		dao = new CustomerDAOList(); // 최대 5명이 저장될 저장소
		
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
				try {
					dao.add(c1);
				} catch (AddException e) {
					System.out.println("추가실패 : " + e.getMessage());
				}
			}else if(work.equals("2")) {
				System.out.println(">>저장소정보<<");
				dao.printInfo();
			}else if(work.equals("3")) {
				System.out.println(">>고객전체조회<<");
				List<Customer> all;
				try {
					all = dao.findAll();
					for(Customer c : all) {
						c.printInfo();
					}
				} catch (FindException e) {
					System.out.println("고객 전체조회 : " + e.getMessage());
				}
			}else if(work.equals("4")) {
				System.out.println(">>아이디로검색<<");
				System.out.println("아이디 : ");
				String id = sc.nextLine();
				Customer c;
				try {
					c = dao.findById(id);
					if(c == null) {
						System.out.println("id : " + id + "고객은 존재하지 않습니다");
					}else {
						c.printInfo();
					}
				} catch (FindException e) {
					System.out.println("고객조회 실패 : " + e.getMessage());
				}

			}else if(work.equals("5")) {
				System.out.println(">>이름으로검색<<");
				System.out.println("검색어 : ");
				String word = sc.nextLine();
				List<Customer> cList;
				try {
					cList = dao.findByName(word);
					if(cList == null) {
						System.out.println("단어 [ " + word + "]를 이름에 포함한 고객은 존재하지 않습니다");
					}else {
						for(Customer c2 : cList) {
							c2.printInfo();
						}
					}
				} catch (FindException e) {
					System.out.println(e.getMessage());
				}

			}else if(work.equals("6")) { //고객수정
				System.out.println(">>고객수정<<");
				System.out.println("아이디 : ");
				String id = sc.nextLine();
				Customer c;
				try {
					c = dao.findById(id);
					if(c == null) {
						System.out.println("id : " + id + "고객은 존재하지 않습니다");
					}else {
						c.printInfo();
						System.out.println("변경안하려면 enter를 입력하고, 변경하려면 값을 입력하시오");
						System.out.println("비밀번호[" + c.pwd + "]");
						String cPwd = sc.nextLine();
						//System.out.println("입력된 비번값:" + cPwd);
						System.out.println("이름[" + c.getName() + "]");
						String cName = sc.nextLine();
						System.out.println("주소[" + c.getAddress() + "]");
						String cAddress = sc.nextLine();
						Customer cModify = new Customer(id, cPwd, cName, cAddress);
						dao.modify(cModify);
					}
				} catch (FindException e) {
					System.out.println("고객조회실패 : " + e.getMessage());
				} catch (ModifyException e) {
					System.out.println("고객수정실패 : " + e.getMessage());
				}
			}else if(work.equals("7")) {
				System.out.println(">>삭제<<");
				System.out.println("삭제 할 아이디 : ");
				String id = sc.nextLine();
				Customer c;
				try {
					dao.remove(id);
				} catch (RemoveException e) {
					System.out.println("고객삭제실패 : " + e.getMessage());
				}

			}else if(work.equals("9")) {
				System.out.println(">>종료<<");
				System.exit(0);
			}
		}while(!work.equals("9"));
	}
}
