package BackTracking;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Baekjoon_15651_nnm3 {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] pick;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pick = new int[M];
		pickNumbers(0);
		System.out.println(sb);
	}
	
	static void pickNumbers(int depth) {
		if(depth == M) {
			for(int number : pick) {
				sb.append(number).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			pick[depth] = i;
			pickNumbers(depth + 1);
		}
	}
}
