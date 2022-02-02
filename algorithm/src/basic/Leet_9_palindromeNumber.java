package basic;

public class Leet_9_palindromeNumber {
	public boolean isPalindrome(int x) {
		String strX = "" + x;
		int length = strX.length();
		for(int i = 0; i < length / 2; i++) {
			if(strX.charAt(i)  != strX.charAt(length - i -1)) {
				return false;
			}
		}
		return true;
	}
}
