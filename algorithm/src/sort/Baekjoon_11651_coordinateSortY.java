package sort;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Baekjoon_11651_coordinateSortY {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] coordinate = new int[N][2];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			coordinate[i][0] = Integer.parseInt(st.nextToken());
			coordinate[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(coordinate, (c1, c2) -> {
			if(c1[1] == c2[1]) {
				return c1[0] - c2[0];
			}else {
				return c1[1] - c2[1];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(coordinate[i][0]).append(' ').append(coordinate[i][1]).append('\n');
		}
		
		System.out.println(sb);
	}
}
