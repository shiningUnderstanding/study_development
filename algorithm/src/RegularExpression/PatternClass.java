package RegularExpression;

import java.util.regex.Pattern;

public class PatternClass {
	//정규식 비교함수
	static void regExp(String regExp, String data) {
		boolean result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정규식: " +regExp +", 문자열: " + data + ", 정규식과 일치합니다.");
		}else{
			System.out.println("정규식: " +regExp +", 문자열: " + data + ", 정규식과 일치하지 않습니다.");
		}
	}
	
	public static void main(String[] args) {
		String regExp = "[a]";
		String data = "a";
		regExp(regExp, data);
		
		//010-xxxx-xxxx
		regExp = "(010)-\\d{4}-\\d{4}";
		data = "011-6232-9789";
		regExp(regExp, data);
		
		regExp = "010-2154-1542";
		data = "010-2154-1542";
		regExp(regExp, data);
		
		regExp = "[01021541542]";
		data = "010-2154-1542";
		regExp(regExp, data);
		
		//-----------------------------
		// abc
		regExp = "abc";
		data = "abc";
		regExp(regExp, data);
		
		data = "abc d";
		System.out.println(data.replaceAll(regExp, "s"));
		
		regExp = "abc";
		data = "abc d";
		regExp(regExp, data);
		
		// 123
		regExp = "123";
		data = "123";
		regExp(regExp, data);
		
		//^$
		regExp = "^a";
		data = "a";
		regExp(regExp, data);
		data = "acs";
		regExp(regExp, data);
		data = "bcaa";
		regExp(regExp, data);
		
		// \.
		regExp = "\\.";
		data = ".";
		regExp(regExp, data);
		
		// []
		regExp = "[abc][a-z]";
		data = "ac";
		regExp(regExp, data);
		data = "bs";
		regExp(regExp, data);
		data = "ab";
		regExp(regExp, data);
		data = "a^";
		regExp(regExp, data);
		
		// [^]
		regExp = "^[^abc]$";
		data = "d";
		regExp(regExp, data);
		data = "1";
		regExp(regExp, data);
		data = "ab";
		regExp(regExp, data);
		
		//String.matches .*
		if("ab".matches("[a].*")) {
			System.out.println(true);
		}
	}
}
