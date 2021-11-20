package basic;

class B{
	int iv; //인스턴스 변수, non-static 변수 --멤버필드
	static int sv; //클래스변수, static 변수 --멤버필드
	
	void im() { //인스턴스 메서드
		sm(); //ok
		System.out.println(iv); //this.iv
		System.out.println(sv); //this.sv
	}
	
	static void sm() { //static method
		//im(); // 에러 static 안에서는 this역시 사용 불가
	}
}

/**
 * static변수 : 클래스로드후 자동초기화된다
 *             사용법 - 객체참조변수.static변수
 *                     클래스로드후 자동초기화된다
 *                     사용법 - 객체참조변수.static변수
 * static메서드 : 객체와 무관한 기능제공
 *               사용법 - 객체 참조변수.static메서드();
 *                       클래스명.static메서드();
 *               static메서드 내부에서는 this사용못함, 인스턴스 메서드, 인스턴스변수 사용못함
 *    ex) Math.random();
 * @author Administrator
 *
 */

public class StaticTest {
	public static void main(String[] args) {
		B b1 = new B();
		b1.iv = 5;
		b1.sv = 10;
		B.sv = 20; // static 변수는 클래스 이름으로 직접 조작하는 게 좋다.
		           // static method 역시 클래스 이름으로 직접 조작
		B b2 = new B();
		System.out.println(b1.iv);
		System.out.println(b2.iv);//0
		
		System.out.println(b1.sv);
		System.out.println(b2.sv); //20
		System.out.println(B.sv); //20
		
		b1.sv++;
		System.out.println(B.sv); //21
		System.out.println(b2.sv); //21
		
		b1.im();
		b1.sm();
		//B.im();
		B.sm();
	}
}
