package BackTracking;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Baekjoon_15650_combination {
	static int[] combination;
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		combination = new int[M];
		dfs(N, M, 1, 0);
		System.out.println(sb);
	}

	static void dfs(int N, int M, int start, int depth) {
		if (M == depth) {
			for (int i = 0; i < M; i++) {
				sb.append(combination[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = start; i <= N; i++) {
			combination[depth] = i;
			dfs(N, M, start + 1, depth + 1);
		}
	}
}
