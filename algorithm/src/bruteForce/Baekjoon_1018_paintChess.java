package bruteForce;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Baekjoon_1018_paintChess {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean[][] chess = new boolean[N][M];
		String s;
		
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			for(int j = 0; j < M; j++) {
				if(s.charAt(j) == 'B') {
					chess[i][j] = true;
				}
			}
		}
		
		System.out.println(check(chess));	
	}
	
	static int check(boolean[][] chess) {
		int result = M * N;
		int count1;
		int count2;
		boolean flag;
		
		for(int i = 0; i < N - 7; i++) {
			for(int j = 0; j < M - 7; j++) {
				count1 = 0;
				count2 = 0;
				flag = chess[i][j];
				for(int k = 0; k < 8; k++) {
					for(int l = 0; l < 8; l++) {
						if(flag != chess[i + k][j + l]) {
							count1++;
						}else {
							count2++;
						}
						flag = !flag;
					}
					flag = !flag;
				}
				if(count1 == 0 || count2 == 0) {
					return 0;
				}else {
					if(count1 < result) {
						result = count1;
					}
					if(count2 < result) {
						result = count2;
					}
				}
			}
		}
		
		return result;
	}
}
