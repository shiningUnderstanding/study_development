package basic;

public class HR {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.setNo("210001"); //사번이 210001
		e1.setName("이현규"); //사원명은 이현규
		e1.setSalary(500);//급여는 500
		e1.printInfo();//사번은 210001, 사원명은 이현규, 급여는 500
		
		Employee e2 = new Employee();
		e2.setNo("210002");
		e2.setName("송다현");
		e2.setSalary(600);
		e2.printInfo();
	}

}
