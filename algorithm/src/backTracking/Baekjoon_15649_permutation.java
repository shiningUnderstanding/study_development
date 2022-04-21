package backTracking;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Baekjoon_15649_permutation {
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;
	static int[] sequence;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visit = new boolean[N];
		sequence = new int[M];
		permutation(N, M, 0);
		System.out.println(sb);
	}
	
	static void permutation(int start, int end, int depth) {
		if(depth == end) {
			for(int val : sequence) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < start; i++) {
			if(!visit[i]) {
				visit[i] = true;
				sequence[depth] = i + 1;
				permutation(start, end, depth + 1);
				visit[i] = false;
			}
		}
	}
}
