package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1929_findPrime {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		
		boolean[] eratos = new boolean[N + 1];
		eratos[0] = true;
		eratos[1] = true;
		for(int i = 2; i <= Math.sqrt(N); i++) {
			if(!eratos[i]) {
				for(int j = i * i; j <= N; j = j + i) {
					eratos[j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = M; i <= N; i++) {
			if(!eratos[i]) {
				sb.append(i).append('\n');
			}
		}
		
		System.out.println(sb);
	}
}
