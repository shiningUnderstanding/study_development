package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2581_PrimeBetween {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = 0;
		StringBuilder sb = new StringBuilder();
		
		//에라토스테네스의 체
		boolean[] eratos = new boolean[10001];
		eratos[0] = true;
		eratos[1] = true;
		for(int i = 2; i < Math.sqrt(10001);i++) {
			if(!eratos[i]) {
				for(int j = i * i; j < 10001; j += i) {
					eratos[j] = true;
				}
			}
		}
		
		for(int i = M; i <= N; i++) {
			if(!eratos[i]) {
				sum += i;
				if(min == 0) {
					min = i;
				}
			}
		}
		
		if(sum == 0) {
			sb.append("-1");
		}else {
			sb.append(sum).append("\n").append(min);
		}
		
		System.out.println(sb);
	}
}
