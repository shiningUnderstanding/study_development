package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon_2798_blackjack {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		//M이랑 제일 가까운 수
		int sum = 0;
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j ++) {
				for(int k = j + 1; k < N; k++) {
					int temp = cards[i] + cards[j] + cards[k];
					
					if(M == temp) {
						sum = temp;
						break;
					}
					
					if(temp > sum && temp < M) {
						sum = temp;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
