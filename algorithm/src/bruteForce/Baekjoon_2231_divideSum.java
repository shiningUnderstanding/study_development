package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baekjoon_2231_divideSum {
	static int M = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		divideSum(N);
		System.out.println(M);
	}
	
	static void divideSum(int N) {
		//숫자를 문자로
		int sum = 0;
		for(int i = 2; i <= N; i++) {
			String strN = "" + i;
			for(int j = 0; j < strN.length(); j++) {
				sum += (int)strN.charAt(j) - '0';
			}
			sum += i;
			if(sum == N) {
				M = i;
				return;
			}
			sum = 0;
		}
	}
}
