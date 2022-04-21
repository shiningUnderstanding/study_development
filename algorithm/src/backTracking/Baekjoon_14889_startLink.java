package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_14889_startLink {
	static int N;
	static boolean[] visited;
	static int[][] abilities;
	
	static int Min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		abilities = new int[N][N];
		visited = new boolean[N];
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				abilities[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, 0);
		System.out.println(Min);
	}
	
	static void combination(int idx, int count) {
		if(count == N / 2) {
			different();
			return;
		}
		
		for(int i = idx; i < N; i++) {
			if(!visited[i]) {
				visited[i] =true;
				combination(i + 1, count + 1);
				visited[i] = false;
			}
		}
	}
	
	static void different() {
		int start = 0;
		int link = 0;
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] == true && visited[j] == true) {
					start += abilities[i][j];
					start += abilities[j][i];
				}
				else if (visited[i] == false && visited[j] == false) {
					link += abilities[i][j];
					link += abilities[j][i];
				}
			}
		}
		
		int value = Math.abs(start - link);
		
		if(value == 0) {
			System.out.println(value);
			System.exit(0);
		}
		
		Min = Math.min(value, Min);
	}
}
