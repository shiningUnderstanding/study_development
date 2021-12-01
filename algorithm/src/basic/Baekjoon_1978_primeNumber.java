package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1978_primeNumber {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] aristo = new boolean[1001];// init 0
		aristo[0] = true;
		aristo[1] = true;
		for(int i = 2; i <= Math.sqrt(1000); i++) {
			if(!aristo[i]) {
				for(int j = i * i; j < 1001; j += i) {
					aristo[j] = true;
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			int index = Integer.parseInt(st.nextToken());
			if(!aristo[index]) {
				count++;
			}
		}
		System.out.println(count);
	}
}
