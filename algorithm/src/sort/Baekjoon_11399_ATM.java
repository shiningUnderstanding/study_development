package sort;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Baekjoon_11399_ATM {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[1001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			count[Integer.parseInt(st.nextToken())]++;
		}
		int time = 0;
		int sum = 0;
		for(int i = 1; i < 1001; i++) {
			for(int j = 0; j < count[i]; j++) {
				time += i;
				sum += time;
			}
		}
		System.out.println(sum);
	}
}
