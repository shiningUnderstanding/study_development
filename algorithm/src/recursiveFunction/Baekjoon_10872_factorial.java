package recursiveFunction;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_10872_factorial {
	public static int factorial(int n) {
		if(n == 1 || n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(factorial(n));
	}
}
