package basic;

//private static을 사용 함으로써 클래스가 로드 된 후 static 메모리에 싱글턴 객체를 생성한다.
//생성자에 private이 붙어서 본인 클래스 외에서는 생성자를 호출 할 수 없고 추가로 만든
//싱글턴 객체를 사용하기 위해선 getInstance() 메서드를 사용해서 미리 생성해 놓은 객체를 사용 가능하다. 
class Single{
	int i;
	private static Single s = new Single();
	private Single() {
		i = 10;
	}
	
	public static Single getInstance() {
		return s;
	}
}


public class SingletonTest {
	public static void m1() {
		Single s1 = Single.getInstance();
		System.out.println("in main : s1 정보값 = " + s1);
		s1.i = 99;
	}
	
	public static void m2() {
		Single s1 = Single.getInstance();
		System.out.println("in main : s1 정보값 = " + s1);
		s1.i--;
	}
	
	public static void main(String[] args) {
		//new Single();
		Single s1 = Single.getInstance();
		System.out.println(s1.i);//10
		System.out.println("in main : s1 정보값 = " + s1);
		m1();
		System.out.println(s1.i);//99
		m2();
		System.out.println(s1.i);//98
	}
}
