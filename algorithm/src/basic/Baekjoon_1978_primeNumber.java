package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1978_primeNumber {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] eratos = new boolean[1001];// init 0
		eratos[0] = true;
		eratos[1] = true;
		for(int i = 2; i <= Math.sqrt(1000); i++) {
			if(!eratos[i]) {
				for(int j = i * i; j < 1001; j += i) {
					eratos[j] = true;
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			int index = Integer.parseInt(st.nextToken());
			if(!eratos[index]) {
				count++;
			}
		}
		System.out.println(count);
	}
}
