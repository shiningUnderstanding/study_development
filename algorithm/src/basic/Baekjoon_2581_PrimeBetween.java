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
		
		//아리스토테네스의 체
		boolean[] aristo = new boolean[10001];
		aristo[0] = true;
		aristo[1] = true;
		for(int i = 2; i < Math.sqrt(10001);i++) {
			if(!aristo[i]) {
				for(int j = i * i; j < 10001; j += i) {
					aristo[j] = true;
				}
			}
		}
		
		for(int i = M; i <= N; i++) {
			if(!aristo[i]) {
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
