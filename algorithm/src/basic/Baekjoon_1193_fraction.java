package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1193_fraction {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		//1 3 6 10 15
		// n(n+1)/2 < X
		// n + 1 < 2 * X / n
		
		int n = 1;
		int numerator = 1; //분자
		int denominator = 1;//분모
		StringBuilder sb = new StringBuilder();
		
		if(X == 1) {
			sb.append(numerator).append("/").append(denominator);
			System.out.println(sb.toString());
			return;
		}
		while( (double)n* (n+1) / 2 < X) {
			n++;
		}
		if(n % 2 == 0) {
			numerator = X - (n * (n - 1) / 2);
			denominator = n - numerator + 1;
		}else {
			denominator = X - (n * (n - 1) / 2);
			numerator = n - denominator + 1;
		}

		sb.append(numerator).append("/").append(denominator);
		System.out.println(sb.toString());
	}

}
