package sort;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Baekjoon_18870_coordinateCompression {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] x = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i = 0; i < N; i++) {
			count = 0;
			for(int j = 0; j < N; j++) {
				if(x[i] > x[j]) {
					count++;
				}
			}
			sb.append(count).append(' ');
		}
		
		System.out.println(sb);
	}
}
