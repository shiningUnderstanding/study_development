package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_10989_sort3 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[10001];
		
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 10001; i++) {
			for(int j = 0; j < arr[i]; j++) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}