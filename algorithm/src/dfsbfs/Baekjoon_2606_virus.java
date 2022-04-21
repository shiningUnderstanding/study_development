package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2606_virus {
	static int N;
	static boolean[] visited;
	static boolean[][] network;
	static int count = 0;
	
	public static void main(String[] agrs) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int size = Integer.parseInt(br.readLine());
		
		visited = new boolean[N + 1];
		network = new boolean[N + 1][N + 1];
		
		StringTokenizer st;
		
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			network[a][b] = network[b][a] = true;
		}
		
		bfs(1);
		
		System.out.println(count);
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int i = 1; i <= N; i++) {
				if(network[temp][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					count++;
				}
			}
		}
	}
}
