package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
		
		int[] copy = x.clone();
		Arrays.sort(copy);
		
		
		Map<Integer, Integer> xSort = new HashMap<>();
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(i > 0 && copy[i] == copy[i - 1]) {
				count--;
			}
			xSort.put(copy[i], count++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(xSort.get(x[i])).append(' ');
		}
		
		System.out.println(sb);
	}
}
