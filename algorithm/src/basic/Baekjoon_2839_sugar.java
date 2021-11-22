package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2839_sugar {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i = N / 5; i >= 0; i--) {
			if((N - (i * 5)) % 3 == 0) {
				System.out.println(i + ((N - (i*5)) /3));
				return;
			}
		}
		
		System.out.println(-1);
		
	}
}
