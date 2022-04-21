package dfsbfs;

import java.io.*;
import java.util.*;

public class DfsBfs {
	static boolean visited[];
	static boolean[][] graph;
	static int node, line;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		graph = new boolean[node + 1][node + 1];
		visited = new boolean[node + 1];
		
		for(int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			graph[node1][node2] = true;
			graph[node2][node1] = true;
		}
		
		dfs(start);
		visited = new boolean[node + 1];
		sb.append('\n');
		bfs(start);
		System.out.println(sb);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		sb.append(start).append(' ');
		
		for(int i = 1; i < node + 1; i++) {
			if(graph[start][i] && !visited[i]) {
				dfs(i);
			}
		}
	};
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		sb.append(start).append(' ');
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			
			for(int i = 1; i < node + 1; i++) {
				if(graph[temp][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					sb.append(i).append(' ');
				}
			}
		}
	};
}
