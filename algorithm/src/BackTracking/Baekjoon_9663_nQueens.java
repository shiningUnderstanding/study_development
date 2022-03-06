package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_9663_nQueens {
	public static int[] line;
	public static int N;
	public static int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs(0);
	} 
	
	public static void dfs(int depth) {
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			line[depth] = i;
			if(check(depth)) {
				dfs(depth + 1);
			}
		}
	}
	
	public static boolean check(int col) {
		
		return true;
	}
}
