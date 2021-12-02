package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11653_factorization {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(N > 1) {
			for(int i = 2; i <= N; i++) {
				if(N % i == 0) {
					N = N / i;
					sb.append(i).append("\n");
					break;
				}
				
			}
		}
		System.out.println(sb);
	}
}
