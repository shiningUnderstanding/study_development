package backTracking;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15652_nn4 {
	public static int N, M;
	public static int[] line;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		line = new int[M];
		
		dfs(1, 0);
		System.out.println(sb);
	}
	
	public static void dfs(int start, int depth) {
		if(depth == M) {
			for(int n : line) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = start; i <= N; i++) {
			line[depth] = i;
			dfs(i, depth + 1);
		}
	}
}
