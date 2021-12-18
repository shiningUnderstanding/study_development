package recursiveFunction;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_6603_germanLotto {
	static int k;
	static int[] numbers;
	static boolean[] picks;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) {
				break;
			}
			numbers = new int[k];
			picks = new boolean[k];
			for(int i = 0; i < k; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			pick(0, 0);
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	public static void pick(int start, int depth) {
		if(depth == 6) {
			for(int i = 0; i < k; i++) {
				if(picks[i]) {
					sb.append(numbers[i]).append(' ');
				}
			}
			sb.append('\n');
			return;
		}
		
		for(int i = start; i < k; i++) {
			picks[i] =true;
			pick(i + 1, depth + 1);
			picks[i] = false;
		}
	}
}
