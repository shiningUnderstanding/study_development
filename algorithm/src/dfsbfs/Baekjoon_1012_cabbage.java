package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1012_cabbage {
	static boolean[][] field;
	static int count;
	static int[] directionX = {1, 0, -1, 0};
	static int[] directionY = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i = 0; i < test; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			field = new boolean[M][N];
			
			for(int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				field[a][b] = true;
			}
			
			for(int k = 0; k < M; k++) {
				for(int l = 0; l < N; l++) {
					
				}
			}
		}
	}
}
