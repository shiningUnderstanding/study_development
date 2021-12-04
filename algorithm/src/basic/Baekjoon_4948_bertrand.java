package basic;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_4948_bertrand {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		boolean[] eratos = new boolean[246913];
		eratos[0] = true;
		eratos[1] = true;
		for(int i = 2; i < Math.sqrt(246913); i++) {
			if(!eratos[i]) {
				for(int j = i * i; j < 246913; j += i) {
					eratos[j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while((n = Integer.parseInt(br.readLine())) != 0) {
			for(int i = n + 1; i <= 2 * n; i++) {
				if(!eratos[i]) {
					count++;
				}
			}
			sb.append(count).append("\n");
			count = 0;
		}
		System.out.println(sb);
	}
}
