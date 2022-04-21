package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_14888_MixOperator {
	static int[] operator = new int[4];
	static int[] number;
	static int N;
	static int min = 1000000000;
	static int max = -1000000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		minmax(number[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void minmax(int result, int idx) {
		if(idx == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				
				switch(i) {
				case 0 : minmax(result + number[idx], idx + 1);
					break;
				case 1 : minmax(result - number[idx], idx + 1);
					break;
				case 2 : minmax(result * number[idx], idx + 1);
					break;
				case 3 : minmax(result / number[idx], idx + 1);
					break;
				}
				
				operator[i]++;
			}
		}
	}
}
