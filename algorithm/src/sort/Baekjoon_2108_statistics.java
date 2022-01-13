package sort;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Baekjoon_2108_statistics {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[8001];
		// index 0 -> -4000, index 4000 -> 0, index 8001-> 4000; 
		
		double sum = 0;
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			numbers[n + 4000]++;
			sum += n;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(Math.round(sum / N)).append("\n");
		
		int mid = N / 2 + 1;
		int median = 0;
		
		int mod = 0;
		int mod_idx = 0;
		boolean flag = false;
		
		int min = 8001;
		int max = 0;
		
		
		for(int i = 0; i < 8001; i++) {
			if(mid > 0) {
				mid -= numbers[i];
				median = i;
			}
			if(mod < numbers[i]) {
				mod = numbers[i];
				mod_idx = i;
				flag = true;
			}else if(mod == numbers[i] && flag == true) {
				mod = numbers[i];
				mod_idx = i;
				flag = false;
			}
			if(numbers[i] != 0) {
				if(i < min) {
					min = i;
				}
				if(i > max) {
					max = i;
				}
			}
		}
		sb.append(median - 4000).append("\n").append(mod_idx - 4000).append("\n").append(max - min);
		System.out.println(sb);
	}
}
