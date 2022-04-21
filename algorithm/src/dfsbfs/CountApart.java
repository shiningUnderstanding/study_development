package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class CountApart {
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int n;
	static boolean[][] visited;
	static ArrayList<Integer> answer = new ArrayList<Integer>(); 
	static int count = 0; 

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String row = br.readLine();
			for(int j = 0; j < n; j++) {
				if(row.charAt(j) == '1') {
					visited[i][j] = true; 
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				count = 0;
				if(visited[i][j]) {
					count++;
					visited[i][j] = false;
					dfs(i, j);
					answer.add(count);
				}
			}
		}
		
		Collections.sort(answer);
		StringBuilder sb = new StringBuilder();
		sb.append(answer.size()).append('\n');
		for(int i=0; i<answer.size(); i++) {
			sb.append(answer.get(i)).append('\n');
		}
		System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		int nx, ny;
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if(visited[nx][ny]) {
					count++;
					visited[nx][ny] = false;
					dfs(nx, ny);
				}
			}
		}
	}
}
