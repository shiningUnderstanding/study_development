package recursiveFunction;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_6603_germanLotto {
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k == 0) {
				break;
			}
			int[] numbers = new int[k];
			for(int i = 0; i < k; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			pick(numbers, k);
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	public static void pick(int[] numbers, int length) {
		int[] picks = new int[length - 1];
		if(length == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(numbers[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < length; i++) {
			int index = 0;
			for(int j = 0; j < length - 1; j++) {
				if(length - 1 - index == i) {
					index++;
				}
				picks[j] = numbers[index];
				index++;
			}
			pick(picks, length - 1);
		}
	}
}
