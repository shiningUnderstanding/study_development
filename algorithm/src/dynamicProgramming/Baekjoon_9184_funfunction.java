package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_9184_funfunction{
	static int[][][] abc = new int[21][21][21];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c == -1) {
				break;
			}
			
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int w(int a, int b, int c) {
		if(0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20 && abc[a][b][c] != 0) {
			return abc[a][b][c];
		}
		
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}else if( a > 20 || b > 20 || c > 20) {
			return abc[20][20][20] = w(20, 20, 20);
		}else if(a < b && b < c) {
			return abc[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}else {
			return abc[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c-1) - w(a - 1, b - 1, c - 1);
		}
	}
}
