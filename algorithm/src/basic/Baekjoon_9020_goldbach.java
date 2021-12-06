package basic;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_9020_goldbach {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		//eratos
		boolean[] eratos = new boolean[10001];
		eratos[0] = true;
		eratos[1] = true;
		for(int i = 2; i < Math.sqrt(10001); i++) {
			if(!eratos[i]) {
				for(int j = i * i; j < 10001; j += i) {
					eratos[j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int a = n / 2;
			int b = n / 2;
			//둘다 소수이면 즉 eratos[a], eratos[b] 둘다 false이면 멈춘다.
			while(eratos[a] || eratos[b]) {
				a--;
				b++;
			}
			sb.append(a).append(' ').append(b).append('\n');
		}
		System.out.println(sb);
	}
}
