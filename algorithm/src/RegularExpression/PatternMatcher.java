package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
	public static void main(String[] args) {
		String[] data = {"a","ab", "abc"};
		
		Pattern p = Pattern.compile("[a].+");
		
		for(String s: data) {
			Matcher m = p.matcher(s);
			if(m.matches()) {
				System.out.println(s);
			}
		}
				
	}
}
