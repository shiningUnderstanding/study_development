package basic;

/**
 * 사원정보클래스이다
 * @Administrator
 * @version 1.0
 */
public class Employee {
	/**
	 * 사번
	 */
	String no;
	String name;
	int salary;
	
	/**
	 * 사원의 사번을 설정한다
	 * @param n
	 */
	
	void setNo(String no) {
		this.no = no;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 사원의 급여를 설정한다
	 * @param s
	 */
	void setSalary(int salary) {
		this.salary = salary;
	}
	
	void printInfo() {
		System.out.println("사번은 " + no);
		System.out.println("사원명은 " + name);
		System.out.println("급여는 " + salary);
	}
}
